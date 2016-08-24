import React from 'react'
import BodyLeft from '../newProduct/BodyLeft';
import BodyRight from '../newProduct/BodyRight';
import BodyMiddle from '../newProduct/BodyMiddle';

class Body extends React.Component{
    render() {
        return(
            <div className="row" id="productBody">
                <BodyLeft />
                <BodyMiddle />
                <BodyRight />
            </div>
        );
    }
}

export default Body;
