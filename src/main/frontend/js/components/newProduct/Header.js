import React from 'react';
import HeaderLeft from '../newProduct/HeaderLeft';
import HeaderRight from '../newProduct/HeaderRight';

class Header extends React.Component{
    render(){
        return(
            <div className="row" id="productHeader">
                <HeaderLeft />
                <HeaderRight />
            </div>
        );
    }
}

export default Header;



