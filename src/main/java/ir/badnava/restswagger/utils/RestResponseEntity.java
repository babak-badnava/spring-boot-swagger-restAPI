package ir.badnava.restswagger.utils;

import ir.badnava.restswagger.responsebodymodels.RestResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class RestResponseEntity<T extends RestResponseBody> extends ResponseEntity<T> {

    public RestResponseEntity(HttpStatus status) {
        super(status);
    }

    public RestResponseEntity(T body, HttpStatus status) {
        super(body, status);
    }

    public RestResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public RestResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }
}
