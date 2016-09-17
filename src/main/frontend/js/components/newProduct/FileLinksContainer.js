import React from "react";
import ReactDOM from "react-dom";
import NewProductStore from "../../stores/NewProductStore";
import UploadFilesStore from "../../stores/UploadFilesStore";
import EventConstants from "../../constants/Events";
import NewProductAction from "../../actions/NewProductActions";


class FileLinksContainer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            counter: 0,
            deleteItem: 0,
            fileLinks: []
        };
        this.__addFileLink = this.__addFileLink.bind(this);
        this.__deleteAllFileLinks = this.__deleteAllFileLinks.bind(this);
        this.__showModalWindow = this.__showModalWindow.bind(this);
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
            var links = NewProductStore.getProductProperty("filePaths");
            this.setState({
                fileLinks: links ? links : []
            });
        }
    }

    __addFileLink() {
        var counter = this.state.counter + 1;
        if (this.state.items.length < 5) {
            this.setState({
                items: this.state.items.concat({index: counter, el: <FileLink />}),
                counter: counter
            });
        }
    }

    __showModalWindow(item) {
        this.setState({
            deleteItem: item
        });
        $(ReactDOM.findDOMNode(this.refs.modalWindow)).modal();
    }

    render() {
        var fileLinks = this.state.fileLinks.map(function (link) {
            return (
                <div>
                    <a href={link} target="_blank">
                        <i className="fa fa-file-image-o" aria-hidden="true" />
                        {link.indexOf("/") >= 0 ? link.split("/").pop() : link.split("\\").pop()}
                    </a>
                </div>
            );
        });

        var list = this.state.items.map(function (item) {
            return (
                <div key={item.index} className="fileLink">
                    <a href="#"
                       className="fa fa-trash-o fa-lg"
                       onClick={this.__showModalWindow.bind(this, item.index)}
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
                <div className="links">
                    {list}
                </div>
                <div className="attachment_buttons icon_buttons_group" id="buttonsLink">
                    <a href="#" className="fa fa-paperclip fa-lg" title="Прикрепить ссылку" onClick={this.__addFileLink}
                       aria-hidden="true"/>
                    <a href="#" className="fa fa-trash-o fa-lg" title="Удалить все ссылки" aria-hidden="true"
                       onClick={this.__deleteAllFileLinks}/>
                </div>
                <ModalWindow ref="modalWindow" onDelete={this.__deleteFileLink.bind(this, this.state.deleteItem)}/>
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
        return <input type="file" className="fileLinks" onChange={this.__setValue} value={this.state.value}/>
    }

}

class ModalWindow extends React.Component {

    render() {
        return (
            <div className="modal fade">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true"/></button>
                            <h4 className="modal-title">Удаление файла</h4>
                        </div>
                        <div className="modal-body">
                            <p>Вы действительно хотите удалить файл?</p>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-primary" onClick={this.props.onDelete}
                                    data-dismiss="modal">Да
                            </button>
                            <button type="button" className="btn btn-default" data-dismiss="modal">Нет</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}
