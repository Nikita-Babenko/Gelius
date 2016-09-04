import EventEmitter from "eventemitter3";
import Dispatcher from "../dispatcher/Dispatcher";
import WorkCentersStore from "./WorkCentersStore";
import EventConstants from "../constants/Events";
import ResponseCodeConstants from "../constants/ResponseCodes";

class NewProductStore extends EventEmitter {
    constructor() {
        super();

        this.alert = {
            alertType: "",
            message: ""
        };

        this.enableDefaultValues = true;
        this.showAlert = false;

        this.defaultProduct = {
            "isNew": true,
            "productCreateDate": this.__getTodayDate(),
            "productUpdateDate": this.__getTodayDate(),
            "isUse": true,
            "celluloseLayer": {"id": 1},
            "packing": {"id": 1}
        };
    }

    emitChange() {
        this.emit(EventConstants.NEW_PRODUCT_CHANGE_EVENT);
    }

    getDefaultProductProperty(propertyName) {
        return this.defaultProduct[propertyName];
    }

    getAlertInformation() {
        return this.alert;
    }

    getAlertStatus() {
        return this.showAlert;
    }

    isEnableDefaultValues() {
        return this.enableDefaultValues;
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
        product["cliche"] = $('#cliche').text();
        product["theoreticalSquare"] = parseFloat($('#theoreticalSquare').val().replace(/,/, '.'));
        product["actualSquare"] = $('#actualSquare').val().replace(/,/, '.');
        product["material"] = $('#material').val();
        product["format"] = Number($('#format :selected').val());
        product["sizeWorkpieceLength"] = $('#sizeWorkpieceLength').val();
        product["sizeWorkpieceWidth"] = $('#sizeWorkpieceWidth').val();
        product["numberFromSheet"] = $('#numberFromSheet').val();
        product["blankFormat"] = $('#blankFormat').val();
        product["connectionValve"] = Number($('#connectionValve :selected').val());
        product["stamp"] = $('#stamp').text();
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
        var centersArrayPropName = WorkCentersStore.CENTERS_ARRAY_PROPNAME;
        var note;
        for (var groupName in centers) {
            note = centers[groupName].note;
            centers[groupName][centersArrayPropName].forEach(function (group) {
                product["workabilityNotes"].push(
                    {serviceCenter: group.id, note: note}
                );
            });
        }

        return product;
    }

    __getTodayDate() {
        var now = new Date();
        var year = now.getFullYear();
        var month = (now.getMonth() + 1);
        var day = now.getDate();

        return [year, month, day];
    }

}

const newProductStore = new NewProductStore();

newProductStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.SAVE_NEW_PRODUCT:
            var responseData = event.response;
            newProductStore.alert.alertType = "alert-danger";
            switch (responseData.code) {
                case ResponseCodeConstants.OK:
                    newProductStore.defaultProduct.productNumber = responseData.data.newProductNumber;
                    newProductStore.alert.alertType = "alert-success";
                    newProductStore.alert.message = "Новый продукт (техкарта № " + responseData.data.savedProductNumber + ") был успешно добавлен";
                    newProductStore.enableDefaultValues = true;
                    break;
                case ResponseCodeConstants.VALIDATION_ERROR:
                    newProductStore.enableDefaultValues = false;
                    newProductStore.alert.message = "Вами допущены ошибки: " + responseData.data.join(", ");
                    break;
                case ResponseCodeConstants.OBJECT_EXISTS:
                    newProductStore.enableDefaultValues = false;
                    newProductStore.alert.message = "Техкарта с таким номером уже существует";
                    break;
                default:
                    newProductStore.enableDefaultValues = false;
                    newProductStore.alert.message = "Произошла ошибка. Обновите страницу и повторите действие или попробуйте повторить действие позже";
            }
            newProductStore.showAlert = true;
            newProductStore.emitChange();
            break;
        case EventConstants.LOAD_PRODUCT_NUMBER:
            newProductStore.defaultProduct.productNumber = event.productNumber;
            newProductStore.emitChange();
            break;
    }
});

export default newProductStore;