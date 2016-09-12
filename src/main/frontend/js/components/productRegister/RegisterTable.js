import React from 'react';
import Table from '../productRegister/Table';
import TableHeader from '../productRegister/TableHeader';
import TableBody from '../productRegister/TableBody';

class RegisterTable extends React.Component {
    render() {
        return (
            <Table>
                <TableHeader />
                <TableBody />
            </Table>
        );
    }
}

export default RegisterTable;