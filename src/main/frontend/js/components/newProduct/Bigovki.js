import React from 'react';
import ReactDOM from "react-dom";
import EventConstants from "../../constants/Events";
import NewProductAction from "../../actions/NewProductActions";
import NewProductStore from "../../stores/NewProductStore";
import NumberInput from "../newProduct/NumberInput";

class Bigovki extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            bigovki_input_1: "",
            bigovki_input_2: "",
            bigovki_input_3: ""
        };
        this.__setValueBigovkiInput1 = this.__setValueBigovkiInput1.bind(this);
        this.__setValueBigovkiInput2 = this.__setValueBigovkiInput2.bind(this);
        this.__setValueBigovkiInput3 = this.__setValueBigovkiInput3.bind(this);
        this.__calculateBigovkiSum = this.__calculateBigovkiSum.bind(this);
        this.__loadDefaultValueForBigovki = this.__loadDefaultValueForBigovki.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValueForBigovki);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValueForBigovki);
    }

    render() {
        return (
            <td colSpan="3" className="bigovki_all">
                <div className="bigovki_inputs_1">
                    <input type="text"
                           ref="bigovki1"
                           className="bigovki_input_1 sumBigovki"
                           value={this.state.bigovki_input_1}
                           onChange={this.__setValueBigovkiInput1}
                           onKeyUp={this.__calculateBigovkiSum}
                    />
                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                </div>
                <div className="bigovki_inputs_2">
                    <input type="text"
                           ref="bigovki2"
                           className="bigovki_input_1 sumBigovki"
                           value={this.state.bigovki_input_2}
                           onChange={this.__setValueBigovkiInput2}
                           onKeyUp={this.__calculateBigovkiSum}
                    />
                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                </div>
                <div className="bigovki_inputs_3">
                    <input type="text"
                           ref="bigovki3"
                           className="bigovki_input_3 sumBigovki"
                           value={this.state.bigovki_input_3}
                           onChange={this.__setValueBigovkiInput3}
                           onKeyUp={this.__calculateBigovkiSum}
                    />
                    <NumberInput id="numberBlanksOnFormat" style="bigovki_input_4"/>
                </div>
            </td>
        );
    }

    __validateBigovkiInput(newValue) {
        var onlyPositiveDecimals = /^(\d{0,5})[.,]?(\d?)$/;
        if (onlyPositiveDecimals.test(newValue)) {
            if (newValue.startsWith('.') || newValue.startsWith(','))
                newValue = newValue.substring(1);
            return newValue;
        } else
            return null;
    }

    __setValueBigovkiInput1(e) {
        var value = this.__validateBigovkiInput(e.target.value);
        if (value !== null)
            this.setState({
                bigovki_input_1: value
            });
    }

    __setValueBigovkiInput2(e) {
        var value = this.__validateBigovkiInput(e.target.value);
        if (value !== null)
            this.setState({
                bigovki_input_2: value
            });
    }

    __setValueBigovkiInput3(e) {
        var value = this.__validateBigovkiInput(e.target.value);
        if (value !== null)
            this.setState({
                bigovki_input_3: value
            });
    }

    __calculateBigovkiSum() {
        var total = 0;

        for (var i = 1; i <= 3; i++) {
            var value = ReactDOM.findDOMNode(this.refs['bigovki' + i]).value.trim();
            if (value !== '')
                total += Number(value.replace(/,/, '.'));
        }

        if (total)
            NewProductAction.updateWorkpieceWidth(true, total);
        else
            NewProductAction.updateWorkpieceWidth(false, "");
    }

    __loadDefaultValueForBigovki() {
        if (NewProductStore.isEnableDefaultValues()) {
            var array = NewProductStore.getProductProperty("bigovki");
            var isFound = array ? true : false;
            if (isFound) {
                this.setState({
                    bigovki_input_1: array[0] ? array[0].value : "",
                    bigovki_input_2: array[1] ? array[1].value : "",
                    bigovki_input_3: array[2] ? array[2].value : ""
                });
            }
            else {
                this.setState({
                    bigovki_input_1: "",
                    bigovki_input_2: "",
                    bigovki_input_3: ""
                });
            }
        }
    }
}

export default Bigovki;