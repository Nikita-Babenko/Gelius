import React from 'react';
import ProductRegisterActions from '../../actions/ProductRegisterActions';
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import EventConstants from '../../constants/Events';
import Row from '../productRegister/Row';

class TableBody extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            allProducts: []
        };
        this._onProductsTableDataUpdated = this._onProductsTableDataUpdated.bind(this);
    }

    componentDidMount() {
        ProductRegisterStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this._onProductsTableDataUpdated);
        ProductRegisterActions.loadProductsFromServer();
    }

    componentWillUnmount() {
        ProductRegisterStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this._onProductsTableDataUpdated);
    }

    render() {
        var allProducts = this.state.allProducts;
        var rows = allProducts.map(function (r, i) {
            return (<Row row={r} key={i}/>);
        });
        return (
            <tbody>
            {rows}
            </tbody>
        );
    }

    _onProductsTableDataUpdated() {
        if (ProductRegisterStore.getLoadProductsStatus())
            this.setState({
                allProducts: ProductRegisterStore.getProductsTableData()
            })
    }

}

export default TableBody;