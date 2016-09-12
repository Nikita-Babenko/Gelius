import React from "react";
import NewProductAction from "../../actions/NewProductActions";
import WorkCentersStore from "../../stores/WorkCentersStore";
import EventConstants from "../../constants/Events";

class WorkCenterNotes extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            selectedCenters: []
        };
        this.__getSelectedCenters = this.__getSelectedCenters.bind(this);
    }

    componentWillMount() {
        WorkCentersStore.addListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__getSelectedCenters);
    }

    componentDidMount() {
        this.__getSelectedCenters();
    }

    componentWillUnmount() {
        WorkCentersStore.removeListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__getSelectedCenters);
    }

    render() {
        var notes = [];
        var centers = this.state.selectedCenters;
        for (var group in centers) {
            if (centers[group].centers.length > 0) {
                notes.push(<WorkCenterNoteRow centersGroup={centers[group]}/>)
            }
        }

        return (
            <table border="1" className="table middle_table">
                <tbody>
                <tr>
                    <td colSpan="4" className="notes green_color">
                        <p>Примечания</p>
                    </td>
                </tr>
                {notes}
                </tbody>
            </table>
        );
    }

    __getSelectedCenters() {
        this.setState({selectedCenters: WorkCentersStore.getSelectedWorkCenters()});
        WorkCentersStore.setUseDefautCenters(false);
    }

}

class WorkCenterNoteRow extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            note: this.props.centersGroup.note,
            centersText: ""
        };
        this.__changeText = this.__changeText.bind(this);
    }

    render() {
        var workCenters = [];
        var groupPriority = this.props.centersGroup.centers[0].serviceCenter.groupPriority;
        this.props.centersGroup.centers.forEach(function (item) {
            workCenters.push(item.serviceCenter.serviceCenter);
        });

        var workCentersString = workCenters.join("/");

        return (
            <tr>
                <td colSpan="4" className="notes_all">
                    <div className="notes_inputs">
                        <div className="special note_input_1">
                            {workCentersString}
                        </div>
                        <textarea
                            className="notes-textarea"
                            value={this.state.note}
                            onChange={this.__changeText}
                            data-group={groupPriority}
                        />
                    </div>
                </td>
            </tr>
        );
    }

    __changeText(event) {
        var note = event.target.value;
        this.setState({note: note});
    }
}

export default WorkCenterNotes;
