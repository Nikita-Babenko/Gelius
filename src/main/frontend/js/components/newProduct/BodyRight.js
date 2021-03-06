import React from "react";
import Dictionary from "../newProduct/Dictionary";
import FileLinksContainer from "../newProduct/FileLinksContainer";
import NumberInput from "../newProduct/NumberInput";
import Bigovki from "../newProduct/Bigovki";
import Perforations from "../newProduct/Perforations";
import ProductionFormat from "../newProduct/ProductionFormat";
import FooterControlButtons from "../newProduct/FooterControlButtons";

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
                        <FileLinksContainer />
                    </tr>

                    <tr>
                        <td className="avto_large_td" colSpan="2">Производственный формат</td>
                        <td className="avto_small_td">
                            <ProductionFormat/>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Биговки
                        </td>
                    </tr>

                    <tr>
                        <Bigovki/>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Просечки
                        </td>
                    </tr>

                    <tr>
                        <Perforations />
                    </tr>

                    </tbody>
                </table>

                <FooterControlButtons/>

            </div>
        );
    }
}

export default BodyRight;
