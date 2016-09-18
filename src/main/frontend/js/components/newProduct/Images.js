import React from 'react';
import ImagesStore from '../../stores/ImagesStore';
import EventConstants from '../../constants/Events';
import NewProductActions from '../../actions/NewProductActions';

class Images extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            allImages: []
        };

        this._getImages = this._getImages.bind(this);
    }

    componentDidMount() {
        ImagesStore.addListener(EventConstants.IMAGES_CHANGE_EVENT, this._getImages);
    }

    componentWillUnmount() {
        ImagesStore.removeListener(EventConstants.IMAGES_CHANGE_EVENT, this._getImages);
    }

    render() {
        var images = this.state.allImages.map(function (image, index) {
            return (<ImagePreview imageUrl={image.url} id={index}/>);
        });
        return (
            <div>
                {images}
            </div>
        );
    }

    _getImages() {
        this.setState({
            allImages: ImagesStore.getImages()
        });
    }
}

export default Images;

class ImagePreview extends React.Component {
    constructor(props) {
        super(props);

        this.border = {
            "Default": "",
            "Selected": "8px solid #8eba68"
        };

        this.state = {
            selected: false,
            selectedImageColor: {
                border: this.border.Default
            }
        };

        this._onImageClick = this._onImageClick.bind(this);
        this._updateSelectedState = this._updateSelectedState.bind(this);
    }

    componentDidMount() {
        ImagesStore.addListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateSelectedState);
    }

    componentWillUnmount() {
        ImagesStore.removeListener(EventConstants.IMAGES_CHANGE_EVENT, this._updateSelectedState);
    }

    render() {
        return (
            <div className="product-image" onClick={this._onImageClick}>
                <img src={this.props.imageUrl} style={this.state.selectedImageColor}/>
            </div>
        );
    }

    _onImageClick() {
        NewProductActions.selectImage(this.props.id);
    }

    _updateSelectedState() {
        var selectedImageId = this.props.id;
        var imageId = ImagesStore.getSelectedImageId();

        if (imageId.previous === imageId.current) {
            this.setState({
                selectedImageColor: {
                    border: this.border.Default
                }
            });
            return
        }

        if (selectedImageId === imageId.previous)
            this.setState({
                selectedImageColor: {
                    border: this.border.Default
                }
            });

        if (selectedImageId === imageId.current)
            this.setState({
                selectedImageColor: {
                    border: this.border.Selected
                }
            });
    }
}