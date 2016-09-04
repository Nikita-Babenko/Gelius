import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import DictionaryStore from './DictionariesStore';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

class WorkCentersStore extends EventEmitter {
    constructor() {
        super();
        //Inner elements:
        this.CENTERS_ARRAY_PROPNAME = "centersList";

        this.selectedWorkCenters = this.__initWorkCenters();
        this.selectedCentersText = "";
    }

    emitChange() {
        this.emit(EventConstants.WORK_CENTERS_CHANGE_EVENT);
    }

    getSelectedCentersText() {
        return this.selectedCentersText;
    }

    getSelectedCenters() {
        var selectedWorkCenters = {};
        for (var groupName in this.selectedWorkCenters) {
            selectedWorkCenters[groupName] = this.selectedWorkCenters[groupName][this.CENTERS_ARRAY_PROPNAME];
        }
        return selectedWorkCenters;
    }

    __prepareTextOfSelectedWorkCenters() {
        var text = "";
        var centers = this.selectedWorkCenters;
        var isAgregatorGroup = false;

        for (var groupName in centers) {
            if (centers[groupName][this.CENTERS_ARRAY_PROPNAME].length > 0) {

                centers[groupName][this.CENTERS_ARRAY_PROPNAME].forEach(function (item, i) {
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
            group0: this.__createWorkCentersGroupObject(), //for Agregator
            group10: this.__createWorkCentersGroupObject(),
            group20: this.__createWorkCentersGroupObject(),
            group30: this.__createWorkCentersGroupObject(),
            group40: this.__createWorkCentersGroupObject(),
            group50: this.__createWorkCentersGroupObject(),
            group60: this.__createWorkCentersGroupObject(),
            group70: this.__createWorkCentersGroupObject(),
            group80: this.__createWorkCentersGroupObject(),
            group90: this.__createWorkCentersGroupObject(),
            group100: this.__createWorkCentersGroupObject()
        };
    }

    __createWorkCentersGroupObject() {
        var obj = { note: null };
        obj[this.CENTERS_ARRAY_PROPNAME] = [];
        return obj;
    }


}

const workCentersStore = new WorkCentersStore();

workCentersStore.dispatchToken = Dispatcher.register(function (event) {
    var centersArrayPropName = workCentersStore.CENTERS_ARRAY_PROPNAME;
    var centers = workCentersStore.selectedWorkCenters;
    switch (event.eventType) {
        case EventConstants.LOAD_ALL_DICTIONARIES:
            Dispatcher.waitFor([ DictionaryStore.dispatchToken ]);
            var aggregatorCenter = DictionaryStore.getAgregatorWorkCenter();
            workCentersStore.selectedWorkCenters["group0"][centersArrayPropName].push(aggregatorCenter);
            //There is no operator "break" here, because we need UPDATE_WORKABILITY_INFO-operations immediately after
            // LOAD_ALL_DICTIONARIES for displaying Agregator in Notes.
        case EventConstants.UPDATE_WORKABILITY_INFO:
            workCentersStore.selectedCentersText = workCentersStore.__prepareTextOfSelectedWorkCenters();
            workCentersStore.emitChange();
            break;
        case EventConstants.ADD_WORK_CENTER:
            var center = event.workCenter;
            var groupName = "group" + center.groupPriority;
            if (centers[groupName] !== undefined) {
                centers[groupName][centersArrayPropName].push(center);
            }
            break;
        case EventConstants.DELETE_WORK_CENTER:
            var center = event.workCenter;
            var groupName = "group" + center.groupPriority;
            if (centers[groupName] !== undefined) {
                centers[groupName][centersArrayPropName].splice(
                    $.inArray(center, centers[groupName][centersArrayPropName]), 1
                );
            }
            break;
        case EventConstants.UPDATE_WORK_CENTER_NOTE:
            var groupName = "group" + event.groupPriority;
            if (centers[groupName] !== undefined) {
                centers[groupName]["note"] = event.note;
            }
            break;
    }
});

export default workCentersStore;