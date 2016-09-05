import React from 'react';
import UploadFilesStore from '../../stores/UploadFilesStore';
import NewProductStore from '../../stores/NewProductStore';
import UrlConstants from "../../constants/Url";
import NewProductAction from '../../actions/NewProductActions';
import EventConstants from '../../constants/Events';
import L from '../../utils/Logging';


class FileLinksContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            filesCount: 0
        };
        this.__addFile = this.__addFile.bind(this);
        this.__onFileLinksUpdated = this.__onFileLinksUpdated.bind(this);
        this.__onEntitySaved = this.__onEntitySaved.bind(this);
    }

    componentWillMount() {
        UploadFilesStore.addListener(EventConstants.FILE_LINKS_CHANGE_EVENT, this.__onFileLinksUpdated);
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__onEntitySaved);
    }

    componentWillUnmount() {
        UploadFilesStore.removeListener(EventConstants.FILE_LINKS_CHANGE_EVENT, this.__onFileLinksUpdated);
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__onEntitySaved);
    }

    __onFileLinksUpdated() {
        this.setState({filesCount: UploadFilesStore.filesCount});
        L.log("__onFileLinksUpdated");
    }

    __onEntitySaved() {
        if (NewProductStore.isSaveFiles() && this.state.filesCount > 0) {
            L.log("__onEntitySaved: save files");
            NewProductAction.saveFileLinks();
        }
    }

    __addFile() {
        L.log("__addFile");
        NewProductAction.addFileLink();

    }

    render() {
        var fileFields = [];
        for (var i = 0; i < this.state.filesCount; i++) {
            fileFields.push(<FileLink fakeId={"fileLink_" + i}/>);
        }
        return (
            <td colSpan="3" className="attachments">
                <div className="links">
                    {fileFields}
                </div>
                <div className="attachment_buttons icon_buttons_group" id="buttonsLink">
                    <a href="#" className="fa fa-paperclip fa-lg" title="Прикрепить ссылку" onClick={this.__addFile}
                       aria-hidden="true" />
                    <a href="#" className="fa fa-trash-o fa-lg" title="Удалить все ссылки" aria-hidden="true" />
                </div>
            </td>
        );
    }
}

export default FileLinksContainer;


class FileLink extends React.Component {
    constructor(props) {
        super(props);
        /*this.state = {
         fileName: this.props.fileName
         };*/
    }

    componentDidMount() {
        //SELF.click();
    }

    render() {
        return (
            <input id={this.props.fakeId} type="file"/>
        );
    }

}

/*FileLink.defaultProps = {
 fileName: "Файл не выбран"
 };*/
