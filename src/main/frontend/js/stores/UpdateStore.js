import EventEmitter from "eventemitter3";
import Dispatcher from "../dispatcher/Dispatcher";
import EventConstants from "../constants/Events";

class UpdateStore extends EventEmitter {
    constructor() {
        super();
        this.workpieceWidth = {};
        this.productionFormat = null;
    }

    emitChange() {
        this.emit(EventConstants.UPDATE_CHANGE_EVENT);
    }

    getWorkpieceWidthData() {
        return this.workpieceWidth;
    }

    getProductionFormat() {
        return this.productionFormat;
    }

}

const updateStore = new UpdateStore();

updateStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.UPDATE_WORKPIECE_WIDTH:
            updateStore.workpieceWidth.value = event.value;
            updateStore.workpieceWidth.isDisabled = event.isDisabled;
            updateStore.emitChange();
            updateStore.workpieceWidth = {};
            break;
        case EventConstants.UPDATE_PRODUCTION_FORMAT:
            updateStore.productionFormat = event.recommendedFormat;
            updateStore.emitChange();
            updateStore.productionFormat = null;
            break;
    }
});

export default updateStore;