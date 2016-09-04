import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class SquareInput extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            square: ""
        };

        this.__onSquareInputChange = this.__onSquareInputChange.bind(this);
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
            <input type="text"
                   className="numberInputCheck"
                   id={this.props.id}
                   value={this.state.square}
                   onChange={this.__onSquareInputChange}/>
        );
    }

    __onSquareInputChange(e) {
        var newValue = e.target.value;
        var onlyPositiveDecimals = /^(\d?)[.,]?(\d{0,3})$/;
        if (onlyPositiveDecimals.test(newValue)) {
            if (newValue.length === 1 && newValue !== ",")
                newValue += ",";

            this.setState({square: newValue});
        }
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getDefaultProductProperty(this.props.id);
            this.setState({
                square: value ? value : ""
            });
        }
    }

}

SquareInput.propTypes = {
    id: React.PropTypes.string
};

SquareInput.defaultProps = {
    id: ""
};

export default SquareInput;