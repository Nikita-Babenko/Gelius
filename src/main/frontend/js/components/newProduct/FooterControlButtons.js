import React from 'react';
import ReactDOM from "react-dom";
import NewProductActions from '../../actions/NewProductActions';
import ImagesStore from '../../stores/ImagesStore';
import EventConstants from '../../constants/Events';
import DeleteModal from '../general/DeleteModal';

class FooterControlButtons extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            selectedImageId: null
        };

        this._updateSelectedImageId = this._updateSelectedImageId.bind(this);
        this._onDeleteImageButtonClick = this._onDeleteImageButtonClick.bind(this);
        this._deleteFunction = this._deleteFunction.bind(this);
    }

    componentDidMount() {
        ImagesStore.addListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateSelectedImageId);
    }

    componentWillUnmount() {
        ImagesStore.removeListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateSelectedImageId);
    }

    render() {
        var disableDeleteImageButton = this.state.selectedImageId !== null ? "" : " disabled";
        return (
            <div className="buttonContainer">
                <div className="buttons_bottom icon_buttons_group">
                    <a className="control-btn btn fa fa-pencil fa-2x disabled"/>
                    <a className="control-btn btn fa fa-plus fa-2x"
                       onClick={this._onAddImageButtonClick}/>
                    <a className={"control-btn btn fa fa-trash-o fa-2x" + disableDeleteImageButton}
                       onClick={this._onDeleteImageButtonClick}/>
                    <DeleteModal ref="deleteImageModal"
                                 confirmMessage="Вы действительно хотите удалить это изображение?"
                                 deleteFunction={this._deleteFunction}
                    />

                </div>
            </div>
        );
    }

    _onAddImageButtonClick() {
        $('#imageInput').click();
    }

    _onDeleteImageButtonClick() {
        $(ReactDOM.findDOMNode(this.refs.deleteImageModal)).modal();
    }

    _deleteFunction() {
        NewProductActions.removeImage(this.state.selectedImageId);
    }

    _updateSelectedImageId() {
        this.setState({
            selectedImageId: ImagesStore.getSelectedImageId().current
        });
    }

}

export default FooterControlButtons;