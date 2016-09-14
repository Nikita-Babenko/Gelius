import React from 'react';

class Modal extends React.Component {
    render() {
        return (
            <div className="modal" id={this.props.id}>
                <div className="modal-dialog">
                    <div className="modal-content">
                        {this.props.children}
                    </div>
                </div>
            </div>
        );
    }
}

Modal.propTypes = {
    id: React.PropTypes.string
};

Modal.defaultProps = {
    id: ""
};


export default Modal;