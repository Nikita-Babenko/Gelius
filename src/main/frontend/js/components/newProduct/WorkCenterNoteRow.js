import React from "react";
import NewProductAction from "../../actions/NewProductActions";

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
                        <div className="note_input_1" contentEditable="true">
                            {workCentersString}
                        </div>
                        <div className="note_input_2" contentEditable="true" onChange={this.__changeText}
                             data-group-priority={groupPriority}>
                            {this.state.note}
                        </div>
                    </div>
                </td>
            </tr>
        );
    }
}

export default WorkCenterNoteRow;
