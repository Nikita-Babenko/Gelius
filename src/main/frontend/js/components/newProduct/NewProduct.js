import React from 'react';
import Header from '../newProduct/Header';
import Body from '../newProduct/Body';

class NewProduct extends React.Component {
    render () {
    return (
        <div className="container-fluid target">
            <Header />
            <Body />
        </div>
    );
}
}

export default NewProduct;
