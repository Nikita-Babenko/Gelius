import React from "react";
import DictionaryStore from "../../stores/DictionariesStore";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class DictionaryColoured extends React.Component {
    constructor(props) {
        super(props);

        this.bgColors = {
            "Default": "white",
            "LightRed": "#FFBAB7",
            "Yellow": "yellow"
        };

        this.state = {
            dictionaryParameters: [],
            value: "",
            selectedOptionColor: {
                backgroundColor: this.bgColors.Default
            }
        };

        this.__setColourForOption = this.__setColourForOption.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__selectOptionValue = this.__selectOptionValue.bind(this);
        this._onDictionariesParametersUpdated = this._onDictionariesParametersUpdated.bind(this);
    }

    componentWillMount() {
        DictionaryStore.addListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        DictionaryStore.removeListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        var dictData = this.state.dictionaryParameters;
        var dictText = this.props.dictionaryTextName;
        var dictOptions = dictData.map(function (d) {
            return (
                <DictionaryOption id={d.id} text={d[dictText]} />
            );
        });

        return (
            <select value={this.state.value}
                    style={this.state.selectedOptionColor}
                    className={this.props.style}
                    id={this.props.dictionaryName}
                    onChange={this.__selectOptionValue}>
                <DictionaryOption id="" text="не выбран" />
                {dictOptions}
            </select>
        );
    }

    _onDictionariesParametersUpdated() {
        this.setState({
            dictionaryParameters: DictionaryStore.getDictionaryParameters(this.props.dictionaryName)
        });
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getProductProperty(this.props.dictionaryName);
            var dictionaryValue = value ? value.id : "";
            this.__setColourForOption("" + dictionaryValue);
            this.setState({
                value: dictionaryValue
            })
        }
    }

    __selectOptionValue(e){
        var selectedValue = e.target.value;
        this.__setColourForOption(selectedValue);
        this.setState({
            value : selectedValue
        });
    }

    __setColourForOption(value) {
        var color;
        switch (value) {
            case "2":
                color = this.bgColors.Yellow;
                break;
            case "3":
                color = this.bgColors.LightRed;
                break;
            default:
                color = this.bgColors.Default;
        }

        this.setState({
            selectedOptionColor: {
                backgroundColor: color
            }
        });
    }
}

DictionaryColoured.propTypes = {
    dictionaryName: React.PropTypes.string.isRequired,
    dictionaryTextName: React.PropTypes.string
};


export default DictionaryColoured;

class DictionaryOption extends React.Component {
    render() {
        return (
            <option value={this.props.id} style={{backgroundColor: "white"}}>
                {this.props.text}
            </option>
        );
    }
}

DictionaryOption.propTypes = {
    id: React.PropTypes.number.isRequired,
    text: React.PropTypes.string.isRequired
};