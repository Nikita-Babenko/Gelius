var isLoggingEnabled = true;

var Logging = {

    log (message) {
        if (isLoggingEnabled)
            console.log("[INFO]: ", message);
    }
};

export default Logging;