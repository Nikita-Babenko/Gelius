import React from 'react';
import RegisterTable from '../productRegister/RegisterTable';
import ControlButtons from '../productRegister/ControlButtons';

class RegisterPanel extends React.Component {
    render() {
        return (
            <div className="panel panel-default panel-table">
                <div className="panel-heading">
                    <div className="row">
                        <ControlButtons />
                        <div className="col-md-7 col-xs-6 header_title">
                            <p className="panel-title">Реестр продукции</p>
                        </div>
                    </div>
                </div>
                <div className="table-responsive products-panel">
                    <RegisterTable />
                </div>
            </div>
        );
    }
}

export default RegisterPanel;