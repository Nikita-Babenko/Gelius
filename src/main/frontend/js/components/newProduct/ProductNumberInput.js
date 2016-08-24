import React from 'react';
import EventConstants from '../../constants/Events';
import NewProductStore from '../../stores/NewProductStore';

class ProductNumberInput extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isNewProduct: true,
            newProductNumber: "0005"
        };
        this.__changeCheckbox = this.__changeCheckbox.bind(this);
        this.__changeText = this.__changeText.bind(this);
        this.__getNewProductNumber = this.__getNewProductNumber.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__getNewProductNumber);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__getNewProductNumber);
    }

    render() {
        return (
            <div className="header_title_input">
                <input
                    type="text" className="form-control numberInputCheck" id="productNumber" contenteditable="false"
                    value={this.state.newProductNumber} onChange={this.__changeText}
                    disabled={this.state.isNewProduct}
                />
                <div className="isNew">
                    <input type="checkbox" id="isNew" checked={this.state.isNewProduct}
                           onChange={this.__changeCheckbox}/>
                    <p>Новая карта</p>
                </div>
            </div>
        );
    }

    __changeCheckbox(e) {
        var isNewProduct = e.target.checked;
        this.setState({isNewProduct: isNewProduct});

        if (isNewProduct)
            this.setState({newProductNumber: NewProductStore.getNewProductNumber()});
        else
            this.setState({newProductNumber: ""});
    }

    __changeText(e) {
        this.setState({newProductNumber: e.target.value});
    }

    __getNewProductNumber() {
        this.setState({
            newProductNumber: NewProductStore.getNewProductNumber()
        });
    }
}

export default ProductNumberInput;