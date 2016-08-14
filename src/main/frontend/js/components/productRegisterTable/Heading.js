import React from 'react';

class Heading extends React.Component {
    render() {
        return (
            <th className="text-center">
                <span>
                    {this.props.heading.text}
                </span>
                {this.props.children}
            </th>
        );
    }
}

export default Heading;