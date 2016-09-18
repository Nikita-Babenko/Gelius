import React from 'react';
import NewProductActions from '../../actions/NewProductActions';

class ImagePicker extends React.Component {
    constructor(props) {
        super(props);

        this._handleImageChange = this._handleImageChange.bind(this);
    }

    render() {
        return (
            <div>
                <input id="imageInput"
                       type="file"
                       style={{display: 'none'}}
                       accept="image/*"
                       onChange={this._handleImageChange}/>
            </div>
        );
    }

    _handleImageChange(e) {
        e.preventDefault();

        let reader = new FileReader();
        let file = e.target.files[0];

        reader.onloadend = () => {
            var image = {
                file: file,
                url: reader.result
            };
            NewProductActions.addImage(image);
        };

        reader.readAsDataURL(file)
    }
}

export default ImagePicker;