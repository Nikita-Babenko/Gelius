import EventEmitter from "eventemitter3";
import Dispatcher from "../dispatcher/Dispatcher";
import NewProductStore from "./NewProductStore";
import EventConstants from "../constants/Events";

class WorkCentersStore extends EventEmitter {
    constructor() {
        super();
        this.defaultWorkCenters = [];
        this.useDefault = true;
    }

    emitChange() {
        this.emit(EventConstants.WORK_CENTERS_CHANGE_EVENT);
    }

    getSelectedCentersText() {
        return this.__prepareTextOfSelectedWorkCenters();
    }

    getSelectedWorkCenters() {
        return this.__prepareSelectedWorkCenters();
    }

    setUseDefautCenters(value) {
        this.useDefault = value;
    }

    __getDefaultWorkCenters() {
        var defaultWorkCenters = this.defaultWorkCenters;
        var workCenters = [];
        defaultWorkCenters.map(function (center) {
            workCenters.push(center);
        });
        return workCenters;
    }

    getWorkCenterNotes() {
        var workCenters = [];
        workCenters.push({
            "serviceCenter": {
                "id": 1,
                "serviceCenter": "АГ",
                "groupPriority": 0
            },
            note: $('[data-group=0].notes-textarea').val()
        });

        $(".work-centers-checkbox:checked").each(function () {
            var group = $(this).data('group');
            workCenters.push({
                serviceCenter: {
                    id: $(this).attr('id'),
                    serviceCenter: $(this).attr('name'),
                    groupPriority: group
                },
                note: $('[data-group='+ group +'].notes-textarea').val()
            });
        });
        return workCenters;
    }

    __prepareSelectedWorkCenters() {
        var workCenters = this.__initWorkCenters();
        var selectedCenters = this.useDefault ? this.__getDefaultWorkCenters() : this.getWorkCenterNotes();

        selectedCenters.map(function (center) {
            workCenters['group' + center.serviceCenter.groupPriority].centers.push(center);
            workCenters['group' + center.serviceCenter.groupPriority].note = center.note;
        });

        return workCenters;
    }

    __prepareTextOfSelectedWorkCenters() {
        var text = "";
        var centers = this.__prepareSelectedWorkCenters();

        for (var group in centers) {
            if (group != 'group0' && centers[group].centers.length > 0) {
                centers[group].centers.map(function (center, index) {
                    if (index > 0)
                        text += '/';
                    text += center.serviceCenter.serviceCenter;
                });
                text += "     ";
            }
        }
        return text;
    }

    __initWorkCenters() {
        return {
            group0: this.__createWorkCentersGroupObject(),
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
        return {
            centers: [],
            note: null
        };
    }
}

const workCentersStore = new WorkCentersStore();

workCentersStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.UPDATE_PRODUCIBILITY_INFO:
            workCentersStore.defaultWorkCenters = NewProductStore.getProductProperty("producibilityNotes");
            workCentersStore.emitChange();
            break;
    }
});

export default workCentersStore;