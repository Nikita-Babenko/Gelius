import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class DatePicker extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            date: "",
            isChangeDateDisabled: false
        };

        this.__changeDate = this.__changeDate.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        return (
            <input type="date"
                   className={this.props.class}
                   id={this.props.id}
                   value={this.state.date}
                   onChange={this.__changeDate}
                   disabled={this.state.isChangeDateDisabled}
            />
        );
    }

    __changeDate(e) {
        this.setState({date: e.target.value});
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var receivedDate = NewProductStore.getProductProperty(this.props.id);
            var value = receivedDate ? __transformDate(receivedDate) : "";

            this.setState({
                date: value
            });

            if (this.props.id === "productCreateDate") {
                this.setState({
                    isChangeDateDisabled: NewProductStore.isInEditMode()
                });
            }
        }
    }
}

DatePicker.propTypes = {
    id: React.PropTypes.string,
    class: React.PropTypes.string
};

DatePicker.defaultProps = {
    id: "",
    class: ""
};

function __transformDate(date) {
    var year = date[0];
    var month = date[1] < 10 ? "0" + date[1] : date[1];
    var day = date[2] < 10 ? "0" + date[2] : date[2];
    return year + '-' + month + '-' + day;
}

export default DatePicker;