import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class ImagesStore extends EventEmitter {
    constructor() {
        super();
        this.images = [];
        this.imagesToDelete = [];
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

    getCountOfImages() {
        return this.images.length;
    }

    initData(images) {
        var self = this;
        if (images)
            $.each(images, function (index, url) {
                var image = {
                    file: null,
                    url: url
                };
                self.images.push(image);
            });
        else
            self.images = [];
        this.imagesToDelete = [];
        this.emitChange();
    }

    getImagesToSave() {
        var allImages = this.images;
        var imagesToSave = [];
        for (var i = 0; i < allImages.length; i++) {
            if (allImages[i].file !== null)
                imagesToSave.push(allImages[i].file);
        }
        return imagesToSave;
    }

    getImagesToDelete() {
        return this.imagesToDelete;
    }

    getSelectedImageId() {
        return this.selectedImageId;
    }

    __removeSavedImage(imageId) {
        if (this.images[imageId].file === null) {
            var url = this.images[imageId].url;
            var imageName = url.indexOf("/") >= 0 ? url.split("/").pop() : url.split("\\").pop();
            this.imagesToDelete.push(imageName);
        }
    }

}

const imagesStore = new ImagesStore();

imagesStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.INIT_IMAGE_STORE:
            imagesStore.images = [];
            imagesStore.imagesToDelete = [];
            imagesStore.emitChange();
            break;
        case EventConstants.ADD_IMAGE:
            imagesStore.images.push(event.image);
            imagesStore.emitChange();
            break;
        case EventConstants.REMOVE_IMAGE:
            imagesStore.__removeSavedImage(event.imageId);
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