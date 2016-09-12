import React from 'react';
import ProductRegisterActions from '../../actions/ProductRegisterActions';
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import EventConstants from '../../constants/Events';
import UrlConstants from '../../constants/Url';

class Row extends React.Component {

    constructor(props) {
        super(props);

        this.bgColors = {
            "Default": "",
            "Selected": "#8eba68"
        };

        this.state = {
            selected: false,
            selectedProductColor: {
                backgroundColor: this.bgColors.Default
            }
        };

        this.__onProductRowClick = this.__onProductRowClick.bind(this);
        this.__onProductRowDoubleClick = this.__onProductRowDoubleClick.bind(this);
        this.__updateProductColor = this.__updateProductColor.bind(this);
    }

    componentDidMount() {
        ProductRegisterStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__updateProductColor);
    }

    componentWillUnmount() {
        ProductRegisterStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__updateProductColor);
    }

    render() {
        return (
            <tr onClick={this.__onProductRowClick} onDoubleClick={this.__onProductRowDoubleClick} style={this.state.selectedProductColor}>
                <td>{this.props.row.productNumber ? this.props.row.productNumber : "-"}</td>
                <td>{this.props.row.client ? this.props.row.client.companyName : "-"}</td>
                <td>{this.props.row.productName ? this.props.row.productName : "-"}</td>
                <td>{this.props.row.productType ? this.props.row.productType.productType : "-"}</td>
                <td>{this.props.row.innerLength ? this.props.row.innerLength : "-"}</td>
                <td>{this.props.row.innerWidth ? this.props.row.innerWidth : "-"}</td>
                <td>{this.props.row.innerHeight ? this.props.row.innerHeight : "-"}</td>
                <td>{this.props.row.cardboardBrand ? this.props.row.cardboardBrand.cardboardBrand : "-"}</td>
                <td>{this.props.row.profile ? this.props.row.profile.profile : "-"}</td>
                <td>{this.props.row.layersColours ? this.props.row.layersColours : "-"}</td>
                <td>{this.props.row.cliche ? this.props.row.cliche : "-"}</td>
            </tr>
        );
    }

    __onProductRowClick() {
        ProductRegisterActions.selectProduct(this.props.row.id);
    }

    __onProductRowDoubleClick() {
        window.location = UrlConstants.EDIT_PRODUCT_URL + this.props.row.id;
    }

    __updateProductColor() {
        var productID = this.props.row.id;
        var previousProductID = ProductRegisterStore.getPreviousSelectedProductId();
        var selectedProductID = ProductRegisterStore.getSelectedProductId();

        if (previousProductID === selectedProductID) {
            this.setState({
                selectedProductColor: {
                    backgroundColor: this.bgColors.Default
                }
            });
            return
        }

        if (productID === previousProductID)
            this.setState({
                selectedProductColor: {
                    backgroundColor: this.bgColors.Default
                }
            });

        if (productID === selectedProductID)
            this.setState({
                selectedProductColor: {
                    backgroundColor: this.bgColors.Selected
                }
            });
    }
}

export default Row;