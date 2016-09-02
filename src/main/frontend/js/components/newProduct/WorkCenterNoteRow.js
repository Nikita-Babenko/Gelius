import React from 'react';
import NewProductAction from '../../actions/NewProductActions';

class WorkCenterNoteRow extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            note: ""
        };
        this.__changeText = this.__changeText.bind(this);
    }

    __changeText(event) {
        var note = event.target.value;
        var groupPriority = event.target.getAttribute("data-group-priority");
        NewProductAction.updateWorkCenterNote(groupPriority, note);
        this.setState({note: note});
    }

    render() {
        var workCenters = [];
        this.props.workCenterGroup.forEach(function(item) {
            workCenters.push(item.serviceCenter);
        });
        var workCentersString = workCenters.join("/");
        var groupPriority = this.props.workCenterGroup[0].groupPriority;
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
                            className="note_input_2"
                            value={this.state.note}
                            onChange={this.__changeText}
                            data-group-priority={groupPriority}
                        />
                    </div>
                </td>
            </tr>
        );
    }
}

export default WorkCenterNoteRow;
