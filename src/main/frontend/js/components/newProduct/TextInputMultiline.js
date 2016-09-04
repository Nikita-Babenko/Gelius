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
        this.__onTextInputMultilineChange = this.__onTextInputMultilineChange.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    shouldComponentUpdate() {
        return true;
    }

    render() {

        return (
            <div id={this.props.id}
                 className={this.props.style}
                 onInput={this.__onTextInputMultilineChange}
                 dangerouslySetInnerHTML={{__html: this.state.text}}
                 contentEditable>
            </div>
        )
    }

    __onTextInputMultilineChange() {
        var html = ReactDOM.findDOMNode(this).innerHTML;
        this.setState({text: html})
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getDefaultProductProperty(this.props.id);
            this.setState({
                text: value ? value : ""
            });
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