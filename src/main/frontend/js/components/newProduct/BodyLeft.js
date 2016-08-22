import React from 'react';

class BodyLeft extends React.Component{
    render(){
        return(
            <div className="col-md-12 col-lg-5 left">
                <table border="1" className="table left_table">

                    <tbody>

                    <tr>
                        <td className="left_title green_color" rowSpan="5">
                            <p className="vertical_left_title">Продукция</p>
                        </td>
                        <td className="products_large_td">Размеры внутренние</td>
                        <td className="products_small_td" ><input type="number" id="innerLength"/></td>
                        <td className="products_large_td" ><input type="number" id="innerWidth"/></td>
                        <td className="products_small_td" ><input type="number" id="innerHeight"/></td>
                    </tr>

                    <tr>
                        <td className="products_large_td">S теор.</td>
                        <td className="products_small_td" ><input  type="number" id="theoreticalSquare"/></td>
                        <td className="products_large_td">S факт.</td>
                        <td className="products_small_td" ><input type="number" id="actualSquare"/></td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Расчетный формат</td>
                        <td className="products_small_td">
                            <select id="format">

                            </select>
                        </td>
                        <td className="products_large_td">Профиль</td>
                        <td className="products_small_td">
                            <select id="profile">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Марка картона</td>
                        <td className="products_small_td">
                            <select id="cardboardBrand">

                            </select>
                        </td>
                        <td className="products_large_td">Целлюлозный слой</td>
                        <td className="products_small_td">
                            <select id="celluloseLayer">

                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td className="products_large_td">Лицевой слой</td>
                        <td className="products_small_td">
                            <select id="faceLayer">
                            </select>
                        </td>
                        <td className="products_large_td">Внутренний слой</td>
                        <td className="products_small_td">
                            <select id="innerLayer">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="left_title green_color" rowSpan="4">
                            <p className="vertical_left_title">Материал</p>
                        </td>
                        <td colSpan="4" className="material">
                        <textarea id="material">

                        </textarea>
                        </td>
                    </tr>

                    <tr></tr>
                    <tr></tr>
                    <tr></tr>

                    <tr>
                        <td colSpan="5" className="special_conditions green_color">
                            <p>Особые условия</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="special_conditions_textarea">
                        <textarea>

                        </textarea>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability green_color">
                            <p>Технологичность</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability_textarea">
                        <textarea>

                        </textarea>
                        </td>
                    </tr>

                    </tbody>

                </table>
            </div>
        );
    }
}

export default BodyLeft;