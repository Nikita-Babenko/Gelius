import React from "react";
import SquareInput from "../newProduct/SquareInput";
import NumberInput from "../newProduct/NumberInput";
import WorkCenterNotes from "../newProduct/WorkCenterNotes";
import Production from "../newProduct/Production";

class BodyMiddle extends React.Component {

    render() {
        return (
            <div className="col-md-12 col-lg-3 middle">
                <div className="top">
                    <Production/>

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