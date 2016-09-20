import React from "react";
import DictionaryStore from "../../stores/DictionariesStore";
import NewProductAction from "../../actions/NewProductActions";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";
import Modal from "../general/Modal";
import ModalBody from "../general/ModalBody";
import ModalFooter from "../general/ModalFooter";

class WorkCenterModal extends React.Component {
    render() {
        return (
            <Modal id="work-centers-modal">
                <ModalBody>
                    <WorkCenterGroups/>
                </ModalBody>
                <ModalFooter>
                    <WorkCenterControls/>
                </ModalFooter>
            </Modal>
        );
    }
}

export default WorkCenterModal;

class WorkCenterGroups extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            workCenters: []
        };
        this._onWorkCentersUpdated = this._onWorkCentersUpdated.bind(this);
    }

    componentWillMount() {
        DictionaryStore.addListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onWorkCentersUpdated);
    }

    componentWillUnmount() {
        DictionaryStore.removeListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onWorkCentersUpdated);
    }

    render() {
        var centers = this.state.workCenters;
        var groups = {
            group10: [], group20: [], group30: [], group40: [], group50: [],
            group60: [], group70: [], group80: [], group90: [], group100: []
        };

        centers.forEach(function (item) {
            var groupName = "group" + item.groupPriority;
            if (groups[groupName] !== undefined) {
                groups[groupName].push(<WorkCenterItem item={item}/>);
            }
        });
        return (
            <div className="row">
                <div className="col-md-6">
                    <div className="=row group">
                        {groups.group10}
                    </div>
                    <div className="=row group">
                        {groups.group20}
                    </div>
                    <div className="=row group">
                        {groups.group30}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group40}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group50}
                    </div>
                </div>
                <div className="col-md-6">
                    <div className="=row group">
                        {groups.group60}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group70}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group80}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group90}
                    </div>
                    <div className="=row ungrouped">
                        {groups.group100}
                    </div>
                </div>
            </div>
        );
    }

    _onWorkCentersUpdated() {
        this.setState({
            workCenters: DictionaryStore.getDictionaryParameters("producibility")
        });
    }
}

class WorkCenterItem extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isChecked: this.__checkIfWorkCenterActive()};
        this._handleChangeSelection = this._handleChangeSelection.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__checkIfWorkCenterActive = this.__checkIfWorkCenterActive.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        return (
            <div className="row checkbox">
                <label>
                    <input type="checkbox"
                           checked={this.state.isChecked}
                           id={this.props.item.id}
                           name={this.props.item.serviceCenter}
                           data-group={this.props.item.groupPriority}
                           onChange={this._handleChangeSelection}
                           className="work-centers-checkbox"/>
                    {this.props.item.serviceCenter}
                </label>
            </div>
        );
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            this.setState({isChecked: this.__checkIfWorkCenterActive()})
        }
    }

    __checkIfWorkCenterActive() {
        var notes = NewProductStore.getProductProperty("producibilityNotes");
        //(notes.length > 1) cause we'll usually have AG-center on a first place for each product
        if (notes && notes.length > 1) {
            return notes.some(e => e.serviceCenter.id == this.props.item.id)
        } else {
            return false
        }
    }

    _handleChangeSelection() {
        var newState = !this.state.isChecked;
        this.setState({isChecked: newState});
    }
}

class WorkCenterControls extends React.Component {

    render() {
        return (
            <div className="row text-center">
                <button type="button"
                        className="btn modal-btn "
                        data-dismiss="modal"
                        onClick={this.__onOkClick}>Ok
                </button>
                <button type="button"
                        className="btn modal-btn"
                        data-dismiss="modal">Отмена
                </button>
            </div>
        )
    }

    __onOkClick() {
        NewProductAction.updateProducibilityInfo();
    }
}