import React from 'react';
import DictionaryStore from '../../stores/DictionariesStore';
import NewProductAction from '../../actions/NewProductActions';
import EventConstants from '../../constants/Events';

class WorkCenterModal extends React.Component {
    render() {
        return (
            <div className="modal" id="work-centers-modal">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <ModalBody />
                        <ModalFooter />
                    </div>
                </div>
            </div>
        );
    }
}

export default WorkCenterModal;

class ModalBody extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            //TODO for #1186: add AG (id=1 or id will be find by "groupPriority==null && elementPriority==null") (must it be here or in NewProductStore.getNewProduct()?)
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
            <div className="modal-body">
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
            </div>
        )
    }

    _onWorkCentersUpdated() {
        this.setState({
            workCenters: DictionaryStore.getDictionaryParameters("workability")
        });
    }
}

class WorkCenterItem extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isChecked: false
        };
        this._handleChangeSelection = this._handleChangeSelection.bind(this);
    }

    render() {
        return (
            <div className="row checkbox">
                <label>
                    <input type="checkbox"
                           checked={this.state.isChecked}
                           value={this.props.item.id}
                           onChange={this._handleChangeSelection}
                           className="filter-checkbox"/>
                    {this.props.item.serviceCenter}
                </label>
            </div>
        );
    }

    _handleChangeSelection() {
        var newState = !this.state.isChecked;
        this.setState({isChecked: newState});

        if (newState) {
            NewProductAction.addWorkCenter(this.props.item);
        } else {
            NewProductAction.deleteWorkCenter(this.props.item);
        }
    }
}


class ModalFooter extends React.Component {
    render() {
        return (
            <div className="modal-footer">
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
            </div>
        )
    }

    __onOkClick() {
        NewProductAction.updateWorkabilityInfo();
    }
}