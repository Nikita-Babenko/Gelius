import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class Print extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            prints: []
        };

        this.__loadDefaultValues = this.__loadDefaultValues.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValues);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        var printItems = [];
        var defaultPrintItems = this.state.prints;
        var emptyPrintItem = {
            "color": "",
            "name": "",
            "squareSeal": ""
        };
        for (var i = 0; i < 4; i++)
            if (i < defaultPrintItems.length)
                printItems.push(<PrintItem key={i} item={defaultPrintItems[i]}/>);
            else
                printItems.push(<PrintItem key={i} item={emptyPrintItem}/>);

        return (
            <table border="1" className="table middle_table">
                <tbody>
                <tr>
                    <td className="middle_left_title green_color" rowSpan="6">
                        <p className="vertical_left_title">Печать</p>
                    </td>
                </tr>

                <tr>
                    <td colSpan="3" className="print_td">
                        <div className="print_input_1">
                            <input type="text" value="Цвет" disabled/>
                        </div>
                        <div className="print_input_2">
                            <input type="text" value="Название" disabled/>
                        </div>
                        <div className="print_input_3">
                            <input type="text" value="S запечатки" disabled/>
                        </div>
                    </td>
                </tr>

                {printItems}

                </tbody>

            </table>
        );
    }

    __loadDefaultValues() {
        if (NewProductStore.isEnableDefaultValues()) {
            var values = NewProductStore.getProductProperty("prints");
            this.setState({
                prints: values ? values : []
            });
        }
    }
}

export default Print;

class PrintItem extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            hex: props.item.color,
            colorName: props.item.name,
            squareSeal: props.item.squareSeal,
            inputColor: {
                backgroundColor: '',
                color: ''
            }
        };

        this.__changeInputColor = this.__changeInputColor.bind(this);
    };

    componentWillReceiveProps(nextProps) {
        if ((nextProps.item.color !== this.state.hex) || (nextProps.item.name !== this.state.squareSeal) || (nextProps.item.name !== this.state.squareSeal))
            this.setState({
                hex: nextProps.item.color ? nextProps.item.color : "",
                colorName: nextProps.item.name,
                squareSeal: nextProps.item.squareSeal ? nextProps.item.squareSeal : "",
                inputColor: {
                    backgroundColor: nextProps.item.color ? '#' + nextProps.item.color : '',
                    color: nextProps.item.color ? '#' + this.invertColor(nextProps.item.color) : ''
                }
            });
    }

    render() {
        return (
            <tr>
                <td colSpan="3" className="print_td print_values">
                    <div className="print_input_1">
                        <input type="text"
                               style={this.state.inputColor}
                               value={this.state.hex}
                               onChange={this.__onColouredInputValueChange.bind(this)}
                        />
                    </div>
                    <div className="print_input_2">
                        <input type="text"
                               value={this.state.colorName}
                               onChange={this.__onColorNameChange.bind(this)}
                        />
                    </div>
                    <div className="print_input_3">
                        <input type="text"
                               value={this.state.squareSeal}
                               onChange={this.__onSquareSealChange.bind(this)}
                        />
                    </div>
                </td>
            </tr>
        );
    }

    __onColouredInputValueChange(e) {
        var newValue = e.target.value;
        var availableHexSymbols = /^([0-9]|[A-f]){0,6}$/;
        if (availableHexSymbols.test(newValue)) {
            this.setState({hex: newValue});
            this.__changeInputColor(newValue);
        }
    }

    __changeInputColor(hex) {
        var hexRegexp = /([0-9]|[A-f]){6}/;
        if (hexRegexp.test(hex))
            this.setState({
                inputColor: {
                    backgroundColor: '#' + hex,
                    color: '#' + this.invertColor(hex)
                }
            });
        else
            this.setState({
                inputColor: {
                    backgroundColor: "white",
                    color: "black"
                }
            });
    }

    invertColor(hex) {
        var color = hex;
        if (color.length === 6) {
            color = parseInt(color, 16);
            color = 0xFFFFFF ^ color;
            color = color.toString(16);
            color = ("000000" + color).slice(-6)
        } else color = "000000";
        return color;
    }

    __onColorNameChange(e) {
        this.setState({colorName: e.target.value});
    }

    __onSquareSealChange(e) {
        var newValue = e.target.value;
        var onlyPositiveDecimals = /^(\d?)[.,]?(\d{0,3})$/;
        if (onlyPositiveDecimals.test(newValue)) {
            if (newValue.length === 1 && newValue !== ",")
                newValue += ",";

            this.setState({squareSeal: newValue});
        }
    }
}

PrintItem.propTypes = {
    item: React.PropTypes.object.isRequired
};