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
            group1: [], group2: [], group3: [], group4_5: [], group6: [], group7_10: []
        };

        centers.forEach(function (item) {
            switch (item.groupPriority) {
                case 10:
                    groups.group1.push(<WorkCenterItem item={item}/>);
                    break;
                case 20:
                    groups.group2.push(<WorkCenterItem item={item}/>);
                    break;
                case 30:
                    groups.group3.push(<WorkCenterItem item={item}/>);
                    break;
                case 40:
                case 50:
                    groups.group4_5.push(<WorkCenterItem item={item}/>);
                    break;
                case 60:
                    groups.group6.push(<WorkCenterItem item={item}/>);
                    break;
                case 70:
                case 80:
                case 90:
                case 100:
                    groups.group7_10.push(<WorkCenterItem item={item}/>);
                    break;

            }
        });
        return (
            <div className="modal-body">
                <div className="row">
                    <div className="col-md-6">
                        <div className="=row group">
                            {groups.group1}
                        </div>
                        <div className="=row group">
                            {groups.group2}
                        </div>
                        <div className="=row group">
                            {groups.group3}
                        </div>
                        <div className="=row ungrouped">
                            {groups.group4_5}
                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="=row group">
                            {groups.group6}
                        </div>
                        <div className="=row ungrouped">
                            {groups.group7_10}
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