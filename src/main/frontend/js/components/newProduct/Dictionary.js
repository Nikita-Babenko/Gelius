import React from "react";
import DictionaryStore from "../../stores/DictionariesStore";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class Dictionary extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dictionaryParameters: [],
            value: ""
        };

        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__selectOption = this.__selectOption.bind(this);
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
                <DictionaryOption id={d.id} text={d[dictText]}/>
            );
        });

        return (
            <select value={this.state.value}
                    className={this.props.style}
                    id={this.props.dictionaryName}
                    onChange={this.__selectOption}>
                <option value="">не выбран</option>
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
        var dictionaryValue = NewProductStore.getDefaultProductProperty(this.props.dictionaryName);
        this.setState({
            value: dictionaryValue ? dictionaryValue.id : ""
        });
    }

    __selectOption(e) {
        this.setState({
            value: e.target.value
        });
    }
}

Dictionary.propTypes = {
    dictionaryName: React.PropTypes.string.isRequired,
    dictionaryTextName: React.PropTypes.string,
    style: React.PropTypes.string
};

Dictionary.defaultProps = {
    style: ""
};

class DictionaryOption extends React.Component {
    render() {
        return (
            <option value={this.props.id}>
                {this.props.text}
            </option>
        );
    }
}

DictionaryOption.propTypes = {
    id: React.PropTypes.number.isRequired,
    text: React.PropTypes.string.isRequired
};

export default Dictionary;