import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";
import UpdateStore from "../../stores/UpdateStore";

class ProductionFormat extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            productionFormat: ""
        };

        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__onProductionFormatChange = this.__onProductionFormatChange.bind(this);
        this.__updateProductionFormat = this.__updateProductionFormat.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
        UpdateStore.addListener(EventConstants.UPDATE_CHANGE_EVENT, this.__updateProductionFormat);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
        UpdateStore.removeListener(EventConstants.UPDATE_CHANGE_EVENT, this.__updateProductionFormat);
    }

    render() {
        return (
            <input type="number" min="0"
                   id="productionFormat"
                   className="numberInputCheck"
                   value={this.state.productionFormat}
                   onChange={this.__onProductionFormatChange}
            />
        );
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getProductProperty("productionFormat");
            this.setState({
                productionFormat: value ? value : ""
            });
        }
    }

    __onProductionFormatChange(e) {
        this.setState({productionFormat: e.target.value});
    }

    __updateProductionFormat() {
        var data = UpdateStore.getProductionFormat();
        if (data !== null)
            this.setState({productionFormat: data});
    }
}

export default ProductionFormat;