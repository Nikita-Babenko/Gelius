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
    }

    emitChange() {
        this.emit(EventConstants.FILE_LINKS_CHANGE_EVENT);
    }

}

const uploadFilesStore = new UploadFilesStore();

uploadFilesStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.ADD_FILE_LINK:
            if ( false /*uploadFilesStore.filesCount == uploadFilesStore.MAX_FILES_COUNT*/ ) { //temp!
                alert("Установлено ограничение в " + uploadFilesStore.MAX_FILES_COUNT + " файлов.");
            } else {
                uploadFilesStore.filesCount++;
                //some actions, when link was added...
                console.log("uploadFilesStore.filesCount=" + uploadFilesStore.filesCount + " (элемент добавлен)");
                uploadFilesStore.emitChange();
            }
            break;
        case EventConstants.REMOVE_FILE_LINK:
            uploadFilesStore.filesCount--;
            //some actions, when link was removing...
            console.log("uploadFilesStore.filesCount=" + uploadFilesStore.filesCount + " (элемент удален)");
            uploadFilesStore.emitChange();
            break;
        /*case EventConstants.SAVE_FILE_LINKS_OF_NEW_PRODUCT:
            console.log("UploadFilesStore.dispatchToken: файлы-ссылки сохранены на сервере");
            break;*/
    }
});

export default uploadFilesStore;