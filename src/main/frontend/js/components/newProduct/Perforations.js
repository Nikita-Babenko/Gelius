import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class Perforations extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            perforation_input_1: "",
            perforation_input_2: "",
            perforation_input_3: "",
            perforation_input_4: "",
            perforation_input_5: ""
        };
        this.__setValuePerforationInput1 = this.__setValuePerforationInput1.bind(this);
        this.__setValuePerforationInput2 = this.__setValuePerforationInput2.bind(this);
        this.__setValuePerforationInput3 = this.__setValuePerforationInput3.bind(this);
        this.__setValuePerforationInput4 = this.__setValuePerforationInput4.bind(this);
        this.__setValuePerforationInput5 = this.__setValuePerforationInput5.bind(this);
        this.__loadDefaultValueForPerforations = this.__loadDefaultValueForPerforations.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValueForPerforations);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValueForPerforations);
    }

    __setValuePerforationInput1(e) {
        var value = e.target.value;
        this.setState({
            perforation_input_1: value
        });
    }

    __setValuePerforationInput2(e) {
        var value = e.target.value;
        this.setState({
            perforation_input_2: value
        });
    }

    __setValuePerforationInput3(e) {
        var value = e.target.value;
        this.setState({
            perforation_input_3: value
        });
    }

    __setValuePerforationInput4(e) {
        var value = e.target.value;
        this.setState({
            perforation_input_4: value
        });
    }

    __setValuePerforationInput5(e) {
        var value = e.target.value;
        this.setState({
            perforation_input_5: value
        });
    }

    __loadDefaultValueForPerforations() {
        if (NewProductStore.isEnableDefaultValues()) {
            var array = NewProductStore.getProductProperty("perforations");
            var isFound = array ? true : false;
            if (isFound) {
                this.setState({
                    perforation_input_1: array[0] ? array[0].value : "",
                    perforation_input_2: array[1] ? array[1].value : "",
                    perforation_input_3: array[2] ? array[2].value : "",
                    perforation_input_4: array[3] ? array[3].value : "",
                    perforation_input_5: array[4] ? array[4].value : ""
                });
            }
            else {
                this.setState({
                    perforation_input_1: "",
                    perforation_input_2: "",
                    perforation_input_3: "",
                    perforation_input_4: "",
                    perforation_input_5: ""
                });
            }
        }
    }

    render() {
        return (
            <td colSpan="3" className="perforations_all">
                <div className="perforations_inputs">
                    <input type="number" className="perforations perforation_input_1 numberInputCheck"
                           value={this.state.perforation_input_1} onChange={this.__setValuePerforationInput1}/>
                    <input type="number" className="perforations perforation_input_2 numberInputCheck"
                           value={this.state.perforation_input_2} onChange={this.__setValuePerforationInput2}/>
                    <input type="number" className="perforations perforation_input_3 numberInputCheck"
                           value={this.state.perforation_input_3} onChange={this.__setValuePerforationInput3}/>
                    <input type="number" className="perforations perforation_input_4 numberInputCheck"
                           value={this.state.perforation_input_4} onChange={this.__setValuePerforationInput4}/>
                    <input type="number" className="perforations perforation_input_5 numberInputCheck"
                           value={this.state.perforation_input_5} onChange={this.__setValuePerforationInput5}/>
                </div>
            </td>
        );
    }
}

export default Perforations;