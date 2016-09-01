import React from 'react';

class SquareInput extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            square: ""
        };

        this.__onSquareInputChange = this.__onSquareInputChange.bind(this);
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
}

SquareInput.propTypes = {
    id: React.PropTypes.string
};

export default SquareInput;