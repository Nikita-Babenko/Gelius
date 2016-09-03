import React from "react";
import Dictionary from "../newProduct/Dictionary";
import UploadFiles from "../newProduct/UploadFiles";
import NumberInput from "../newProduct/NumberInput";

class BodyRight extends React.Component {
    render() {
        return (
            <div className="col-md-12 col-lg-4 right">

                <table border="1" className="table right_table">

                    <tbody>

                    <tr>
                        <td className="avto_left_title green_color" rowSpan="8">
                            <p className="vertical_left_title">Авто</p>
                        </td>
                        <td className="avto_large_td">Способ упаковки</td>
                        <td className="avto_small_td">
                            <Dictionary
                                dictionaryName="packing"
                                dictionaryTextName="packing"
                            />
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В пачке, шт.</td>
                        <td className="avto_small_td">
                            <NumberInput id="numberInPack"/>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В транспортном пакете, шт.</td>
                        <td className="avto_small_td">
                            <NumberInput id="numberInTransportPackage"/>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">
                            Размеры пакета
                            <NumberInput id="packageLength" style="embeded_input"/>
                        </td>
                        <td className="avto_small_td">
                            <div className="inputs">
                                <NumberInput id="packageWidth" style="input_1"/>
                                <NumberInput id="packageHeight" style="input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Поддон</td>
                        <td className="avto_small_td">
                            <Dictionary
                                dictionaryName="pallet"
                                dictionaryTextName="pallet"
                            />
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Размещение на поддоне</td>
                        <td className="avto_small_td">
                            <Dictionary
                                dictionaryName="palletPlacement"
                                dictionaryTextName="palletPlacement"
                            />
                        </td>
                    </tr>


                    <tr>
                        <td className="avto_large_td">Рядов на поддоне</td>
                        <td className="avto_small_td">
                            <NumberInput id="palletRows"/>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Загрузка автомобиля, шт.</td>
                        <td className="avto_small_td">
                            <NumberInput id="numberLoadCar"/>
                        </td>
                    </tr>

                    <tr>
                        <UploadFiles />
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Биговки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="bigovki_all">
                            <div className="bigovki_inputs_1">
                                <input type="number" className="bigovki_input_1 sumBigovki numberInputCheck" min="0"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_2">
                                <input type="number" className="bigovki_input_1 sumBigovki numberInputCheck" min="0"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_3">
                                <input type="number" className="bigovki_input_3 sumBigovki numberInputCheck" min="0"/>
                                <input type="number" className="bigovki_input_4 numberInputCheck" min="0"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td" colSpan="2">Производственный формат</td>
                        <td className="avto_small_td">
                            <NumberInput id="productionFormat"/>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Просечки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="prosechki_all">
                            <div className="prosechki_inputs">
                                <input type="number" className="prosechki_input_1 numberInputCheck"/>
                                <input type="number" className="prosechki_input_2 numberInputCheck"/>
                                <input type="number" className="prosechki_input_3 numberInputCheck"/>
                                <input type="number" className="prosechki_input_4 numberInputCheck"/>
                                <input type="number" className="prosechki_input_5 numberInputCheck"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <div className="buttonContainer">
                    <div className="buttons_bottom icon_buttons_group">
                        <a className="fa fa-pencil  fa-2x" href="#">
                        </a>
                        <a className="fa fa-plus fa-2x" href="#" id="addNew">
                        </a>
                        <a className="fa fa-trash-o fa-2x" href="#">
                        </a>
                    </div>
                </div>

            </div>
        );
    }
}

export default BodyRight;
