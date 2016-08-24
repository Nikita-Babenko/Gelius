import React from 'react';

class DatePicker extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            date: this.props.todayDate
        };

        this.__changeDate = this.__changeDate.bind(this);
    }

    render() {
        return (
            <input type="date" className={this.props.class} id={this.props.id}
                   value={this.state.date} onChange={this.__changeDate}/>
        );
    }

    __changeDate(e) {
        this.setState({date: e.target.value});
    }
}

DatePicker.propTypes = {
    todayDate: React.PropTypes.string,
    id: React.PropTypes.string,
    class: React.PropTypes.string
};

DatePicker.defaultProps = {
    todayDate: __getTodayDate(),
    id: "",
    class: ""
};

function __getTodayDate() {
    var now = new Date();
    var month = (now.getMonth() + 1);
    var day = now.getDate();
    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;
    return +now.getFullYear() + '-' + month + '-' + day;
}

export default DatePicker;