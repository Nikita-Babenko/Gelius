import React from "react";
import ReactDOM from "react-dom";
import Header from "../newProduct/Header";
import Body from "../newProduct/Body";
import NewProductAction from "../../actions/NewProductActions";
import NewProductStore from "../../stores/NewProductStore";
import EventConstants from "../../constants/Events";
import Alert from "../newProduct/Alert";

class NewProduct extends React.Component {
    constructor(props) {
        super(props);
        this.__enableAlert = this.__enableAlert.bind(this);
    }

    componentDidMount(){
        NewProductAction.__disablePalletDictionaryByDefault();
        NewProductAction.__disablePalletDictionaryDependsFromChangePacking();
        NewProductAction.__defaultConnectionValveDictionaryDependsFromProductType();
        NewProductAction.__sumBigovki();
        NewProductAction.__checkInputNumber();
    }
    
    componentWillMount() {
        NewProductAction.loadAllDictionaries();
        NewProductAction.loadNewProductNumber();
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__enableAlert);

    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__enableAlert);
    }

    render() {
        return (
            <div className="container-fluid target">
                <Header />
                <div id="alert-information"></div>
                <Body />
            </div>
        );
    }

    __enableAlert() {
        if (NewProductStore.getAlertStatus()) {
            var alertInfo = NewProductStore.getAlertInformation();
            ReactDOM.render(<Alert alertType={alertInfo.alertType}
                                   message={alertInfo.message}/>,
                document.getElementById('alert-information'));
        }
    }

}

export default NewProduct;
