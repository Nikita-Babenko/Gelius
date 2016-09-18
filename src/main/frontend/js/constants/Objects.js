var ObjectsConstants = {

    productTableColumnNames: [
        {name: 'productNumber', text: '№'},
        {name: 'client.companyName', text: 'Клиент'},
        {name: 'productName', text: 'Название продукта'},
        {name: 'productType.productType', text: 'Тип изделия'},
        {name: 'innerLength', text: 'длина'},
        {name: 'innerWidth', text: 'ширина'},
        {name: 'innerHeight', text: 'высота'},
        {name: 'cardboardBrand.cardboardBrand', text: 'Марка'},
        {name: 'profile.profile', text: 'Профиль'},
        {name: 'layersColours', text: 'Цвет'},
        {name: 'cliche', text: 'Печать'}
    ],

    UPLOADED_FILE_SIZE_LIMIT: 15 * 1024 * 1024, //size limit for each uploaded file (in bytes)
    UPLOADED_FILES_COUNT_LIMIT: 5

};

export default ObjectsConstants;