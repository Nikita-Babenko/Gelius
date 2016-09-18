import React from 'react';
import ImagePicker from './ImagePicker';
import Images from './Images';

class ImageContainer extends React.Component {
    render() {
        return (
            <div className="text-center">
                <ImagePicker/>
                <Images/>
            </div>
        );
    }
}

export default ImageContainer;