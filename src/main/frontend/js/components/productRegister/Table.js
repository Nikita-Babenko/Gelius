import React from 'react';

class Table extends React.Component {
    render() {
        return (
            <table className="table table-responsive table-bordered products-table">
                {this.props.children}
            </table>
        );
    }
}

export default Table;