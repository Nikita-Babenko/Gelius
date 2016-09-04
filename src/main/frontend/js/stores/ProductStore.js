import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';
import ObjectConstants from '../constants/Objects';

class ProductStore extends EventEmitter {
    constructor() {
        super();

        this.defaultProduct = {
            "productNumber": "0",
            "isNew": true,
            "productCreateDate": [2016, 9, 3],
            "productUpdateDate": [2016, 9, 3],
            "personPrepared": "",
            "isUse": true,
            "client": null,
            "productName": "",
            "productType": null,
            "innerLength": 111,
            "innerWidth": null,
            "innerHeight": null,
            "theoreticalSquare": null,
            "actualSquare": null,
            "format": null,
            "profile": null,
            "cardboardBrand": null,
            "celluloseLayer": {
                "id": 1,
                "celluloseLayer": "нет"
            },
            "faceLayer": null,
            "innerLayer": null,
            "material": "",
            "sizeWorkpieceLength": null,
            "sizeWorkpieceWidth": null,
            "numberFromSheet": null,
            "blankFormat": null,
            "connectionValve": null,
            "stamp": "",
            "cliche": "",
            "packing": {
                "id": 1,
                "packing": "Без упаковки"
            },
            "numberInPack": null,
            "numberInTransportPackage": null,
            "packageLength": null,
            "packageWidth": null,
            "packageHeight": null,
            "pallet": null,
            "palletPlacement": null,
            "palletRows": null,
            "numberLoadCar": null,
            "productionFormat": null,
            "workabilityNotes": [
                {
                    "serviceCenter": {
                        "id": 1
                    },
                    "note": ""
                }
            ]
        };

    }

    emitChange() {
        this.emit(EventConstants.WORK_CENTERS_CHANGE_EVENT);
    }

    getDefaultProductProperty (propertyName) {
        return this.defaultProduct[propertyName];
    }


}

const productStore = new ProductStore();

productStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants:

            break;
        default:
    }
});

export default productStore;