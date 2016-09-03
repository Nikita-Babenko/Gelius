import React from 'react';
import UrlConstants from "../../constants/Url";
import NewProductAction from '../../actions/NewProductActions';


class UploadFiles extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            //Internal elements:
            UPLOAD_FILE_BUTTON_SELECTOR: "#addFile",
            filesCount: 1 //tmp for debug!  =0

        };
        this.__addFile = this.__addFile.bind(this);
    }

    componentDidMount() {

    }

    __addFile(event) {
        this.state.filesCount++;
        this.forceUpdate(); //only for debug!

    }

    render() {
        var files = [];
        for (var i = 0; i <this.state.filesCount; i++) {
            files.push(<FileLink />);
        }
        return (
            <td colSpan="3" className="attachments">
                <div className="links">
                    {files}
                </div>
                <div className="attachment_buttons icon_buttons_group">
                    <a href="#" className="fa fa-paperclip fa-2x" title="Прикрепить ссылку" id="addFile" onClick={this.__addFile} aria-hidden="true"></a>
                    <a href="#" className="fa fa-trash-o fa-2x" title="Удалить все ссылки" aria-hidden="true"></a>
                </div>
            </td>
        );
    }
}

export default UploadFiles;


class FileLink extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            fileName: this.props.fileName

        };
    }

    componentDidMount() {
        //SELF.click();
    }

    render() {
        return (
            <input type="file" />
        );
    }

}

FileLink.defaultProps = {
    fileName: "Файл не выбран"
};
