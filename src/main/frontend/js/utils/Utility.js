var Utility = {
    getFullProductNumber (productNumber, isNew) {
        var needLength = isNew ? 5 : 4;
        var currentLength = String(productNumber).length;
        var fullNumber = "";
        for (var i = 0; i < needLength - currentLength; i++)
            fullNumber += "0";
        fullNumber += productNumber;
        return fullNumber;
    }
};

export default Utility;