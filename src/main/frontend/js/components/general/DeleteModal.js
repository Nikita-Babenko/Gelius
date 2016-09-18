import React from 'react';
import Modal from './Modal';
import ModalBody from './ModalBody';
import ModalFooter from './ModalFooter';

class DeleteModal extends React.Component {
    render() {
        return (
            <Modal id={this.props.id}>
                <ModalBody>
                    <DeleteMessage confirmMessage={this.props.confirmMessage}/>
                </ModalBody>
                <ModalFooter>
                    <DeletionControls deleteFunction={this.props.deleteFunction}/>
                </ModalFooter>
            </Modal>
        );
    }
}

DeleteModal.propTypes = {
    id: React.PropTypes.string,
    confirmMessage: React.PropTypes.string.isRequired,
    deleteFunction: React.PropTypes.func.isRequired
};

DeleteModal.defaultProps = {
    id: ""
};

export default DeleteModal;

class DeleteMessage extends React.Component {
    render() {
        return (
            <div className="row">
                <div className="col-md-8 text-center">
                    <h1>{this.props.confirmMessage}</h1>
                </div>
                <p className="col-md-4 text-center">
                    <i className="fa fa-trash big-modal-icon" aria-hidden="true"></i>
                </p>
            </div>
        );
    }
}

class DeletionControls extends React.Component {

    render() {
        return (
            <div className="row text-center">
                <button type="button"
                        className="btn modal-btn "
                        data-dismiss="modal"
                        onClick={this.props.deleteFunction}>
                    Удалить
                </button>
                <button type="button"
                        className="btn modal-btn"
                        data-dismiss="modal">
                    Отменить
                </button>
            </div>
        );
    }
}