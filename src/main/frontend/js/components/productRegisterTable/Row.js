import React from 'react';

class Row extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.row.id ? this.props.row.id : "-"}</td>
                <td>{this.props.row.client ? this.props.row.client.companyName : "-"}</td>
                <td>{this.props.row.productName ? this.props.row.productName : "-"}</td>
                <td>{this.props.row.productType ? this.props.row.productType.productType : "-"}</td>
                <td>{this.props.row.innerLength ? this.props.row.innerLength : "-"}</td>
                <td>{this.props.row.innerWidth ? this.props.row.innerWidth : "-"}</td>
                <td>{this.props.row.innerHeight ? this.props.row.innerHeight : "-"}</td>
                <td>{this.props.row.cardboardBrand ? this.props.row.cardboardBrand.cardboardBrand : "-"}</td>
                <td>{this.props.row.profile ? this.props.row.profile.profile : "-"}</td>
                <td>{this.props.row.layersColours ? this.props.row.layersColours : "-"}</td>
                <td>{this.props.row.cliche ? this.props.row.cliche : "-"}</td>
            </tr>
        );
    }
}

export default Row;