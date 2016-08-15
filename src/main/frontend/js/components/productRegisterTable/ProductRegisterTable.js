import React from 'react';
import Table from '../productRegisterTable/Table';
import Headings from '../productRegisterTable/Headings';
import Rows from '../productRegisterTable/Rows';

class ProductsTableComponent extends React.Component {
    render() {
        return (
            <Table>
                <Headings />
                <Rows />
            </Table>
        );
    }
}

export default ProductsTableComponent;