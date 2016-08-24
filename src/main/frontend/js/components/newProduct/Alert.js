import React from 'react';

class Alert extends React.Component {
    render() {
        return (
            <div className={"alert alert-dismissible " + this.props.alertType} role="alert">
                <button type="button" className="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
                <h4 className="text-center">{this.props.message}</h4>
            </div>
        );
    }
}

Alert.propTypes = {
    alertType: React.PropTypes.string,
    message: React.PropTypes.string.isRequired
};

Alert.defaultProps = {
    alertType: "alert-info"
};
export default Alert;