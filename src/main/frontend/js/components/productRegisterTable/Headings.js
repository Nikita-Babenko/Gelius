import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';
import ObjectsConstants from '../../constants/Objects';
import Heading from '../productRegisterTable/Heading';
import Dropdown from '../productRegisterTable/Dropdown';

class Headings extends React.Component {

    componentWillMount() {
        FilteringSortingActions.loadAllFilterParametersFromServer();
    }

    render() {
        var headersText = ObjectsConstants.productTableColumnNames;
        var headers = headersText.map(function (h, i) {
                return (
                    <Heading heading={h} key={i}>
                        <Dropdown columnName={h.name}
                                  position={(i < headersText.length/2) ? "pull-left" : "pull-right"}/>
                    </Heading>
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
}

export default Headings;