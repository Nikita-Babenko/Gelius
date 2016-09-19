import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import DictionaryStore from './DictionariesStore';
import NewProductAction from '../actions/NewProductActions';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

class UploadFilesStore extends EventEmitter {
    constructor() {
        super();
        this.deleteSelectedFiles = false;
        this.fileLinksToDelete = [];
    }

    emitChange() {
        this.emit(EventConstants.FILE_LINKS_CHANGE_EVENT);
    }

    isDeleteSelectedFiles() {
        return this.deleteSelectedFiles;
    }

    getFileLinksToDelete() {
        return this.fileLinksToDelete;
    }

}

const uploadFilesStore = new UploadFilesStore();

uploadFilesStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.ADD_FILE_LINK:
            uploadFilesStore.emitChange();
            break;
        case EventConstants.REMOVE_FILE_LINK:
            var fileName = event.link.indexOf("/") >= 0 ? event.link.split("/").pop() : event.link.split("\\").pop();
            uploadFilesStore.fileLinksToDelete.push(fileName);
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