import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class ImagesStore extends EventEmitter {
    constructor() {
        super();
        this.images = [];
        this.selectedImageId = {
            previous: null,
            current: null
        }
    }

    emitChange() {
        this.emit(EventConstants.IMAGES_CHANGE_EVENT);
    }

    getImages() {
        return this.images;
    }

    getSelectedImageId() {
        return this.selectedImageId;
    }

}

const imagesStore = new ImagesStore();

imagesStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.ADD_IMAGE:
            imagesStore.images.push(event.image);
            imagesStore.emitChange();
            break;
        case EventConstants.REMOVE_IMAGE:
            imagesStore.images.splice(event.imageId, 1);
            imagesStore.selectedImageId.previous = imagesStore.selectedImageId.current = null;
            imagesStore.emitChange();
            break;
        case EventConstants.SELECT_IMAGE:
            imagesStore.selectedImageId.previous = imagesStore.selectedImageId.current;
            imagesStore.selectedImageId.current = event.imageId;
            imagesStore.emitChange();
            if (imagesStore.selectedImageId.previous === imagesStore.selectedImageId.current) {
                imagesStore.selectedImageId.previous = imagesStore.selectedImageId.current = null;
                imagesStore.emitChange();
            }
            break;

    }
});

export default imagesStore;