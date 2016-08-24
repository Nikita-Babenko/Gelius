import React from 'react';

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

export default DictionaryOption;