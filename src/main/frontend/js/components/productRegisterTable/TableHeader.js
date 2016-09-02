import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';
import ObjectsConstants from '../../constants/Objects';
import Heading from '../productRegisterTable/Heading';

class TableHeader extends React.Component {

    componentWillMount() {
        FilteringSortingActions.loadAllFilterParametersFromServer();
    }

    render() {
        var headersText = ObjectsConstants.productTableColumnNames;
        return (
            <thead>
            <tr className="table-headings">
                <th rowSpan="2">
                    <Heading heading={headersText[0]} position={"pull-left"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[1]} position={"pull-left"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[2]} position={"pull-left"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[3]} position={"pull-left"}/>
                </th>
                <th colSpan="3">
                    Внутреняя
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[7]} position={"pull-right"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[8]} position={"pull-right"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[9]} position={"pull-right"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[10]} position={"pull-right"}/>
                </th>
            </tr>
            <tr className="table-headings">
                <th rowSpan="2">
                    <Heading heading={headersText[4]} position={"pull-left"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[5]} position={"pull-left"}/>
                </th>
                <th rowSpan="2">
                    <Heading heading={headersText[6]} position={"pull-left"}/>
                </th>
            </tr>
            </thead>
        );
    }
}

export default TableHeader;