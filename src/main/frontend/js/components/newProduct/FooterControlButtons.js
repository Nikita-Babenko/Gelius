import React from 'react';
import ReactDOM from "react-dom";
import NewProductActions from '../../actions/NewProductActions';
import ImagesStore from '../../stores/ImagesStore';
import EventConstants from '../../constants/Events';
import Objects from '../../constants/Objects';
import DeleteModal from '../general/DeleteModal';

class FooterControlButtons extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            selectedImageId: null,
            numberOfImages: 0
        };

        this._updateImagesData = this._updateImagesData.bind(this);
        this._onDeleteImageButtonClick = this._onDeleteImageButtonClick.bind(this);
        this._deleteFunction = this._deleteFunction.bind(this);
    }

    componentDidMount() {
        ImagesStore.addListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateImagesData);
    }

    componentWillUnmount() {
        ImagesStore.removeListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateImagesData);
    }

    render() {
        var disableDeleteImageButton = this.state.selectedImageId !== null ? "" : " disabled";
        var disableAddImageButton = this.state.numberOfImages < Objects.UPLOADED_FILES_COUNT_LIMIT ? "" : " disabled";
        return (
            <div className="buttonContainer">
                <div className="buttons_bottom icon_buttons_group">
                    <a className="control-btn btn fa fa-pencil fa-2x disabled" tabIndex="-1"/>
                    <a className={"control-btn btn fa fa-plus fa-2x" + disableAddImageButton}
                       tabIndex="-1"
                       onClick={this._onAddImageButtonClick}/>
                    <a className={"control-btn btn fa fa-trash-o fa-2x" + disableDeleteImageButton}
                       tabIndex="-1"
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

    _updateImagesData() {
        this.setState({
            selectedImageId: ImagesStore.getSelectedImageId().current,
            numberOfImages: ImagesStore.getCountOfImages()
        });
    }

}

export default FooterControlButtons;