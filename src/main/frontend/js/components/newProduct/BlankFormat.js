import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class BlankFormat extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <select id="blankFormat">
                <option value="">не выбран</option>
                {this.props.workpieceSize.workpieceLength !== "" ?
                    <FormatOption size={this.props.workpieceSize.workpieceLength}/> : ""}
                {this.props.workpieceSize.workpieceWidth !== "" ?
                    <FormatOption size={this.props.workpieceSize.workpieceWidth}/> : false}
            </select>
        );
    }

    componentDidUpdate() {
        var value = NewProductStore.getProductProperty("blankFormat");
        $('#blankFormat').val(value ? value : '');
    }

}

export default BlankFormat;

class FormatOption extends React.Component {
    render() {
        return (
            <option value={this.props.size}>
                {this.props.size}
            </option>
        );
    }
}

FormatOption.propTypes = {
    size: React.PropTypes.number.isRequired
};