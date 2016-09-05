import React from 'react';
import ReactDOM from "react-dom";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class TextInputMultiline extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            text: ""
        };

        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {

        return (
            <div id={this.props.id}
                 className={this.props.style}
                 contentEditable="true">
            </div>
        )
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            //temporary solution
            $('#'+this.props.id).text("");
        }
    }
}

TextInputMultiline.propTypes = {
    id: React.PropTypes.string.isRequired,
    style: React.PropTypes.string
};

TextInputMultiline.defaultProps = {
    id: "",
    style: ""
};

export default TextInputMultiline;