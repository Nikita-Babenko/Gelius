var productTableColumnNames = [
    {name: 'id', text: '№'},
    {name: 'client', text: 'Клиент'},
    {name: 'productsName', text: 'Наименование продукции'},
    {name: 'productsType', text: 'Тип изделия'},
    {name: 'innerLength', text: 'лина внутренняя'},
    {name: 'innerWidth', text: 'Ширина внутрення'},
    {name: 'innerHeight', text: 'Высота внутренняя'},
    {name: 'grade', text: 'Марка'},
    {name: 'profile', text: 'Профиль'},
    {name: 'colour', text: 'Цвет'},
    {name: 'print', text: 'Печать'}
];

var testProducts = [
    {
        id: '0001',
        client: 'АВК',
        productsName: '',
        productsType: 'Ящик(4 клапана)',
        innerLength: 385,
        innerWidth: 300,
        innerHeight: 180,
        grade: 'Т-21',
        profile: 'В',
        colour: 'бур/бур',
        print: 'АВК14'
    }, {
        id: '0002',
        client: 'Петрущенко',
        productsName: '',
        productsType: 'Лоток',
        innerLength: 400,
        innerWidth: 300,
        innerHeight: 145,
        grade: 'П-31',
        profile: 'ВЕ',
        colour: 'бур/бур',
        print: 'Яблоки'
    }, {
        id: '0003',
        client: 'Ласунка',
        productsName: '',
        productsType: 'Ящик(4 клапана)',
        innerLength: 410,
        innerWidth: 300,
        innerHeight: 180,
        grade: 'Т-21',
        profile: 'В',
        colour: 'бур/бур',
        print: 'Ласунка'
    }, {
        id: '0004',
        client: 'Ласунка',
        productsName: '',
        productsType: 'Ящик(4 клапана)',
        innerLength: 410,
        innerWidth: 300,
        innerHeight: 180,
        grade: 'Т-21',
        profile: 'В',
        colour: 'бур/бур',
        print: 'Ласунка'
    }, {
        id: '0005',
        client: 'Ласунка',
        productsName: '',
        productsType: 'Ящик(4 клапана)',
        innerLength: 410,
        innerWidth: 300,
        innerHeight: 180,
        grade: 'Т-21',
        profile: 'В',
        colour: 'бур/бур',
        print: 'Ласунка'
    }
];

var ProductsTable = React.createClass({
    render: function () {
        return (
            <table className="table table-striped table-bordered table-list table-hover">
                {this.props.children}
            </table>
        );
    }
});

ProductsTable.Heading = React.createClass({
    render: function () {
        return (
            <th>{this.props.heading.text}</th>
        );
    }
});

ProductsTable.Headings = React.createClass({
    render: function () {
        var headers = this.props.headings.map(function (h, i) {
            return (<ProductsTable.Heading heading={h} key={i}/>);
        });
        return (
            <thead>
            <tr>
                {headers}
            </tr>
            </thead>
        );
    }

});

ProductsTable.Row = React.createClass({
    render: function () {
        return (
            <tr>
                <td>{this.props.row.id}</td>
                <td>{this.props.row.client}</td>
                <td>{this.props.row.productsName}</td>
                <td>{this.props.row.productsType}</td>
                <td>{this.props.row.innerLength}</td>
                <td>{this.props.row.innerWidth}</td>
                <td>{this.props.row.innerHeight}</td>
                <td>{this.props.row.grade}</td>
                <td>{this.props.row.profile}</td>
                <td>{this.props.row.colour}</td>
                <td>{this.props.row.print}</td>
            </tr>
        );
    }
});

ProductsTable.Rows = React.createClass({
    render: function () {
        var rows = this.props.rows.map(function (r, i) {
            return (<ProductsTable.Row row={r} key={i}/>);
        });
        return (
            <tbody>
            {rows}
            </tbody>
        );
    }
});

var App = React.createClass({
    render: function () {
        return (
            <ProductsTable>
                <ProductsTable.Headings headings={productTableColumnNames}/>
                <ProductsTable.Rows rows={testProducts}/>
            </ProductsTable>
        )
    }
});

ReactDOM.render(<App />, document.getElementById("products-table"));
