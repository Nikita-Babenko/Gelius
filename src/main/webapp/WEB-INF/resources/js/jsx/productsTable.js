var productTableColumnNames = [
    {name: 'ids', text: '№'},
    {name: 'clients', text: 'Клиент'},
    {name: 'names', text: 'Наименование продукции'},
    {name: 'types', text: 'Тип изделия'},
    {name: 'lengths', text: 'Длина внутренняя'},
    {name: 'widths', text: 'Ширина внутрення'},
    {name: 'heights', text: 'Высота внутренняя'},
    {name: 'grades', text: 'Марка'},
    {name: 'profiles', text: 'Профиль'},
    {name: 'colours', text: 'Цвет'},
    {name: 'prints', text: 'Печать'}
];

var searchFilter = {};
searchFilter["ids"] = [];
searchFilter["clients"] = [];
searchFilter["names"] = [];
searchFilter["types"] = [];
searchFilter["lengths"] = [];
searchFilter["widths"] = [];
searchFilter["heights"] = [];
searchFilter["grades"] = [];
searchFilter["profiles"] = [];
searchFilter["colours"] = [];
searchFilter["prints"] = [];
searchFilter["sortableColumn"] = "ids";
searchFilter["sortingDirection"] = "asc";

var ProductsTable = React.createClass({
    render: function () {
        return (
            <table className="table table-responsive table-bordered products-table">
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
            filterData: [],
            filteringEnabled: false,
            sortingAsc: false,
            sortingDesc: false
        }
    },

    componentDidMount: function () {
        this.__loadFilterParametersFromServer();
    },

    render: function () {
        var filterStatusClass = this.state.filteringEnabled ? 'display' : 'hide';
        var updateDropdowns = this.props.updateDropdowns;
        return (
            <div className="dropdown">
                <button type="button" className="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
                    <i className=" fa fa-chevron-down "></i>
                    <sup>
                        <i className={"fa fa-filter display " + filterStatusClass}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-down hide"}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-up hide"}
                           aria-hidden="true"/>
                    </sup>
                </button>
                <div className={"dropdown-menu  header-dropdown " + this.props.position}>
                    <Sorting />
                    <Filtering sendFilterObject={this.props.sendFilterObject}
                               updateDropdowns={updateDropdowns}
                               filterName={this.props.filterName}
                               filterData={this.state.filterData}
                               enableFiltering={this.__enableFilteringStatus}/>
                </div>
            </div>
        );
    },

    __loadFilterParametersFromServer: function () {
        var url = '/products/filterParameters/' + this.props.filterName;
        $.ajax({

            type: "POST",
            contentType: "application/json",
            url: url,
            data: JSON.stringify(searchFilter),
            dataType: 'json',
            timeout: 100000,
            success: function (productsData) {
                this.setState({filterData: $.extend(productsData.result, searchFilter[this.props.filterName])});
            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __enableFilteringStatus: function (isEnabled) {
        this.setState({filteringEnabled: isEnabled});
    }
});

var Sorting = React.createClass({
    render: function () {
        return (
            <div>
                <div className="dropdown-header">Сортировка</div>
                <div className="sorting-option">
                    <a href="#">
                        <i className="fa fa-sort-amount-asc" aria-hidden="true">
                            <span>&nbsp; по возрастанию</span>
                        </i>
                    </a>
                </div>
                <div className="sorting-option">
                    <a href="#">
                        <i className="fa fa-sort-amount-desc" aria-hidden="true">
                            <span>&nbsp; по убыванию</span>
                        </i>
                    </a>
                </div>
            </div>
        );
    }
});

var Filtering = React.createClass({
    getInitialState: function () {
        return {
            filtersChecked: 0,
            searchString: ''
        }
    },

    render: function () {
        var filterData = this.props.filterData;
        var searchString = this.state.searchString.trim().toLowerCase();
        if (searchString.length > 0) {
            filterData = filterData.filter(function (d) {
                if (typeof d === 'number')
                    d = d + '';
                return d.toLowerCase().match(searchString);
            });
        }

        var filterName = this.props.filterName;
        var onFilterClick = this.__onFilterSelected;
        var updateParameters = this.__loadFilterParametersFromServer;
        var filterCheckboxes = filterData.map(function (e) {
            return (
                <ProductsTable.Heading.Dropdown.FilterElement filterName={filterName}
                                                              key={e}
                                                              updateParameters={updateParameters}
                                                              element={e}
                                                              filterSelected={onFilterClick}/>
            );
        });
        return (
            <div>
                <div className="dropdown-header">Фильтры</div>
                <div className="input-group filter-search">
                    <div className="input-group-addon">
                        <i className="fa fa-search"></i>
                    </div>
                    <input className="form-control" id="search" name="search" type="text"
                           value={this.state.searchString} onChange={this.__handleSearchChange}/>
                </div>
                <div>
                    <ul className="scrollable-menu" role="menu">
                        {filterCheckboxes}
                    </ul>
                </div>
            </div>
        );
    },

    __handleSearchChange: function (e) {
        this.setState({searchString: e.target.value});
    },

    __onFilterSelected: function (filteredColumn, newState) {
        var newTotal = this.state.filtersChecked + (newState ? 1 : -1);
        this.setState({filtersChecked: newTotal});
        this.props.enableFiltering(newTotal > 0);
        this.props.sendFilterObject();
        this.props.updateDropdowns(filteredColumn);
    }
});

ProductsTable.Heading.Dropdown.FilterElement = React.createClass({
    getInitialState: function () {
        return {isChecked: false}
    },

    render: function () {
        return (
            <li className="checkbox">
                <label>
                    <input type="checkbox" checked={this.state.isChecked} onChange={this.__handleChangeSelection}
                           className="filter-checkbox" value={this.props.element}/>{this.props.element}
                </label>
            </li>
        );
    },

    __handleChangeSelection: function () {
        var newState = !this.state.isChecked;
        var filterParameters = searchFilter[this.props.filterName];
        var value = this.props.element;

        this.setState({isChecked: newState});

        if (newState) {
            filterParameters.push(value);
        } else {
            filterParameters.splice($.inArray(value, filterParameters), 1);
        }
        this.props.filterSelected(this.props.filterName, newState);

    }
});

ProductsTable.Headings = React.createClass({
    render: function () {
        var headersText = this.props.headings;
        var sendFilter = this.props.sendFilterObject;
        var updateDropdowns = this.__updateDropdowns;
        var headers = headersText.map(function (h, i) {
                return (
                    <ProductsTable.Heading heading={h} key={i}>
                        <ProductsTable.Heading.Dropdown ref={h.name}
                                                        sendFilterObject={sendFilter}
                                                        filterName={h.name}
                                                        updateDropdowns={updateDropdowns}
                                                        position={(i < headersText.length/2) ? "pull-left" : "pull-right"}/>
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
    },

    __updateDropdowns: function (dontUpdateColumn) {
        var update = this.__updateByRef;
        productTableColumnNames.forEach(function (e) {
            if ((e.name == dontUpdateColumn) && (searchFilter[dontUpdateColumn].length == 0))
                update(dontUpdateColumn);
            if (e.name !== dontUpdateColumn)
                update(e.name);
        });

    },

    __updateByRef(name) {
        this.refs[name].__loadFilterParametersFromServer();
    }
});

ProductsTable.Row = React.createClass({
    render: function () {
        return (
            <tr>
                <td>{this.props.row.id}</td>
                <td>{this.props.row.clients.companyName}</td>
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
        var allProducts = this.props.rows;
        var rows = allProducts.map(function (r, i) {
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
    getInitialState: function () {
        return {rows: []}
    },
    componentDidMount: function () {
        this.__sendFilterObject();
    },

    render: function () {
        return (
            <ProductsTable>
                <ProductsTable.Headings sendFilterObject={this.__sendFilterObject} headings={productTableColumnNames}/>
                <ProductsTable.Rows rows={this.state.rows}/>
            </ProductsTable>
        )
    },

    __sendFilterObject: function () {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/products/filtrate",
            data: JSON.stringify(searchFilter),
            dataType: 'json',
            timeout: 100000,
            success: function (productsData) {
                this.setState({rows: productsData.result});
            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    }
});

ReactDOM.render(<App />, document.getElementById("products-table"));