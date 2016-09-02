import Dispatcher from "../dispatcher/Dispatcher";
import UrlConstants from "../constants/Url";
import EventConstants from "../constants/Events";
import NewProductStore from "../stores/NewProductStore";

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

        if (!newProduct.blankFormat) {
            Dispatcher.dispatch({
                eventType: EventConstants.BLANK_FORMAT_VALIDATION_ERROR
            });
        } else {
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
        }
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
    disablePalletDictionaryDependsFromChangePacking(){
        var palletContext = $('#pallet');
        $('#packing').change(function() {
            if (this.value === '' || this.value === '1'){
                palletContext.prop( "disabled", true);
                palletContext.val('');
            }
            else{
                palletContext.prop( "disabled", false);
                palletContext.val('1');
            }
        });
    },

    disablePalletDictionaryByDefault(){
        var value = $('#packing').find(':selected').val();
        if (value === '' || value === '1'){
            $('#pallet').prop( "disabled", true);
        }
    },

    // implemented 1203
    defaultConnectionValveDictionaryDependsFromProductType(){
        $('#productType').change(function() {
            if (this.value === '1'){
                $('#connectionValve').val('1');
            }
            else $('#connectionValve').val('');
        });
    }
};

export default NewProductActions;