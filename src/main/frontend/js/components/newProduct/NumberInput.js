import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class NumberInput extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            number: ""
        };

        this.__onNumberInputChange = this.__onNumberInputChange.bind(this);
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
            <input type="number" min="0"
                   id={this.props.id}
                   className={"numberInputCheck " + this.props.style}
                   value={this.state.number}
                   onChange={this.__onNumberInputChange}
            />
        );
    }

    __onNumberInputChange(e) {
        var newValue = e.target.value;
        this.setState({number: newValue});
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getProductProperty(this.props.id);
            this.setState({
                number: value ? value : ""
            });
        }
    }
}

NumberInput.propTypes = {
    id: React.PropTypes.string,
    style: React.PropTypes.string
};

NumberInput.defaultProps = {
    id: "",
    style: ""
};

export default NumberInput;