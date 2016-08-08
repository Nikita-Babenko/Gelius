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
            sortingAsc: this.props.columnName === 'ids',
            sortingDesc: false
        }
    },

    componentDidMount: function () {
        this.__loadFilterParametersFromServer();
    },

    render: function () {
        var filterStatusClass = this.state.filteringEnabled ? 'display' : 'hide';
        var sortingStatusAsc = this.state.sortingAsc ? 'display' : 'hide';
        var sortingStatusDesc = this.state.sortingDesc ? 'display' : 'hide';
        var updateDropdowns = this.props.updateDropdowns;
        var updateSortingStatus = this.props.updateSortingStatus;
        return (
            <div className="dropdown">
                <button type="button" className="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
                    <i className=" fa fa-chevron-down "></i>
                    <sup>
                        <i className={"fa fa-filter " + filterStatusClass}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-up " + sortingStatusAsc}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-down " + sortingStatusDesc}
                           aria-hidden="true"/>
                    </sup>
                </button>
                <div className={"dropdown-menu  header-dropdown " + this.props.position}>
                    <Sorting sendFilterObject={this.props.sendFilterObject}
                             columnName={this.props.columnName}
                             enableSortingStatus={this.__enableSortingStatus}
                             updateSortingStatus={updateSortingStatus}
                    />
                    <Filtering sendFilterObject={this.props.sendFilterObject}
                               updateDropdowns={updateDropdowns}
                               columnName={this.props.columnName}
                               filterData={this.state.filterData}
                               enableFiltering={this.__enableFilteringStatus}
                    />
                </div>
            </div>
        );
    },

    __loadFilterParametersFromServer: function () {
        var url = '/products/filterParameters/' + this.props.columnName;
        $.ajax({

            type: "POST",
            contentType: "application/json",
            url: url,
            data: JSON.stringify(searchFilter),
            dataType: 'json',
            timeout: 100000,
            success: function (productsData) {
                this.setState({filterData: $.extend(productsData.result, searchFilter[this.props.columnName])});
              //  console.log(productsData.result);
              //  console.log(searchFilter[this.props.columnName]);
                console.log("extend " + $.extend(productsData.result, searchFilter[this.props.columnName]));
            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __enableSortingStatus: function (direction) {
        if (direction === 'asc') {
            this.setState({
                sortingAsc: true,
                sortingDesc: false
            });
        } else {
            this.setState({
                sortingAsc: false,
                sortingDesc: true
            });
        }
    },

    __disableSortingStatus: function () {
        this.setState({
            sortingAsc: false,
            sortingDesc: false
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
                <div className="sorting-option" onClick={this.__onSortingDirectionClick.bind(null, "asc")}>
                    <a href="#">
                        <i className="fa fa-sort-amount-asc" aria-hidden="true">
                            <span>&nbsp;по возрастанию</span>
                        </i>
                    </a>
                </div>
                <div className="sorting-option" onClick={this.__onSortingDirectionClick.bind(null, "desc")}>
                    <a href="#">
                        <i className="fa fa-sort-amount-desc" aria-hidden="true">
                            <span>&nbsp;по убыванию</span>
                        </i>
                    </a>
                </div>
            </div>
        );
    },
    __onSortingDirectionClick: function (direction) {
        searchFilter["sortableColumn"] = this.props.columnName;
        searchFilter["sortingDirection"] = direction;
        this.props.sendFilterObject();

        this.props.enableSortingStatus(direction);
        this.props.updateSortingStatus();
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

        var columnName = this.props.columnName;
        var onFilterClick = this.__onFilterSelected;
        var updateParameters = this.__loadFilterParametersFromServer;
        var filterCheckboxes = filterData.map(function (e) {
            return (
                <ProductsTable.Heading.Dropdown.FilterElement columnName={columnName}
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
        var filterParameters = searchFilter[this.props.columnName];
        var value = this.props.element;

        this.setState({isChecked: newState});

        if (newState) {
            filterParameters.push(value);
        } else {
            filterParameters.splice($.inArray(value, filterParameters), 1);
        }
        this.props.filterSelected(this.props.columnName, newState);

    }
});

ProductsTable.Headings = React.createClass({
    render: function () {
        var headersText = this.props.headings;
        var sendFilter = this.props.sendFilterObject;
        var updateDropdowns = this.__updateDropdowns;
        var updateSortingStatus = this.__updateSortingStatus;
        var headers = headersText.map(function (h, i) {
                return (
                    <ProductsTable.Heading heading={h} key={i}>
                        <ProductsTable.Heading.Dropdown ref={h.name}
                                                        sendFilterObject={sendFilter}
                                                        columnName={h.name}
                                                        updateDropdowns={updateDropdowns}
                                                        updateSortingStatus={updateSortingStatus}
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

    __updateSortingStatus: function () {
        var disable = this.__disableSortingStatusByRef;
        productTableColumnNames.forEach(function (e) {
            if (searchFilter["sortableColumn"] !== e.name)
                disable(e.name);
        });
    },
    __disableSortingStatusByRef: function (name) {
        this.refs[name].__disableSortingStatus();
    },
    __updateDropdowns: function (dontUpdateColumn) {
        var update = this.__updateDropdownsByRef;
        productTableColumnNames.forEach(function (e) {
            if ((e.name == dontUpdateColumn) && (searchFilter[dontUpdateColumn].length == 0))
                update(dontUpdateColumn);
            if (e.name !== dontUpdateColumn)
                update(e.name);
        });
    },
    __updateDropdownsByRef: function (name) {
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