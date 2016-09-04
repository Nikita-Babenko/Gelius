import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class TextInput extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            text: ""
        };

        this.__onTextInputChange = this.__onTextInputChange.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        return (<input type="text"
                       className={this.props.style}
                       id={this.props.id}
                       value={this.state.text}
                       onChange={this.__onTextInputChange}/>);
    }

    __onTextInputChange(e) {
        this.setState({text: e.target.value});
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

TextInput.propTypes = {
    id: React.PropTypes.string.isRequired,
    style: React.PropTypes.string
};

TextInput.defaultProps = {
    id: "",
    style: ""
};

export default TextInput;