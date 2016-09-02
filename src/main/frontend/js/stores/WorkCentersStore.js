import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import DictionaryStore from './DictionariesStore';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

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

    getSelectedCenters() {
        return this.selectedWorkCenters;
    }

    __prepareTextOfSelectedWorkCenters() {
        var text = "";
        var centers = this.selectedWorkCenters;
        var isAgregatorGroup = false;

        for (var key in centers) {
            if (centers[key].length > 0) {

                centers[key].forEach(function (item, i) {
                    if (item.id == ObjectConstants.dictionaries.WORKCENTER_AGREGATOR_ID) { //it is Agregator
                        isAgregatorGroup = true;
                        return;
                    }
                    if (i > 0) {
                        text += '/';
                    }
                    text += item.serviceCenter;
                });

                if (!isAgregatorGroup) {
                    text += "      ";
                } else {
                    isAgregatorGroup = false;
                }

            }
        }
        return text;
    }

    __initWorkCenters() {
        return {
            group0: this.createWorkCentersGroup(), //for Agregator
            group10: this.createWorkCentersGroup(),
            group20: this.createWorkCentersGroup(),
            group30: this.createWorkCentersGroup(),
            group40: this.createWorkCentersGroup(),
            group50: this.createWorkCentersGroup(),
            group60: this.createWorkCentersGroup(),
            group70: this.createWorkCentersGroup(),
            group80: this.createWorkCentersGroup(),
            group90: this.createWorkCentersGroup(),
            group100: this.createWorkCentersGroup()
        };
    }

    createWorkCentersGroup() {
        return [];
    }


}

const workCentersStore = new WorkCentersStore();

workCentersStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.LOAD_ALL_DICTIONARIES:
            Dispatcher.waitFor([ DictionaryStore.dispatchToken ]);
            var agregatorCenter = DictionaryStore.getAgregatorWorkCenter();
            workCentersStore.selectedWorkCenters["group0"].push(agregatorCenter);
            //There are no operator "break" here, because we need UPDATE_WORKABILITY_INFO-operations immediately after
            // LOAD_ALL_DICTIONARIES for displaying Agregator in Notes.
        case EventConstants.UPDATE_WORKABILITY_INFO:
            workCentersStore.selectedCentersText = workCentersStore.__prepareTextOfSelectedWorkCenters();
            workCentersStore.emitChange();
            break;
        case EventConstants.ADD_WORK_CENTER:
            var centers = workCentersStore.selectedWorkCenters;
            var center = event.workCenter;
            var groupName = "group" + center.groupPriority;
            if (centers[groupName] !== undefined) {
                centers[groupName].push(center);
            }
            break;
        case EventConstants.DELETE_WORK_CENTER:
            var centers = workCentersStore.selectedWorkCenters;
            var center = event.workCenter;
            var groupName = "group" + center.groupPriority;
            if (centers[groupName] !== undefined) {
                centers[groupName].splice($.inArray(center, centers[groupName]), 1);
            }
            break;
    }
});

export default workCentersStore;