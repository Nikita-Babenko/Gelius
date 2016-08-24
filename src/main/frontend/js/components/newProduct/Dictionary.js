import React from 'react';
import DictionaryStore from '../../stores/DictionariesStore';
import EventConstants from '../../constants/Events';

class Dictionary extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dictionaryParameters: []
        };

        this._onDictionariesParametersUpdated = this._onDictionariesParametersUpdated.bind(this);
    }

    componentWillMount() {
        DictionaryStore.addListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
    }

    componentWillUnmount() {
        DictionaryStore.removeListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
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
            <select className={this.props.style} id={this.props.dictionaryName}>
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
}

Dictionary.propTypes = {
    dictionaryName: React.PropTypes.string.isRequired,
    dictionaryTextName: React.PropTypes.string,
    style: React.PropTypes.string
};

Dictionary.defaultProps = {
    style: ""
};
export default Dictionary;

class DictionaryOption extends React.Component {
    render() {
        return (
            <option value={this.props.id}>{this.props.text}</option>
        );
    }
}

DictionaryOption.propTypes = {
    id: React.PropTypes.number.isRequired,
    text: React.PropTypes.string.isRequired
};