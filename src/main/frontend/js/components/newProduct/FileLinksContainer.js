import React from "react";
import ReactDOM from "react-dom";
import NewProductStore from "../../stores/NewProductStore";
import UploadFilesStore from "../../stores/UploadFilesStore";
import EventConstants from "../../constants/Events";
import NewProductAction from "../../actions/NewProductActions";
import DeleteModal from '../general/DeleteModal';

class FileLinksContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            counter: 0,
            deleteItem: 0,
            deleteLink: "",
            fileLinks: [],
            itemsToSave: 5
        };
        this.__addFileLink = this.__addFileLink.bind(this);
        this.__deleteAllFileLinks = this.__deleteAllFileLinks.bind(this);
        this.__showDeleteFileModalWindow = this.__showDeleteFileModalWindow.bind(this);
        this.__showDeleteFileLinkModalWindow = this.__showDeleteFileLinkModalWindow.bind(this);
        this.__showDeleteAllFilesModalWindow = this.__showDeleteAllFilesModalWindow.bind(this);
        this.__deleteAllFileLinksWhenProductSaved = this.__deleteAllFileLinksWhenProductSaved.bind(this);
        this.__ifProductSaved = this.__ifProductSaved.bind(this);
        this.__loadDefaultFileLinks = this.__loadDefaultFileLinks.bind(this);
    }

    componentWillMount() {
        UploadFilesStore.addListener(EventConstants.FILE_LINKS_CHANGE_EVENT, this.__deleteAllFileLinksWhenProductSaved);
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__ifProductSaved);
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultFileLinks);
    }

    componentWillUnmount() {
        UploadFilesStore.removeListener(EventConstants.FILE_LINKS_CHANGE_EVENT, this.__deleteAllFileLinksWhenProductSaved);
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__ifProductSaved);
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultFileLinks);
    }

    __ifProductSaved() {
        if (NewProductStore.isSaveFiles()) {
            NewProductAction.saveFileLinks();
        }
    }

    __deleteFileLink(index) {
        this.setState({
            items: this.state.items.filter(function (e) {
                return e.index !== index;
            })
        });
    }

    __deleteSavedFileLink(item) {
        var links = this.state.fileLinks;
        NewProductAction.removeFileLink(item);
        links.splice($.inArray(item, links), 1);
        this.setState({
            fileLinks: links
        });
    }

    __deleteAllFileLinksWhenProductSaved() {
        if (UploadFilesStore.isDeleteSelectedFiles()) {
            this.setState({
                items: [],
                counter: 0
            });
        }
    }

    __deleteAllFileLinks() {
        this.setState({
            items: [],
            counter: 0
        });
    }

    __loadDefaultFileLinks() {
        if (NewProductStore.isEnableDefaultValues()) {
            UploadFilesStore.fileLinksToDelete = [];
            var links = NewProductStore.operation === EventConstants.COPY_PRODUCT ? [] : NewProductStore.getProductProperty("filePaths")
            this.setState({
                fileLinks: links ? links : []
            });
        }
    }

    __addFileLink() {
        var counter = this.state.counter + 1;
        if (this.state.items.length < this.state.itemsToSave) {
            this.setState({
                items: this.state.items.concat({index: counter, el: <FileLink />}),
                counter: counter
            });
        }
    }

    __showDeleteFileModalWindow(item) {
        this.setState({
            deleteItem: item
        });
        $(ReactDOM.findDOMNode(this.refs.deleteFileModal)).modal();
    }

    __showDeleteFileLinkModalWindow(item) {
        this.setState({
            deleteLink: item
        });
        $(ReactDOM.findDOMNode(this.refs.deleteFileLinkModal)).modal();
    }

    __showDeleteAllFilesModalWindow() {
        if (this.state.items.length > 0)
        $(ReactDOM.findDOMNode(this.refs.deleteAllFilesModal)).modal();
    }

    render() {
        var fileLinks = this.state.fileLinks.map(function (link) {
            return (
                <div className="fileLink">
                    <a className="fa fa-trash-o fa-lg"
                       onClick={this.__showDeleteFileLinkModalWindow.bind(this, link)}
                       tabIndex="-1"
                       aria-hidden="true"/>
                    <a href={link} target="_blank" tabIndex="-1">
                        {link.indexOf("/") >= 0 ? link.split("/").pop() : link.split("\\").pop()}
                    </a>
                </div>
            );
        }, this);

        var list = this.state.items.map(function (item) {
            return (
                <div key={item.index} className="fileLink">
                    <a className="fa fa-trash-o fa-lg"
                       onClick={this.__showDeleteFileModalWindow.bind(this, item.index)}
                       tabIndex="-1"
                       aria-hidden="true"/>
                    {item.el}
                </div>
            );

        }, this);

        return (
            <td colSpan="3" className="attachments">
                <div className="links">
                    {fileLinks}
                </div>
                <DeleteModal ref="deleteFileLinkModal"
                             confirmMessage="Вы действительно хотите удалить ссылку на этот файл?"
                             deleteFunction={this.__deleteSavedFileLink.bind(this, this.state.deleteLink)}
                />
                <div className="links">
                    {list}
                </div>
                <DeleteModal ref="deleteFileModal"
                             confirmMessage="Вы действительно хотите удалить этот файл?"
                             deleteFunction={this.__deleteFileLink.bind(this, this.state.deleteItem)}
                />
                <div className="attachment_buttons icon_buttons_group" id="buttonsLink">
                    <a href="#"
                       className="fa fa-paperclip fa-lg"
                       title="Прикрепить ссылку"
                       onClick={this.__addFileLink}
                       aria-hidden="true"
                       tabIndex="-1"
                    />
                    <a href="#"
                       className="fa fa-trash-o fa-lg"
                       title="Удалить все ссылки"
                       aria-hidden="true"
                       tabIndex="-1"
                       onClick={this.__showDeleteAllFilesModalWindow}
                    />
                </div>
                <DeleteModal ref="deleteAllFilesModal"
                             confirmMessage="Вы действительно хотите удалить все выбранные файлы?"
                             deleteFunction={this.__deleteAllFileLinks}
                />
            </td>
        );
    }
}

export default FileLinksContainer;


class FileLink extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: ""
        };

        this.__setValue = this.__setValue.bind(this);
    }

    __setValue(e) {
        this.setState({
            value: e.target.value
        });
    }

    render() {
        return <input type="file"
                      className="fileLinks"
                      accept="image/*, application/pdf"
                      tabIndex="-1"
                      onChange={this.__setValue}
                      value={this.state.value}
        />
    }

}