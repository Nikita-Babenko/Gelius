import Dispatcher from "../dispatcher/Dispatcher";
import UrlConstants from "../constants/Url";
import EventConstants from "../constants/Events";
import NewProductStore from "../stores/NewProductStore";
import UploadFilesStore from "../stores/UploadFilesStore";
import WorkCentersStore from "../stores/WorkCentersStore";
import ImagesStore from "../stores/ImagesStore";
import ObjectConstants from "../constants/Objects";
import ProductRegisterActions from "./ProductRegisterActions";
import FilteringSortingActions from "./FilteringSortingActions";
import L from "../utils/Logging";

var NewProductActions = {

    loadAllDictionaries () {
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: UrlConstants.LOAD_ALL_DICTIONARIES_URL,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                if (!response["data"]) {
                    L.log("Empty 'data' in response on '" + UrlConstants.LOAD_ALL_DICTIONARIES_URL + "'");
                    return;
                }

                if (response["data"]) {
                    Dispatcher.dispatch({
                        eventType: EventConstants.LOAD_ALL_DICTIONARIES,
                        parameters: response.data
                    });
                }

            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
    },

    getOperationInfo() {
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: UrlConstants.GET_OPERATION_INFO_URL,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                if (!response["data"]) {
                    L.log("Empty response on '" + UrlConstants.GET_OPERATION_INFO_URL + "'");
                    return;
                }

                if (response["data"]) {
                    var operation = response.data.operation;
                    switch (operation) {
                        case EventConstants.CREATE_NEW_PRODUCT:
                            L.log("in CREATE_NEW_PRODUCT section");
                            Dispatcher.dispatch({
                                eventType: EventConstants.CREATE_NEW_PRODUCT,
                                newProductNumber: this.loadNewProductNumber(),
                                operation: operation
                            });
                            break;
                        case EventConstants.EDIT_PRODUCT:
                            L.log("in EDIT_PRODUCT section");
                            var product = this.loadProductById(response.data.productId);
                            Dispatcher.dispatch({
                                eventType: EventConstants.EDIT_PRODUCT,
                                product: product,
                                productNumber: this.loadEditableProductNumber(product.productNumber, product.isNew),
                                operation: operation
                            });
                            break;
                        case EventConstants.COPY_PRODUCT:
                            L.log("in COPY_PRODUCT section");
                            Dispatcher.dispatch({
                                eventType: EventConstants.COPY_PRODUCT,
                                product: this.loadProductById(response.data.productId),
                                newProductNumber: this.loadNewProductNumber(),
                                operation: operation
                            });
                            break;
                    }
                    WorkCentersStore.setUseDefautCenters(true);
                    this.updateProducibilityInfo();
                }

            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
    },

    loadNewProductNumber() {
        var number = "";
        $.ajax({
            type: 'GET',
            async: false,
            contentType: "application/json",
            url: UrlConstants.LOAD_FULL_NUMBER_FOR_NEW_PRODUCT_URL,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                number = response.data;
            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
        return number;
    },

    loadEditableProductNumber(productNumber, isNew) {
        var number = "";
        $.ajax({
            type: 'GET',
            async: false,
            contentType: "application/json",
            url: UrlConstants.LOAD_FULL_NUMBER_FOR_EDITABLE_PRODUCT_URL + productNumber + "/" + isNew,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                number = response.data;
            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
        return number;
    },

    loadProductById(productId) {
        var product = {};
        $.ajax({
            type: 'GET',
            async: false,
            contentType: "application/json",
            url: UrlConstants.LOAD_PRODUCT_BY_ID_URL + productId,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                product = response.data;
            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
        return product;
    },

    deleteProductById(productId, redirectToRegister){
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: UrlConstants.DELETE_PRODUCT_BY_ID_URL + productId,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                L.log("PRODUCT [number " + response.data + "] was deleted");

                if (redirectToRegister)
                    window.location = UrlConstants.PRODUCT_REGISTER_URL;
                else {
                    ProductRegisterActions.loadProductsFromServer();
                    FilteringSortingActions.loadAllFilterParametersFromServer();
                }

            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
    },

    saveProduct(){
        var url;
        var productToSave = NewProductStore.getNewProduct();
        productToSave["producibilityNotes"] = WorkCentersStore.getWorkCenterNotes();

        if (NewProductStore.isInEditMode()) {
            url = UrlConstants.UPDATE_PRODUCT_URL;
            productToSave["id"] = NewProductStore.getProductProperty("id");
        } else {
            url = UrlConstants.SAVE_PRODUCT_URL;
        }

        L.log(productToSave);
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(productToSave),
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                Dispatcher.dispatch({
                    eventType: EventConstants.SAVE_NEW_PRODUCT,
                    response: response
                });

                if (response.code === 200) {
                    WorkCentersStore.setUseDefautCenters(true);
                    this.updateProducibilityInfo();
                    $(".notes-textarea").val("");
                    window.history.pushState("", "", '/products/newProduct');
                    L.log("product (" + response.data.savedProductNumber + ") was saved");
                    L.log("new product number (" + response.data.newProductNumber + ") was received");
                }
            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)

        });

    },

    updateProducibilityInfo() {
        Dispatcher.dispatch({
            eventType: EventConstants.UPDATE_PRODUCIBILITY_INFO
        });
    },

    saveFileLinks() {
        var savedProductNumber = NewProductStore.savedProductNumber;
        L.log("Number of saved product: " + savedProductNumber);

        var formData = new FormData();
        $(".attachments :file").each(function () {
            var file = this.files[0];
            if (typeof file !== "undefined") {
                var name = file.name, size = file.size, type = file.type;
                L.log("FILE: name=" + name + ", size=" + size + ", type=" + type);
                if (size > ObjectConstants.UPLOADED_FILE_SIZE_LIMIT) {
                    alert("Size of file is more then " + ObjectConstants.UPLOADED_FILE_SIZE_LIMIT + " (МБ)");
                }
                formData.append("files", file);
            }
        });
        formData.append("productNumber", savedProductNumber);
        var images = ImagesStore.getImagesToSave();
        for (let i = 0; i < images.length; i++)
            formData.append("images", images[i]);

        var deleteFileLinks = UploadFilesStore.getFileLinksToDelete();
        if (deleteFileLinks.length)
            for (let i = 0; i < deleteFileLinks.length; i++)
                formData.append("deleteFileLinks", deleteFileLinks[i]);
        else
            formData.append("deleteFileLinks", []);

        var deleteImages = ImagesStore.getImagesToDelete();
        if (deleteImages.length)
            for (let i = 0; i < deleteImages.length; i++)
                formData.append("deleteImages", deleteImages[i]);
        else
            formData.append("deleteImages", []);

        $.ajax({
            url: UrlConstants.SAVE_PRODUCT_FILES_URL,
            type: "POST",
            dataType: "json",
            data: formData,
            processData: false,
            contentType: false,
            success: function () {
                Dispatcher.dispatch({
                    eventType: EventConstants.SELECTED_FILES_WERE_SAVED
                });
                Dispatcher.dispatch({
                    eventType: EventConstants.INIT_IMAGE_STORE
                });
            },
            error: function (e) {
                L.log("ERROR during saving files: ", e);
            }
        });
    },

    addImage(image){
        Dispatcher.dispatch({
            eventType: EventConstants.ADD_IMAGE,
            image: image
        });
    },

    removeImage(imageID){
        Dispatcher.dispatch({
            eventType: EventConstants.REMOVE_IMAGE,
            imageId: imageID
        });
    },

    removeFileLink(link){
        Dispatcher.dispatch({
            eventType: EventConstants.REMOVE_FILE_LINK,
            link: link
        });
    },

    selectImage(imageID) {
        Dispatcher.dispatch({
            eventType: EventConstants.SELECT_IMAGE,
            imageId: imageID
        });
    },

    __disablePalletDictionaryDependsFromChangePacking(){
        var palletContext = $('#pallet');
        $('#packing').change(function () {
            if (this.value === '' || this.value === '1') {
                palletContext.prop("disabled", true);
                palletContext.val('');
            }
            else {
                palletContext.prop("disabled", false);
                palletContext.val('1');
            }
        });
    },

    __disablePalletDictionaryByDefault(){
        var value = $('#packing').find(':selected').val();
        if (value === '' || value === '1') {
            $('#pallet').prop("disabled", true);
        }
    },

    __defaultConnectionValveDictionaryDependsFromProductType(){
        $('#productType').change(function () {
            if (this.value === '1') {
                $('#connectionValve').val('1');
            }
            else $('#connectionValve').val('');
        });
    },

    updateWorkpieceWidth(isDisabled, value) {
        window.setTimeout(function () {
            Dispatcher.dispatch({
                eventType: EventConstants.UPDATE_WORKPIECE_WIDTH,
                isDisabled: isDisabled,
                value: value
            });
        }, 1)
    },

    updateProductionFormat(value) {
        Dispatcher.dispatch({
            eventType: EventConstants.UPDATE_PRODUCTION_FORMAT,
            recommendedFormat: value
        });
    },

    loadBigovkiAndPerforationDeltas(profileID) {
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: UrlConstants.LOAD_BIGOVKI_AND_PERFORATION_DELTAS + profileID,
            data: '',
            dataType: 'JSON',
            success: function (response) {
                Dispatcher.dispatch({
                    eventType: EventConstants.UPDATE_BIGOVKI_AND_PERFORATION_VALUES,
                    deltas: response.data
                });
            }.bind(this),
            error: function (e) {
                L.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __checkInputNumber: function () {
        $(".numberInputCheck").keydown(function (event) {
            if (event.keyCode === 9 || event.keyCode === 37 || event.keyCode === 39 || (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {
            }
            else if (event.keyCode != 8 && event.keyCode != 46) {
                event.preventDefault();
            }
        });
    }
};

export default NewProductActions;