import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class DictionaryStore extends EventEmitter {
    constructor() {
        super();
        this.allDictionaryParameters = {};
    }

    onChange(listener, context) {
        this.on(EventConstants.DICTIONARIES_CHANGE_EVENT, listener, context);
    }

    offChange(listener, context) {
        this.removeListener(EventConstants.DICTIONARIES_CHANGE_EVENT, listener, context);
    }

    emitChange() {
        this.emit(EventConstants.DICTIONARIES_CHANGE_EVENT);
    }

    getDictionaryParameters(dictionaryName) {
        return this.allDictionaryParameters[dictionaryName];
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