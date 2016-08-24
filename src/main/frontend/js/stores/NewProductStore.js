import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class NewProductStore extends EventEmitter {
    constructor() {
        super();
        this.newProductNumber = "0";
        this.alert = {
            alertType: "",
            message: ""
        };

        this.showAlert = false;
    }

    emitChange() {
        this.emit(EventConstants.NEW_PRODUCT_CHANGE_EVENT);
    }

    getNewProductNumber() {
        return this.newProductNumber;
    }

    getAlertInformation() {
        return this.alert;
    }

    getAlertStatus() {
        return this.showAlert;
    }

    getNewProduct() {
        var product = {};
        product["isNew"] = $('#isNew').is(":checked");
        product["isUse"] = $('#isUse').is(":checked");
        product["productNumber"] = $('#productNumber').val();
        product["productName"] = $('#productName').val();
        product["productCreateDateValue"] = $('#productCreateDate').val();
        product["productUpdateDateValue"] = $('#productUpdateDate').val();
        product["personPrepared"] = $('#personPrepared').val();
        product["innerLength"] = $('#innerLength').val();
        product["innerWidth"] = $('#innerWidth').val();
        product["innerHeight"] = $('#innerHeight').val();
        product["profile"] = Number($('#profile :selected').val());
        product["client"] = Number($('#client :selected').val());
        product["cardboardBrand"] = Number($('#cardboardBrand :selected').val());
        product["productType"] = Number($('#productType :selected').val());
        product["celluloseLayer"] = Number($('#celluloseLayer :selected').val());
        product["innerLayer"] = Number($('#innerLayer :selected').val());
        product["faceLayer"] = Number($('#faceLayer :selected').val());
        product["cliche"] = $('#cliche').val();
        product["theoreticalSquare"] = $('#theoreticalSquare').val();
        product["actualSquare"] = $('#actualSquare').val();
        product["material"] = $('#material').val();
        product["format"] = Number($('#format :selected').val());
        product["sizeWorkpieceLength"] = $('#sizeWorkpieceLength').val();
        product["sizeWorkpieceWidth"] = $('#sizeWorkpieceWidth').val();
        product["numberFromSheet"] = $('#numberFromSheet').val();
        product["blankFormat"] = $('#blankFormat').val();
        product["connectionValve"] = Number($('#connectionValve :selected').val());
        product["stamp"] = $('#stamp').val();
        product["packing"] = Number($('#packing :selected').val());
        product["numberInPack"] = $('#numberInPack').val();
        product["numberInTransportPackage"] = $('#numberInTransportPackage').val();
        product["packageLength"] = $('#packageLength').val();
        product["packageWidth"] = $('#packageWidth').val();
        product["packageHeight"] = $('#packageHeight').val();
        product["pallet"] = Number($('#pallet :selected').val());
        product["palletPlacement"] = Number($('#palletPlacement :selected').val());
        product["palletRows"] = $('#palletRows').val();
        product["numberLoadCar"] = $('#numberLoadCar').val();
        product["productionFormat"] = $('#productionFormat').val();

        return product;
    }

    clearAllSelectedValues() {
        $('#isNew').attr('checked', false);
        $('#isUse').attr('checked', false);
        $('#productName').val("");
        //$('#productCreateDate').val();
        //$('#productUpdateDate').val();
        $('#personPrepared').val("");
        $('#innerLength').val("");
        $('#innerWidth').val("");
        $('#innerHeight').val("");
        $("#profile").val($("#profile option:first").val());
        $("#client").val($("#client option:first").val());
        $("#cardboardBrand").val($("#cardboardBrand option:first").val());
        $("#productType").val($("#productType option:first").val());
        $("#celluloseLayer").val($("#celluloseLayer option:first").val());
        $("#innerLayer").val($("#innerLayer option:first").val());
        $("#faceLayer").val($("#faceLayer option:first").val());
        $('#cliche').val("");
        $('#theoreticalSquare').val("");
        $('#actualSquare').val("");
        $('#material').val("");
        $("#format").val($("#format option:first").val());
        $('#sizeWorkpieceLength').val("");
        $('#sizeWorkpieceWidth').val("");
        $('#numberFromSheet').val("");
        $('#blankFormat').val("");
        $("#connectionValve").val($("#connectionValve option:first").val());
        $('#stamp').val("");
        $("#packing").val($("#packing option:first").val());
        $('#numberInPack').val("");
        $('#numberInTransportPackage').val("");
        $('#packageLength').val("");
        $('#packageWidth').val("");
        $('#packageHeight').val("");
        $("#pallet").val($("#pallet option:first").val());
        $("#palletPlacement").val($("#palletPlacement option:first").val());
        $('#palletRows').val("");
        $('#numberLoadCar').val("");
        $('#productionFormat').val("");
    }

}

const newProductStore = new NewProductStore();

newProductStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.SAVE_NEW_PRODUCT:
            newProductStore.newProductNumber = event.productNumber;
            newProductStore.clearAllSelectedValues();
            newProductStore.alert.alertType = "alert-success";
            newProductStore.alert.message = "Новый продукт был успешно добавлен";
            newProductStore.showAlert = true;
            newProductStore.emitChange();
            break;
        case EventConstants.LOAD_PRODUCT_NUMBER:
            newProductStore.newProductNumber = event.productNumber;
            newProductStore.emitChange();
            break;
        case EventConstants.BLANK_FORMAT_VALIDATION_ERROR:
            newProductStore.alert.alertType = "alert-danger";
            newProductStore.alert.message = "Поле 'формат заготовки' должно быть заполнено!";
            newProductStore.showAlert = true;
            newProductStore.emitChange();
            newProductStore.showAlert = false;
    }
});

export default newProductStore;