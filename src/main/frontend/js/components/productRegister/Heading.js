import React from 'react';
import Dropdown from '../productRegister/Dropdown';

class Heading extends React.Component {
    render() {
        return (
            <div>
                <span>
                    {this.props.heading.text}
                </span>
                <Dropdown columnName={this.props.heading.name} position={this.props.position}/>
            </div>
        );
    }
}

export default Heading;