import React from 'react';
import ReactDOM from 'react-dom';
import EventConstants from '../../constants/Events';
import WorkCentersStore from '../../stores/WorkCentersStore';
import WorkCenterModal from '../newProduct/WorkCenterModal';
import Dictionary from '../newProduct/Dictionary';
import SquareInput from '../newProduct/SquareInput';

class BodyLeft extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            workabilityCentersText: ""
        };

        this.__showWorkCentersModal = this.__showWorkCentersModal.bind(this);
        this.__updateWorkabilityTextArea = this.__updateWorkabilityTextArea.bind(this);
    }

    componentWillMount() {
        WorkCentersStore.addListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateWorkabilityTextArea);
    }

    componentWillUnmount() {
        WorkCentersStore.removeListener(EventConstants.WORK_CENTERS_CHANGE_EVENT, this.__updateWorkabilityTextArea);
    }

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
                        <td className="products_small_td"><input className="numberInputCheck" type="number"
                                                                 id="innerLength" min="0"/></td>
                        <td className="products_large_td"><input className="numberInputCheck" type="number"
                                                                 id="innerWidth" min="0"/></td>
                        <td className="products_small_td"><input className="numberInputCheck" type="number"
                                                                 id="innerHeight" min="0"/></td>
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
                                defaultValue="1"
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
                            <textarea readOnly onClick={this.__showWorkCentersModal}
                                      value={this.state.workabilityCentersText}/>
                            <WorkCenterModal ref="modal"/>
                        </td>
                    </tr>

                    </tbody>

                </table>
            </div>
        );
    }

    __updateWorkabilityTextArea() {
        this.setState({
            workabilityCentersText: WorkCentersStore.getSelectedCentersText()
        });
    }

    __showWorkCentersModal() {
        $(ReactDOM.findDOMNode(this.refs.modal)).modal();
    }
}

export default BodyLeft;