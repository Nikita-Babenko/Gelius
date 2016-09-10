import React from "react";
import WorkCentersStore from "../../stores/WorkCentersStore";
import EventConstants from "../../constants/Events";
import Dictionary from "../newProduct/Dictionary";
import DictionaryColoured from "../newProduct/DictionaryColoured";
import SquareInput from "../newProduct/SquareInput";
import NumberInput from "../newProduct/NumberInput";
import TextArea from "../newProduct/TextArea";
import WorkCenterNotes from "../newProduct/WorkCenterNotes";

class BodyMiddle extends React.Component {

    render() {
        return (
            <div className="col-md-12 col-lg-3 middle">
                <div className="top">
                    <table border="1" className="table middle_table">
                        <tbody>
                        <tr>
                            <td className="middle_left_title green_color" rowSpan="6">
                                <p className="middle_vertical_left_title">Продукция</p>
                            </td>

                            <td className="middle_products_large_td">Размеры заготовки</td>
                            <td className="middle_products_small_td">
                                <div className="inputs">
                                    <NumberInput id="sizeWorkpieceLength" style="input_1"/>
                                    <NumberInput id="sizeWorkpieceWidth" style="input_2"/>
                                </div>
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
                                <NumberInput id="blankFormat"/>
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

                        <tr>
                            <td colSpan="3" className="print_td">
                                <div className="print_input_1">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_2">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_3">
                                    <SquareInput />
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="print_td">
                                <div className="print_input_1">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_2">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_3">
                                    <SquareInput />
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="print_td">
                                <div className="print_input_1">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_2">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_3">
                                    <SquareInput />
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="print_td">
                                <div className="print_input_1">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_2">
                                    <input type="text"/>
                                </div>
                                <div className="print_input_3">
                                    <SquareInput />
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <WorkCenterNotes/>
                </div>
            </div>
        );
    }

}

export default BodyMiddle;