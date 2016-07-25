var productTableColumnNames = [
    {name: 'id', text: '№'},
    {name: 'client', text: 'Клиент'},
    {name: 'productsName', text: 'Наименование продукции'},
    {name: 'productsType', text: 'Тип изделия'},
    {name: 'innerLength', text: 'Длина внутренняя'},
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
var testFilterDataGrade = [
    {id: 1, name: 'Т-21'},
    {id: 2, name: 'Т-21КРАШ'},
    {id: 3, name: 'Т-24Бел'},
    {id: 4, name: 'Т-21Бел'},
    {id: 5, name: 'Т-21Целл'},
    {id: 6, name: 'Т-22ЦЕЛ+ЦЕЛ'},
    {id: 7, name: 'Т-22Бел'},
    {id: 8, name: 'Т-22ЦЕЛ+ЦЕЛ'},
    {id: 9, name: 'Т-22 КРАШ'},
    {id: 10, name: 'Т-22Целл'},
    {id: 11, name: 'Т-23'},
    {id: 12, name: 'Т-23Бел'}
];


var ProductsTable = React.createClass({
    render: function () {
        return (
            <table className="table table-striped table-responsive table-bordered table-hover products-table">
                {this.props.children}
            </table>
        );
    }
});

ProductsTable.Heading = React.createClass({
    render: function () {
        return (
            <th className="text-center">
                <span>
                    {this.props.heading.text}
                </span>
                {this.props.children}
            </th>
        );
    }
});


ProductsTable.Heading.Dropdown = React.createClass({
    getInitialState: function () {
        return {
            filterData: testFilterDataGrade,
            searchString: ''
        };
    },

    render: function () {
        var filterData = this.state.filterData;
        var searchString = this.state.searchString.trim().toLowerCase();

        if (searchString.length > 0) {
            filterData = filterData.filter(function (d) {
                return d.name.toLowerCase().match(searchString);
            });
        }

        var filterCheckboxes = filterData.map(function (e) {
            return (
                <ProductsTable.Heading.Dropdown.FilterElement element={e}/>
            );
        });

        return (
            <div className="dropdown">
                <button type="button" className="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
                    <i className=" fa fa-chevron-down "></i>
                </button>
                <ul className={"dropdown-menu  header-dropdown " + this.props.position}>
                    <li className="dropdown-header">Сортировка</li>
                    <li>
                        <a href="#">
                            <i className="fa fa-sort-amount-asc" aria-hidden="true">
                                <span className="dropdown-text"> по возрастанию</span>
                            </i>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i className="fa fa-sort-amount-desc" aria-hidden="true">
                                <span className="dropdown-text"> по убыванию</span>
                            </i>
                        </a>
                    </li>

                    <li className="dropdown-header">Фильтры</li>
                    <li className="input-group filter-search">
                        <div className="input-group-addon">
                            <i className="fa fa-search"></i>
                        </div>
                        <input className="form-control" id="search" name="search" type="text"
                               value={this.state.searchString} onChange={this.__handleSearchChange}/>
                    </li>
                    <li>
                        <ul className="scrollable-menu" role="menu">
                            {filterCheckboxes}
                        </ul>
                    </li>
                </ul>
            </div>

        );
    },

    __handleSearchChange: function (e) {
        this.setState({searchString: e.target.value});
    }
});

ProductsTable.Heading.Dropdown.FilterElement = React.createClass({
    getInitialState: function () {
        return {chacked: false};
    },

    render: function () {
        return (
            <li className="checkbox">
                <label><input type="checkbox" checked={this.state.chacked} onChange={this.__changeSelection}
                              name="checkbox" value={this.props.element.name}/>{this.props.element.name}</label>
            </li>
        );
    },

    __changeSelection: function () {
        this.setState({
            chacked: !this.state.checked
        });
    }
});

ProductsTable.Headings = React.createClass({
    render: function () {
        var headersText = this.props.headings;
        var headers = headersText.map(function (h, i) {
                return (
                    <ProductsTable.Heading heading={h} key={i}>
                        <ProductsTable.Heading.Dropdown position={(i < headersText.length/2) ? "pull-left" : "pull-right"}/>
                    </ProductsTable.Heading>
                );
            }
        );
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