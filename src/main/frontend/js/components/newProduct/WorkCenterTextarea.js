import React from 'react';
import ReactDOM from "react-dom";
import EventConstants from "../../constants/Events";
import WorkCentersStore from "../../stores/WorkCentersStore";
import NewProductStore from "../../stores/NewProductStore";
import WorkCenterModal from "../newProduct/WorkCenterModal";

class WorkCenterTextarea extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            workabilityCentersText: ""
        };

        this.__showWorkCentersModal = this.__showWorkCentersModal.bind(this);
        this.__updateWorkabilityTextArea = this.__updateWorkabilityTextArea.bind(this);
    }

    componentWillMount() {
        WorkCentersStore.addListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateWorkabilityTextArea);
    }

    componentWillUnmount() {
        WorkCentersStore.removeListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateWorkabilityTextArea);
    }

    render() {
        return (
            <div>
                <textarea readOnly
                    onClick={this.__showWorkCentersModal}
                    value={this.state.workabilityCentersText}
                />
                <WorkCenterModal ref="modal"/>
            </div>
        );
    }

    __updateWorkabilityTextArea() {
        if (NewProductStore.isEnableDefaultValues()) {
            this.setState({
                workabilityCentersText: WorkCentersStore.getSelectedCentersText()
            });
        }
    }

    __showWorkCentersModal() {
        $(ReactDOM.findDOMNode(this.refs.modal)).modal();
    }
}

export default WorkCenterTextarea;