import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";
import NumberInput from "../newProduct/NumberInput";

class Bigovki extends React.Component {

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__clearSumBigovkiValues);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__clearSumBigovkiValues);
    }

    render() {
        return (
            <td colSpan="3" className="bigovki_all">
                <div className="bigovki_inputs_1">
                    <input type="number" className="bigovki_input_1 sumBigovki numberInputCheck" min="0"/>
                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                </div>
                <div className="bigovki_inputs_2">
                    <input type="number" className="bigovki_input_1 sumBigovki numberInputCheck" min="0"/>
                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                </div>
                <div className="bigovki_inputs_3">
                    <input type="number" className="bigovki_input_3 sumBigovki numberInputCheck" min="0"/>
                    <NumberInput id="numberBlanksOnFormat" style="bigovki_input_4"/>
                </div>
            </td>
        );
    }

    __clearSumBigovkiValues() {
        if (NewProductStore.isEnableDefaultValues()) {
            $(".sumBigovki").val("");
        }
    }

}

export default Bigovki;