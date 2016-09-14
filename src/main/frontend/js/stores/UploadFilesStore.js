import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import DictionaryStore from './DictionariesStore';
import NewProductAction from '../actions/NewProductActions';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

class UploadFilesStore extends EventEmitter {
    constructor() {
        super();
        this.MAX_FILES_COUNT = 5;
        this.filesCount = 0;
        this.deleteSelectedFiles = false;
    }

    emitChange() {
        this.emit(EventConstants.FILE_LINKS_CHANGE_EVENT);
    }

    isDeleteSelectedFiles() {
        return this.deleteSelectedFiles;
    }

}

const uploadFilesStore = new UploadFilesStore();

uploadFilesStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.ADD_FILE_LINK:
            if ( uploadFilesStore.filesCount == uploadFilesStore.MAX_FILES_COUNT) {
                console.log("Установлено ограничение в " + uploadFilesStore.MAX_FILES_COUNT + " файлов.");
            } else {
                uploadFilesStore.filesCount++;
                uploadFilesStore.emitChange();
            }
            break;
        case EventConstants.REMOVE_FILE_LINK:
            uploadFilesStore.filesCount--;
            uploadFilesStore.emitChange();
            break;
        case EventConstants.SELECTED_FILES_WERE_SAVED:
            uploadFilesStore.deleteSelectedFiles = true;
            uploadFilesStore.emitChange();
            uploadFilesStore.deleteSelectedFiles = false;
            break;
    }
});

export default uploadFilesStore;