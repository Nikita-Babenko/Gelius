import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

class DictionaryStore extends EventEmitter {
    constructor() {
        super();
        this.allDictionaryParameters = {};
    }

    emitChange() {
        this.emit(EventConstants.DICTIONARIES_CHANGE_EVENT);
    }

    getDictionaryParameters(dictionaryName) {
        return this.allDictionaryParameters[dictionaryName];
    }

    getAgregatorWorkCenter() {
        var centers = this.allDictionaryParameters["workability"];
        for (var i = 0; i < centers.length; i++) {
            if (centers[i].id == ObjectConstants.dictionaries.WORKCENTER_AGREGATOR_ID) {
                return centers[i];
            }
            console.log("Workcenter Agregator not found.");
        }
    }

}

const dictionaryStore = new DictionaryStore();

dictionaryStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.LOAD_ALL_DICTIONARIES:
            dictionaryStore.allDictionaryParameters = event.parameters;
            dictionaryStore.emitChange();
            break;
    }
});

export default dictionaryStore;