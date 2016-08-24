import React from 'react';

class WorkCenterModal extends React.Component {
    render() {
        return (
            <div className="modal" id="work-centers-modal">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <WorkCenterModal.ModalBody />
                        <WorkCenterModal.ModalFooter />
                    </div>
                </div>
            </div>
        );
    }
}

export default WorkCenterModal;

var productCenters = [
    {id: 1, serviceCenter: "Тайванец", groupPriority: 10, elementPriority: 10},
    {id: 2, serviceCenter: "Болгарец", groupPriority: 10, elementPriority: 20},
    {id: 3, serviceCenter: "Сшивка ручная", groupPriority: 20, elementPriority: 10},
    {id: 4, serviceCenter: "Сшивка автомат", groupPriority: 20, elementPriority: 20},
    {id: 5, serviceCenter: "Склейка ручная", groupPriority: 30, elementPriority: 10},
    {id: 6, serviceCenter: "Склейка 3 точки", groupPriority: 30, elementPriority: 20},
    {id: 7, serviceCenter: "БОБСТ", groupPriority: 40, elementPriority: null},
    {id: 8, serviceCenter: "Ротация", groupPriority: 50, elementPriority: null},
    {id: 9, serviceCenter: "Тигель большой", groupPriority: 60, elementPriority: 10},
    {id: 10, serviceCenter: "Тигель малый", groupPriority: 60, elementPriority: 20},
    {id: 11, serviceCenter: "Ролевый", groupPriority: 60, elementPriority: 30},
    {id: 12, serviceCenter: "К. Р.", groupPriority: 70, elementPriority: null},
    {id: 13, serviceCenter: "БОИКС", groupPriority: 80, elementPriority: null},
    {id: 14, serviceCenter: "Перегородки", groupPriority: 90, elementPriority: null},
    {id: 15, serviceCenter: "Упаковка", groupPriority: 100, elementPriority: null}
];

WorkCenterModal.ModalBody = React.createClass({
    render: function () {
        var group1 = [], group2 = [], group3 = [], group45 = [], group6 = [], group78910 = [];
        productCenters.forEach(function (item) {
            switch (item.groupPriority) {
                case 10:
                    group1.push(<WorkCenterItem item={item}/>);
                    break;
                case 20:
                    group2.push(<WorkCenterItem item={item}/>);
                    break;
                case 30:
                    group3.push(<WorkCenterItem item={item}/>);
                    break;
                case 40:
                case 50:
                    group45.push(<WorkCenterItem item={item}/>);
                    break;
                case 60:
                    group6.push(<WorkCenterItem item={item}/>);
                    break;
                case 70:
                case 80:
                case 90:
                case 100:
                    group78910.push(<WorkCenterItem item={item}/>);
                    break;
                default :
                    console.log("don't match any group priority");

            }
        });
        return (
            <div className="modal-body">
                <div className="row">
                    <div className="col-md-6">
                        <div className="=row group">
                            {group1}
                        </div>
                        <div className="=row group">
                            {group2}
                        </div>
                        <div className="=row group">
                            {group3}
                        </div>
                        <div className="=row ungrouped">
                            {group45}
                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="=row group">
                            {group6}
                        </div>
                        <div className="=row ungrouped">
                            {group78910}
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

var WorkCenterItem = React.createClass({
    getInitialState: function () {
        return {isChecked: false};
    },
    render: function () {
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
    },

    _handleChangeSelection: function () {
        var newState = !this.state.isChecked;
        this.setState({isChecked: newState});

        if (newState)
            switch (this.props.item.groupPriority) {
                case 10:
                    selectedWorkCenters.group1.push(this.props.item);
                    break;
                case 20:
                    selectedWorkCenters.group2.push(this.props.item);
                    break;
                case 30:
                    selectedWorkCenters.group3.push(this.props.item);
                    break;
                case 60:
                    selectedWorkCenters.group6.push(this.props.item);
                    break;
                default:
                    selectedWorkCenters.other.push(this.props.item)
            }
        else
            switch (this.props.item.groupPriority) {
                case 10:
                    selectedWorkCenters.group1.splice($.inArray(this.props.item, selectedWorkCenters.group1), 1);
                    break;
                case 20:
                    selectedWorkCenters.group2.splice($.inArray(this.props.item, selectedWorkCenters.group2), 1);
                    break;
                case 30:
                    selectedWorkCenters.group3.splice($.inArray(this.props.item, selectedWorkCenters.group3), 1);
                    break;
                case 60:
                    selectedWorkCenters.group6.splice($.inArray(this.props.item, selectedWorkCenters.group6), 1);
                    break;
                default:
                    selectedWorkCenters.other.splice($.inArray(this.props.item, selectedWorkCenters.other), 1)

            }
        console.log(selectedWorkCenters);
    }
});

var selectedWorkCenters = {
    group1: [],
    group2: [],
    group3: [],
    group6: [],
    other: []
};

WorkCenterModal.ModalFooter = React.createClass({
    render: function () {
        return (
            <div className="modal-footer">
                <div className="row text-center">
                    <button type="button" className="btn modal-btn " data-dismiss="modal" onClick={this.__onOkCilck}>
                        Ok
                    </button>
                    <button type="button" className="btn modal-btn" data-dismiss="modal">Отмена</button>
                </div>
            </div>
        )
    },

    __onOkCilck: function () {
        console.log("onOkClickAction");
    }
});