import React from 'react';
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";

class TheoreticalSquareInput extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            square: ""
        };

        this.__onSquareInputChange = this.__onSquareInputChange.bind(this);
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this.__calculateTheoreticalSquareValue = this.__calculateTheoreticalSquareValue.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentDidMount() {
        this.__calculateTheoreticalSquareValue();
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        return (
            <input type="text"
                   id="theoreticalSquare"
                   tabIndex="-1"
                   value={this.state.square}
                   onChange={this.__onSquareInputChange}/>
        );
    }

    __onSquareInputChange(e) {
        var newValue = e.target.value;
        var onlyPositiveDecimals = /^(\d?)[.,]?(\d{0,3})$/;
        if (onlyPositiveDecimals.test(newValue)) {
            if (newValue.length === 1 && newValue !== ",")
                newValue += ",";
            this.setState({square: newValue});
        }
    }

    __calculateTheoreticalSquareValue() {
        var self = this;
        var squareParameters = {
            calculatedFormat: 0,
            blankSize: 0,
            blankSizeLength: 0,
            blankSizeWidth: 0,
            numberFromSheet: 0,
            blankFormat: 0,
            getSquare: function () {
                var result = 0;
                if (this.blankFormat !== 0 && this.calculatedFormat !== 0 && this.numberFromSheet !== 0) {
                    this.blankSize = this.blankFormat === this.blankSizeLength ? this.blankSizeWidth : this.blankSizeLength;
                    result = (this.calculatedFormat / 1000) *
                        (this.blankSize / 1000) / this.numberFromSheet /
                        parseInt(this.calculatedFormat / this.blankFormat);
                    result = result.toFixed(3);
                }
                return result;
            },
            getParameterValues: function () {
                this.calculatedFormat = $("#format option:selected").val() !== '' ? Number($("#format option:selected").text()) : 0;
                this.blankSizeLength = Number($("#sizeWorkpieceLength").val());
                this.blankSizeWidth = Number($("#sizeWorkpieceWidth").val());
                this.numberFromSheet = Number($("#numberFromSheet").val());
                this.blankFormat = Number($("#blankFormat option:selected").val());

            }
        };

        $('#format').change(function () {
            squareParameters.getParameterValues();
            self.setState({
                square: squareParameters.getSquare()
            });
        });

        $("#sizeWorkpieceLength").keyup(function () {
            squareParameters.getParameterValues();
            self.setState({
                square: squareParameters.getSquare()
            });
        });

        $("#sizeWorkpieceWidth").keyup(function () {
            squareParameters.getParameterValues();
            self.setState({
                square: squareParameters.getSquare()
            });
        });

        $("#numberFromSheet").keyup(function () {
            squareParameters.getParameterValues();
            self.setState({
                square: squareParameters.getSquare()
            });
        });

        $('#blankFormat').change(function () {
            squareParameters.getParameterValues();
            self.setState({
                square: squareParameters.getSquare()
            });
        });
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var value = NewProductStore.getProductProperty("theoreticalSquare");
            this.setState({
                square: value ? value : ""
            });
        }
    }

}

export default TheoreticalSquareInput;