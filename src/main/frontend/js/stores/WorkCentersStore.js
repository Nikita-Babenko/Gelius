import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class WorkCentersStore extends EventEmitter {
    constructor() {
        super();
        this.selectedWorkCenters = this.__initWorkCenters();
        this.selectedCentersText = "центры не выбраны";
    }

    emitChange() {
        this.emit(EventConstants.WORK_CENTERS_CHANGE_EVENT);
    }

    getSelectedCentersText() {
        return this.selectedCentersText;
    }

    __prepareTextOfSelectedWorkCenters() {
        var text = "";
        var centers = this.selectedWorkCenters;
        for (var key in centers) {
            if (centers[key].length > 0) {
                centers[key].forEach(function (item, i) {
                    if (i > 0) {
                        text += '/';
                    }
                    text += item.serviceCenter;
                });
                text += "      ";
            }
        }
        return text;
    }

    __initWorkCenters() {
        return {
            group1: [], group2: [], group3: [], group6: [], other: []
        };
    }


}

const workCentersStore = new WorkCentersStore();

workCentersStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.UPDATE_WORKABILITY_INFO:
            workCentersStore.selectedCentersText = workCentersStore.__prepareTextOfSelectedWorkCenters();
            workCentersStore.emitChange();
            break;
        case EventConstants.ADD_WORK_CENTER:
            var centers = workCentersStore.selectedWorkCenters;
            var center = event.workCenter;
            switch (center.groupPriority) {
                case 10:
                    centers.group1.push(center);
                    break;
                case 20:
                    centers.group2.push(center);
                    break;
                case 30:
                    centers.group3.push(center);
                    break;
                case 60:
                    centers.group6.push(center);
                    break;
                default:
                    centers.other.push(center)
            }
            break;
        case EventConstants.DELETE_WORK_CENTER:
            var centers = workCentersStore.selectedWorkCenters;
            var center = event.workCenter;
            switch (center.groupPriority) {
                case 10:
                    centers.group1.splice($.inArray(center, centers.group1), 1);
                    break;
                case 20:
                    centers.group2.splice($.inArray(center, centers.group2), 1);
                    break;
                case 30:
                    centers.group3.splice($.inArray(center, centers.group3), 1);
                    break;
                case 60:
                    centers.group6.splice($.inArray(center, centers.group6), 1);
                    break;
                default:
                    centers.other.splice($.inArray(center, centers.other), 1);
            }
            break;
    }
});

export default workCentersStore;