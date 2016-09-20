import React from "react";
import ReactDOM from "react-dom";
import EventConstants from "../../constants/Events";
import WorkCentersStore from "../../stores/WorkCentersStore";
import WorkCenterModal from "../newProduct/WorkCenterModal";

class WorkCenterTextarea extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            producibilityCentersText: ""
        };

        this.__showWorkCentersModal = this.__showWorkCentersModal.bind(this);
        this.__updateProducibilityTextArea = this.__updateProducibilityTextArea.bind(this);
    }

    componentWillMount() {
        WorkCentersStore.addListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateProducibilityTextArea);
    }

    componentWillUnmount() {
        WorkCentersStore.removeListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateProducibilityTextArea);
    }

    render() {
        return (
            <div>
                <textarea readOnly
                    onClick={this.__showWorkCentersModal}
                    value={this.state.producibilityCentersText}
                />
                <WorkCenterModal ref="workCenterModal"/>
            </div>
        );
    }

    __updateProducibilityTextArea() {
            this.setState({
                producibilityCentersText: WorkCentersStore.getSelectedCentersText()
            });

    }

    __showWorkCentersModal() {
        $(ReactDOM.findDOMNode(this.refs.workCenterModal)).modal();
    }
}

export default WorkCenterTextarea;