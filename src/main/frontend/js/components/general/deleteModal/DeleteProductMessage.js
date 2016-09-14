import React from 'react';

class DeleteProductMessage extends React.Component {
    render() {
        return (
            <div className="row">
                <div className="col-md-8 text-center">
                    <h1>Вы уверены, что хотите удалить техническую карту?</h1>
                </div>
                <p className="col-md-4 text-center">
                    <i className="fa fa-trash big-modal-icon" aria-hidden="true"></i>
                </p>
            </div>
        );
    }
}

export default DeleteProductMessage;