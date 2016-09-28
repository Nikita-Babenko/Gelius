import React from "react";
import SquareInput from "../newProduct/SquareInput";
import NumberInput from "../newProduct/NumberInput";
import WorkCenterNotes from "../newProduct/WorkCenterNotes";
import Production from "../newProduct/Production";
import Print from "../newProduct/Print";

class BodyMiddle extends React.Component {
    render() {
        return (
            <div className="col-md-12 col-lg-3 middle">
                <div className="top">
                    <Production/>
                    <Print/>
                    <WorkCenterNotes/>
                </div>
            </div>
        );
    }
}

export default BodyMiddle;