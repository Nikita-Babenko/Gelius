package ua.skillsup.gelius.model;

import java.util.Collections;
import java.util.List;

public class ResponseWithList<T> extends Response {
    private List<T> data;

    public ResponseWithList(ResponseCode code, List<T> data) {
        super(code);
        this.data = data;
    }

    public ResponseWithList(ResponseCode code, T element) {
        super(code);
        this.data = Collections.singletonList(element);
    }

    public List<T> getData() {
        return data;
    }
}
