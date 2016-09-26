var EventConstants = {

    //Product register constants
    LOAD_FILTERED_SORTED_PRODUCTS: "load_filtered_sorted_products",
    LOAD_ALL_FILTER_PARAMETERS: "load_filter_parameters",
    LOAD_FILTER_PARAMETERS_FOR_COLUMN: "load_filter_parameters",

    ADD_FILTER_ELEMENT: "add_filter_element",
    DELETE_FILTER_ELEMENT: "delete_filter_element",

    APPLY_SORTING: "apply_sorting",
    RESET_ALL_FILTERS: "reset_all_filters",
    RESET_FILTERS_FOR_COLUMN: "reset_filters_for_column",
    SELECT_FILTERS_FOR_COLUMN: "select_filters_for_column",

    PRODUCTS_TABLE_CHANGE_EVENT: "products_table_change_event",
    FILTERING_SORTING_CHANGE_EVENT: "filtering_sorting_change_event",

    SELECT_PRODUCT: "select_product",
    SELECT_IMAGE: "select_image",

    //New product constants
    LOAD_ALL_DICTIONARIES: "load_all_dictionaries",
    LOAD_PRODUCT_NUMBER: "load_product_number",
    SAVE_NEW_PRODUCT_ENTITY: "save_new_product_entity", //entity was saved

    LOAD_PRODUCT_NUMBER_EVENT: "load_product_number_event", //store: product number was loaded from server
    NEW_PRODUCT_ENTITY_CHANGE_EVENT: "new_product_entity_change_event", //store: entity was saved
    NEW_PRODUCT_ENTITY_CHANGE_WITH_ERROR_EVENT: "new_product_entity_change_with_error_event", //store: entity was not saved (saving errors)

    SAVE_NEW_PRODUCT: "save_new_product", //event to NewProductStore: it needs say about full saving
    DICTIONARIES_CHANGE_EVENT: "dictionaries_change_event", //store: dictionaries was loaded from server?
    NEW_PRODUCT_CHANGE_EVENT: "new_product_change_event", //store: all data (entity, file links etc) was saved
    DEFAULT_PRODUCT_CHANGE_EVENT: "work_centers_change_event",
    WORK_CENTERS_CHANGE_EVENT: "work_centers_change_event",

    UPDATE_PRODUCIBILITY_INFO: "update_producibility_information",
    UPDATE_WORK_CENTER_NOTE: "update_work_center_note",

    ADD_FILE_LINK: "add_file_link",
    REMOVE_FILE_LINK: "remove_file_link",
    FILE_LINKS_CHANGE_EVENT: "file_links_change_event", //UploadFilesStore: file link was added or removed
    SELECTED_FILES_WERE_SAVED: "selected_files_were_saved", //file links was saved

    IMAGES_CHANGE_EVENT: "images_change_event",
    INIT_IMAGE_STORE: "init_image_store",
    ADD_IMAGE: "add_image",
    REMOVE_IMAGE: "remove_image",

    COPY_PRODUCT: "copy",
    EDIT_PRODUCT: "edit",
    CREATE_NEW_PRODUCT: "new",

    UPDATE_CHANGE_EVENT: "update_change_event",
    UPDATE_WORKPIECE_WIDTH: "update_workpiece_width",
    UPDATE_PRODUCTION_FORMAT: "update_production_format"

};

export default EventConstants;