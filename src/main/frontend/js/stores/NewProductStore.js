import EventEmitter from "eventemitter3";
import Dispatcher from "../dispatcher/Dispatcher";
import WorkCentersStore from "./WorkCentersStore";
import EventConstants from "../constants/Events";
import ResponseCodeConstants from "../constants/ResponseCodes";

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

    emitChange(hasDoneWithError) {
        var event = hasDoneWithError ? EventConstants.NEW_PRODUCT_CHANGE_WITH_ERROR_EVENT : EventConstants.NEW_PRODUCT_CHANGE_EVENT;
        this.emit(event);
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
        product["productCreateDate"] = $('#productCreateDate').val();
        product["productUpdateDate"] = $('#productUpdateDate').val();
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
        product["theoreticalSquare"] = parseFloat($('#theoreticalSquare').val().replace(/,/,'.'));
        product["actualSquare"] = $('#actualSquare').val().replace(/,/,'.');
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

        //Workability notes:
        product["workabilityNotes"] = [];
        var centers = WorkCentersStore.selectedWorkCenters;
        for (var key in centers) {
            centers[key].forEach(function(item) {
                product["workabilityNotes"].push(
                    { serviceCenter: item.id, note: null } //null will be replaced for workcenter's note (in #1186)
                );
            });
        }

        return product;
    }

    clearAllSelectedValues() {
        $('#productName').val("");
        //$('#productCreateDate').val();
        //$('#productUpdateDate').val();
        $('#personPrepared').val("");
        $('#innerLength').val("");
        $('#innerWidth').val("");
        $('#innerHeight').val("");
        $('#cliche').val("");
        $('#theoreticalSquare').val("");
        $('#actualSquare').val("");
        $('#material').val("");
        $('#sizeWorkpieceLength').val("");
        $('#sizeWorkpieceWidth').val("");
        $('#numberFromSheet').val("");
        $('#blankFormat').val("");
        $('#stamp').val("");
        $('#numberInPack').val("");
        $('#numberInTransportPackage').val("");
        $('#packageLength').val("");
        $('#packageWidth').val("");
        $('#packageHeight').val("");
        $('#palletRows').val("");
        $('#numberLoadCar').val("");
        $('#productionFormat').val("");

        //TODO reset selected workcenters in WorkCentersStore and reset checkboxes in modal window
    }

}

const newProductStore = new NewProductStore();

newProductStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.SAVE_NEW_PRODUCT:
            var responseData = event.response;
            var hasDoneWithError = true;
            newProductStore.alert.alertType = "alert-danger";
            switch (responseData.code) {
                case ResponseCodeConstants.OK:
                    newProductStore.newProductNumber = responseData.data.newProductNumber;
                    newProductStore.clearAllSelectedValues();
                    newProductStore.alert.alertType = "alert-success";
                    newProductStore.alert.message = "Новый продукт (техкарта № " + responseData.data.savedProductNumber + ") был успешно добавлен";
                    hasDoneWithError = false;
                    break;
                case ResponseCodeConstants.VALIDATION_ERROR:
                    newProductStore.alert.message = "Вами допущены ошибки: " + responseData.data.join(", ");
                    break;
                case ResponseCodeConstants.OBJECT_EXISTS:
                    newProductStore.alert.message = "Техкарта с таким номером уже существует";
                    break;
                default:
                    newProductStore.alert.message = "Произошла ошибка. Обновите страницу и повторите действие или попробуйте повторить действие позже";
                }
            newProductStore.showAlert = true;
            newProductStore.emitChange(hasDoneWithError);
            break;
        case EventConstants.LOAD_PRODUCT_NUMBER:
            newProductStore.newProductNumber = event.productNumber;
            newProductStore.emitChange(false);
            break;
        case EventConstants.BLANK_FORMAT_VALIDATION_ERROR:
            newProductStore.alert.alertType = "alert-danger";
            newProductStore.alert.message = "Поле 'формат заготовки' должно быть заполнено!";
            newProductStore.showAlert = true;
            newProductStore.emitChange(true);
            newProductStore.showAlert = false;
    }
});

export default newProductStore;