import Dispatcher from "../dispatcher/Dispatcher";
import UrlConstants from "../constants/Url";
import EventConstants from "../constants/Events";
import NewProductStore from "../stores/NewProductStore";
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
                    console.log("Empty 'data' in response on '" + UrlConstants.LOAD_ALL_DICTIONARIES_URL + "'");
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
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    loadNewProductNumber() {
        $.ajax({
            type: 'GET',
            contentType: "application/json",
            url: UrlConstants.LOAD_PRODUCT_NUMBER_URL,
            data: '',
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                if (!response["data"]) {
                    console.log("Empty 'newProductNumber' in response on '" + UrlConstants.LOAD_PRODUCT_NUMBER_URL + "'");
                    return;
                }

                if (response["data"]) {
                    Dispatcher.dispatch({
                        eventType: EventConstants.LOAD_PRODUCT_NUMBER,
                        productNumber: response.data
                    });
                }

            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    saveProduct(){
        var newProduct = NewProductStore.getNewProduct();
        L.log(newProduct);
        $.ajax({
            type: 'POST',
            url: UrlConstants.SAVE_PRODUCT_URL,
            contentType: 'application/json',
            data: JSON.stringify(NewProductStore.getNewProduct()),
            dataType: 'JSON',
            timeout: 100000,
            success: function (response) {
                Dispatcher.dispatch({
                    eventType: EventConstants.SAVE_NEW_PRODUCT,
                    response: response
                });
            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)

        });

    },

    addWorkCenter(center) {
        Dispatcher.dispatch({
            eventType: EventConstants.ADD_WORK_CENTER,
            workCenter: center
        });
    },

    deleteWorkCenter(center) {
        Dispatcher.dispatch({
            eventType: EventConstants.DELETE_WORK_CENTER,
            workCenter: center
        });
    },

    updateWorkabilityInfo() {
        Dispatcher.dispatch({
            eventType: EventConstants.UPDATE_WORKABILITY_INFO
        });
    },

    updateWorkCenterNote(groupPriority, note) {
        Dispatcher.dispatch({
            eventType: EventConstants.UPDATE_WORK_CENTER_NOTE,
            groupPriority: groupPriority,
            note: note
        });
    },

    // implemented #1201
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

    // implemented 1203
    __defaultConnectionValveDictionaryDependsFromProductType(){
        $('#productType').change(function () {
            if (this.value === '1') {
                $('#connectionValve').val('1');
            }
            else $('#connectionValve').val('');
        });
    },

    __sumBigovki: function () {
        $(".sumBigovki").keyup(function () {
            var isEmpty = true;
            var total = 0;
            $('.sumBigovki').each(function () {
                total = total + Number($(this).val());
                if ($.trim($(this).val()) !== '') {
                    isEmpty = isEmpty && false;
                }
            });
            if (isEmpty === false) {
                $('input#sizeWorkpieceWidth').prop("disabled", true);
                $('input#sizeWorkpieceWidth').val(total);
            }
            else {
                $('input#sizeWorkpieceWidth').prop("disabled", false);
                $('input#sizeWorkpieceWidth').val("");
            }
        });
    },


    __checkInputNumber: function () {
        $(".numberInputCheck").keydown(function (event) {
            if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {
            }
            else if (event.keyCode != 8 && event.keyCode != 46) {
                event.preventDefault();
            }
        });
    }
};

export default NewProductActions;