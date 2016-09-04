import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class TextArea extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            text: ""
        };

        this.__onTextAreaChange = this.__onTextAreaChange.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        return (<textarea id={this.props.id} value={this.state.text} onChange={this.__onTextAreaChange}/>)
    }

    __onTextAreaChange(e) {
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

TextArea.propTypes = {
    id: React.PropTypes.string.isRequired
};

TextArea.defaultProps = {
    id: ""
};

export default TextArea;