import React from "react";
import DictionaryStore from "../../stores/DictionariesStore";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class DictionaryColoured extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dictionaryParameters: [],
            value : "",
            selectedOptionColor: {
                background: ''
            },
            defaultOptionColor: {
                background: 'white'
            }
        };

        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__selectOptionValue = this.__selectOptionValue.bind(this);
        this.__chooseOption = this.__chooseOption.bind(this);
        this.__setColorForSelectedOption = this.__setColorForSelectedOption.bind(this);
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
        var whiteColor = this.state.defaultOptionColor;
        var dictOptions = dictData.map(function (d) {
            return (
                <DictionaryOption id={d.id} text={d[dictText]} style={whiteColor}/>
            );
        });

        return (
            <select value={this.state.value} style={this.state.selectedOptionColor} className={this.props.style} id={this.props.dictionaryName} onChange={this.__chooseOption}>
                <option value="" style={this.state.defaultOptionColor}>не выбран</option>
                {dictOptions}
            </select>
        );
    }

    _onDictionariesParametersUpdated() {
        this.setState({
            dictionaryParameters: DictionaryStore.getDictionaryParameters(this.props.dictionaryName)
        });
    }


    __chooseOption(e){
        this.__selectOptionValue(e);
        this.__setColorForSelectedOption(e);
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var dictionaryValue = NewProductStore.getDefaultProductProperty(this.props.dictionaryName);
            this.setState({
                value: dictionaryValue ? dictionaryValue.id : ""
            })
        }
    }

    __selectOptionValue(e){
        var selectedValue = e.target.value;
        this.setState({
            value : selectedValue
        });
    }

    __setColorForSelectedOption(e){
        var selectedValue = e.target.value;
        var dictionaryName = this.props.dictionaryName;
        var color = (dictionaryName === "connectionValve") ? (selectedValue === "2" ? 'yellow' : (selectedValue === "3" ? '#FFBAB7' : 'white')) : 'white';
        this.setState({
            selectedOptionColor: {
                background : color
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
            <option value={this.props.id} style={this.props.style}>
                {this.props.text}
            </option>
        );
    }
}

DictionaryOption.propTypes = {
    id: React.PropTypes.number.isRequired,
    text: React.PropTypes.string.isRequired,
    style: React.PropTypes.string
};

DictionaryColoured.defaultProps = {
    style: ""
};