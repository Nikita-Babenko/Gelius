var EventConstants = {

    //Product register constants

    LOAD_FILTERED_SORTED_PRODUCTS: "load_filtered_sorted_products",
    LOAD_ALL_FILTER_PARAMETERS: "load_filter_parameters",
    LOAD_FILTER_PARAMETERS_FOR_COLUMN: "load_filter_parameters",


    ADD_FILTER_ELEMENT: "add_filter_element",
    DELETE_FILTER_ELEMENT: "delete_filter_element",

    APPLY_SORTING: "apply_sorting",

    PRODUCTS_TABLE_CHANGE_EVENT: "products_table_change_event",
    FILTERING_SORTING_CHANGE_EVENT: "filtering_sorting_change_event",


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

    UPDATE_WORKABILITY_INFO: "update_workability_information",
    UPDATE_WORK_CENTER_NOTE: "update_work_center_note",

    ADD_FILE_LINK: "add_file_link",
    REMOVE_FILE_LINK: "remove_file_link",
    FILE_LINKS_CHANGE_EVENT: "file_links_change_event", //UploadFilesStore: file link was added or removed
    SAVE_FILE_LINKS_OF_NEW_PRODUCT: "save_file_links_of_new_product" //file links was saved

};

export default EventConstants;