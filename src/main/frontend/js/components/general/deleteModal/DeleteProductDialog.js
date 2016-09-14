import React from 'react';
import Modal from '../Modal';
import ModalBody from '../ModalBody';
import ModalFooter from '../ModalFooter';
import DeleteProductMessage from './DeleteProductMessage';

class DeleteProductDialog extends React.Component {
    render() {
        return (
            <Modal id="delete-product-modal">
                <ModalBody>
                    <DeleteProductMessage/>
                </ModalBody>
                <ModalFooter>
                    {this.props.children}
                </ModalFooter>
            </Modal>
        );
    }
}

export default DeleteProductDialog;