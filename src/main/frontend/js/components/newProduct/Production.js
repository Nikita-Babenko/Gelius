import React from 'react';
import DictionaryColoured from "../newProduct/DictionaryColoured";
import NumberInput from "../newProduct/NumberInput";
import BlankFormat from "../newProduct/BlankFormat";
import WorkpieceSizes from "../newProduct/WorkpieceSizes";
import TextArea from "../newProduct/TextArea";

class Production extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            workpieceSize: {
                workpieceLength: "",
                workpieceWidth: ""
            }
        };

        this._updateWorkpieceSizes = this._updateWorkpieceSizes.bind(this);
    }

    render() {
        return (
            <table border="1" className="table middle_table">
                <tbody>
                <tr>
                    <td className="middle_left_title green_color" rowSpan="6">
                        <p className="middle_vertical_left_title">Продукция</p>
                    </td>

                    <td className="middle_products_large_td">Размеры заготовки</td>
                    <td className="middle_products_small_td">
                        <WorkpieceSizes ref="workpieceSizes" update={this._updateWorkpieceSizes}/>
                    </td>

                </tr>

                <tr>
                    <td className="middle_products_large_td">Количество с листа</td>
                    <td className="middle_products_small_td">
                        <NumberInput id="numberFromSheet"/>
                    </td>
                </tr>

                <tr>
                    <td className="middle_products_large_td">Формат заготовки</td>
                    <td className="middle_products_small_td">
                        <BlankFormat workpieceSize={this.state.workpieceSize}/>
                    </td>
                </tr>

                <tr>
                    <td className="middle_products_large_td">Соединение клапана</td>
                    <td className="middle_products_small_td">
                        <DictionaryColoured
                            dictionaryName="connectionValve"
                            dictionaryTextName="connectionValve"
                        />
                    </td>
                </tr>

                <tr>
                    <td className="middle_products_small_td" colSpan="2">
                        <div className="special">Штамп</div>
                        <TextArea id="stamp"/>
                    </td>
                </tr>

                <tr>
                    <td className="middle_products_small_td" colSpan="2">
                        <div className="special">Клише</div>
                        <TextArea id="cliche"/>
                    </td>
                </tr>

                </tbody>

            </table>
        );
    }

    _updateWorkpieceSizes(length, width) {
        this.setState({
            workpieceSize: {
                workpieceLength: length,
                workpieceWidth: width
            }
        });
    }
}

export default Production;