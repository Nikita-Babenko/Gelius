var isLoggingEnabled = false;

var Logging = {

    log (message) {
        if (isLoggingEnabled)
            console.log("[LOG]: ", message);
    }
};

export default Logging;