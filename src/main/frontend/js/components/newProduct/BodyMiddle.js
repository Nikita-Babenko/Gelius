import React from 'react';
import Dictionary from '../newProduct/Dictionary';

class BodyMiddle extends React.Component {
    render() {
        return (
            <div className="col-md-12 col-lg-3 middle">

                <table border="1" className="table middle_table">

                    <tbody>

                    <tr>
                        <td className="middle_left_title green_color" rowSpan="6">
                            <p className="vertical_left_title">Продукция</p>
                        </td>

                        <td className="middle_products_large_td">Размеры заготовки</td>
                        <td className="middle_products_small_td">
                            <div className="inputs">
                                <input type="number" className="input_1 numberInputCheck" id="sizeWorkpieceLength"
                                       min="0"/>
                                <input type="number" className="input_2 numberInputCheck" id="sizeWorkpieceWidth"
                                       min="0"/>
                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Количество с листа</td>
                        <td className="middle_products_small_td"><input type="number" className="numberInputCheck"
                                                                        id="numberFromSheet" min="0"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Формат заготовки</td>
                        <td className="middle_products_small_td"><input required type="number"
                                                                        className="numberInputCheck" id="blankFormat"
                                                                        min="0"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Соединение клапана</td>
                        <td className="middle_products_small_td">
                            <Dictionary
                                dictionaryName="connectionValve"
                                dictionaryTextName="connectionValve"
                            />
                        </td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Штамп</td>
                        <td className="middle_products_small_td"><input type="text" id="stamp"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Клише</td>
                        <td className="middle_products_small_td"><input type="text" id="cliche"/></td>
                    </tr>

                    <tr>
                        <td className="middle_left_title green_color" rowSpan="6">
                            <p className="vertical_left_title">Печать</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text" value="Название" disabled/>
                            </div>
                            <div className="print_input_2">
                                <input type="text" className="numberInputCheck" value="Цена" disabled/>
                            </div>
                            <div className="print_input_3">
                                <input type="text" className="numberInputCheck" value="S запечатки" disabled/>
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
                                <input type="text"/>
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
                                <input type="text"/>
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
                                <input type="text"/>
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
                                <input type="text"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes green_color">
                            <p>Примечания</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>


                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

            </div>
        );
    }
}

export default BodyMiddle;
