import React from 'react';
import ProductRegisterTableActions from '../../actions/ProductRegisterTableActions';
import ProductRegisterTableStore from '../../stores/ProductRegisterTableStore';
import EventConstants from '../../constants/Events';
import Row from '../productRegisterTable/Row';

class TableBody extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            allProducts: []
        };
        this._onProductsTableDataUpdated = this._onProductsTableDataUpdated.bind(this);
    }

    componentDidMount() {
        ProductRegisterTableStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this._onProductsTableDataUpdated);
        ProductRegisterTableActions.loadProductsFromServer();
    }

    componentWillUnmount() {
        ProductRegisterTableStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this._onProductsTableDataUpdated);
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
        this.setState({
            allProducts: ProductRegisterTableStore.getProductsTableData()
        })
    }

}

export default TableBody;