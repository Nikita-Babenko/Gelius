import React from 'react';

class BodyRight extends React.Component{
    render(){
        return(
            <div className="col-md-12 col-lg-4 right">

                <table border="1" className="table right_table">

                    <tbody>

                    <tr>
                        <td className="avto_left_title green_color" rowSpan="8">
                            <p className="vertical_left_title">Авто</p>
                        </td>
                        <td className="avto_large_td">Способ упаковки</td>
                        <td className="avto_small_td">
                            <select id="packing">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В пачке, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberInPack"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В транспортном пакете, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberInTransportPackage"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">
                            Размеры пакета
                            <input className="embeded_input" type="number" id="packageLength"/>
                        </td>
                        <td className="avto_small_td">
                            <div className="inputs">
                                <input type="number" className="input_1" id="packageWidth"/>
                                <input type="number" className="input_2" id="packageHeight"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Поддон</td>
                        <td className="avto_small_td">
                            <select id="pallet">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Размещение на поддоне</td>
                        <td className="avto_small_td">
                            <select id="palletPlacement">

                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td className="avto_large_td">Рядов на поддоне</td>
                        <td className="avto_small_td"><input type="number" id="palletRows"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Загрузка автомобиля, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberLoadCar"/></td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="attachments">
                            <div className="links">
                                <a href="#">тех.карта.pdf</a><br/>
                                <a href="#">ссылка2.ai</a>
                            </div>
                            <div className="buttons">
                                <a className="fa fa-paperclip fa-2x" href="#">
                                </a>
                                <a className="fa fa-trash-o fa-2x" href="#">
                                </a>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Биговки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="bigovki_all">
                            <div className="bigovki_inputs_1">
                                <input type="number" className="bigovki_input_1 sumBigovki" min="0"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_2">
                                <input type="number" className="bigovki_input_1 sumBigovki" min="0"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_3">
                                <input type="number" className="bigovki_input_3 sumBigovki" min="0"/>
                                <input type="number" className="bigovki_input_4 sumBigovki" min="0"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td" colSpan="2">Производственный формат</td>
                        <td className="avto_small_td"><input type="number" id="productionFormat"/></td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Просечки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="prosechki_all">
                            <div className="prosechki_inputs">
                                <input type="number" className="prosechki_input_1"/>
                                <input type="number" className="prosechki_input_2"/>
                                <input type="number" className="prosechki_input_3"/>
                                <input type="number" className="prosechki_input_4"/>
                                <input type="number" className="prosechki_input_5"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <div className="buttonContainer">
                    <div className="buttons_bottom">
                        <a className="fa fa-pencil  fa-3x" href="#">
                        </a>
                        <a className="fa fa-plus fa-3x" href="#" id="addNew">
                        </a>
                        <a className="fa fa-trash fa-3x" href="#">
                        </a>
                    </div>
                </div>

            </div>
        );
    }
}

export default BodyRight;
