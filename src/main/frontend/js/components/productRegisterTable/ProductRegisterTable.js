import React from 'react';
import Table from '../productRegisterTable/Table';
import TableHeader from '../productRegisterTable/TableHeader';
import TableBody from '../productRegisterTable/TableBody';

class ProductsTableComponent extends React.Component {
    render() {
        return (
            <Table>
                <TableHeader />
                <TableBody />
            </Table>
        );
    }
}

export default ProductsTableComponent;