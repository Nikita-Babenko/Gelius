import React from 'react';
//import NewProductAction from '../../actions/NewProductActions';
//import EventConstants from '../../constants/Events';

class WorkCenterNoteRow extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            note: ""
        };
        this.__changeText = this.__changeText.bind(this);
    }

    __changeText(event) {
        this.setState({note: event.target.value});
    }

    render() {
        var workCenters = [];
        this.props.workCenterGroup.forEach(function(group) {
            workCenters.push(group.serviceCenter);
        });
        var workCentersString = workCenters.join("/");
        var index = this.props.index;
        return (
            <tr>
                <td colSpan="4" className="notes_all">
                    <div className="notes_inputs">
                        <input
                            value={workCentersString}
                            type="text"
                            className="note_input_1"
                            disabled
                        />
                        <input
                            type="text"
                            id={"workCenterNote_" + index}
                            className="note_input_2"
                            value={this.state.note}
                            onChange={this.__changeText}
                        />
                    </div>
                </td>
            </tr>
        );
    }
}

export default WorkCenterNoteRow;
