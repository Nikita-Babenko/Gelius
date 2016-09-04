var isLoggingEnabled = false;

var Logging = {

    log (message) {
        if (isLoggingEnabled)
            console.log("[INFO]: ", message);
    }
};

export default Logging;