import React from "react";
import EventConstants from "../../constants/Events";
import Dictionary from "../newProduct/Dictionary";
import SquareInput from "../newProduct/SquareInput";
import NumberInput from "../newProduct/NumberInput";
import TextArea from "../newProduct/TextArea";
import WorkCenterTextarea from "../newProduct/WorkCenterTextarea";

class BodyLeft extends React.Component {

    render() {
        return (
            <div className="col-md-12 col-lg-5 left">
                <table border="1" className="table left_table">
                    <tbody>
                    <tr>
                        <td className="left_title green_color" rowSpan="5">
                            <p className="vertical_left_title">Продукция</p>
                        </td>
                        <td className="products_large_td">Размеры внутренние</td>
                        <td className="products_small_td">
                            <NumberInput id="innerLength"/>
                        </td>
                        <td className="products_large_td">
                            <NumberInput id="innerWidth"/>
                        </td>
                        <td className="products_small_td">
                            <NumberInput id="innerHeight"/>
                        </td>
                    </tr>

                    <tr>
                        <td className="products_large_td">S теор.</td>
                        <td className="products_small_td">
                            <SquareInput id="theoreticalSquare"/>
                        </td>
                        <td className="products_large_td">S факт.</td>
                        <td className="products_small_td">
                            <SquareInput id="actualSquare"/>
                        </td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Расчетный формат</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="format"
                                dictionaryTextName="format"
                            />
                        </td>
                        <td className="products_large_td">Профиль</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="profile"
                                dictionaryTextName="profile"
                            />
                        </td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Марка картона</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="cardboardBrand"
                                dictionaryTextName="cardboardBrand"
                            />
                        </td>
                        <td className="products_large_td">Целлюлозный слой</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="celluloseLayer"
                                dictionaryTextName="celluloseLayer"
                            />
                        </td>
                    </tr>


                    <tr>
                        <td className="products_large_td">Лицевой слой</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="faceLayer"
                                dictionaryTextName="faceLayer"
                            />
                        </td>
                        <td className="products_large_td">Внутренний слой</td>
                        <td className="products_small_td">
                            <Dictionary
                                dictionaryName="innerLayer"
                                dictionaryTextName="innerLayer"
                            />
                        </td>
                    </tr>

                    <tr>
                        <td className="left_title green_color" rowSpan="4">
                            <p className="vertical_left_title">Материал</p>
                        </td>
                        <td colSpan="4" className="material">
                            <TextArea id="material"/>
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
                            <TextArea id="specialConditions"/>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability green_color">
                            <p>Технологичность</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability_textarea">
                            <WorkCenterTextarea />
                        </td>
                    </tr>

                    </tbody>

                </table>
            </div>
        );
    }

}

export default BodyLeft;