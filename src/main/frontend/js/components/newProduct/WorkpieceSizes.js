import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";
import UpdateStore from "../../stores/UpdateStore";

class WorkpieceSizes extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            workpieceLength: "",
            workpieceWidth: "",
            disableWorkpieceWidth: false
        };

        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__updateWorkpieceWidth = this.__updateWorkpieceWidth.bind(this);
        this.__onWorkpieceLengthChange = this.__onWorkpieceLengthChange.bind(this);
        this.__onWorkpieceWidthChange = this.__onWorkpieceWidthChange.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
        UpdateStore.addListener(EventConstants.UPDATE_CHANGE_EVENT, this.__updateWorkpieceWidth);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
        UpdateStore.removeListener(EventConstants.UPDATE_CHANGE_EVENT, this.__updateWorkpieceWidth);
    }

    render() {
        return (
            <div className="inputs">
                <input type="text"
                       ref="workpieceLength"
                       className="numberInputCheck input_1"
                       id="sizeWorkpieceLength"
                       value={this.state.workpieceLength}
                       onChange={this.__onWorkpieceLengthChange}
                />
                <input type="text"
                       ref="workpieceWidth"
                       className="numberInputCheck input_2"
                       id="sizeWorkpieceWidth"
                       value={this.state.workpieceWidth}
                       onChange={this.__onWorkpieceWidthChange}
                       disabled={this.state.disableWorkpieceWidth}
                />
            </div>
        );
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var length = NewProductStore.getProductProperty("sizeWorkpieceLength");
            var width = NewProductStore.getProductProperty("sizeWorkpieceWidth");
            this.props.update(length ? length : "", width ? width : "");
            this.setState({
                workpieceLength: length ? length : "",
                workpieceWidth: width ? width : ""
            });
        }
    }

    __onWorkpieceLengthChange(ev) {
        this.setState({workpieceLength: ev.target.value});
        this.props.update(ev.target.value, this.state.workpieceWidth);
    }

    __onWorkpieceWidthChange(ev) {
        this.setState({workpieceWidth: ev.target.value});
        this.props.update(this.state.workpieceLength, ev.target.value);
    }

    __updateWorkpieceWidth() {
        var data = UpdateStore.getWorkpieceWidthData();
        if (data.value !== undefined) {
            this.setState({
                workpieceWidth: data.value,
                disableWorkpieceWidth: data.isDisabled
            });
            this.props.update(this.state.workpieceLength, data.value);
            $("#sizeWorkpieceWidth").keyup();
        }
    }
}

export default WorkpieceSizes;