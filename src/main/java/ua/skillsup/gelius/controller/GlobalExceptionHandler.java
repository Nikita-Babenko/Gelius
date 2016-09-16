package ua.skillsup.gelius.controller;

import org.apache.commons.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import ua.skillsup.gelius.controller.response.Response;
import ua.skillsup.gelius.controller.response.ResponseCode;

@ControllerAdvice()
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger("GlobalExceptionHandler");

    @ResponseBody
    @ExceptionHandler(MultipartException.class)
    public Response exceptionHandler(MultipartException e) {
        LOG.info("ExceptionHandler: " + e);
        if (e.getCause() instanceof FileUploadBase.FileSizeLimitExceededException) {
            return new Response(ResponseCode.FILE_SIZE_EXCEEDED);
        }
        return new Response(ResponseCode.SERVER_ERROR);
    }
}
