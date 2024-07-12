package org.example.facebook.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserAPIException extends RuntimeException {
    @Getter
    private HttpStatus status;
    private String message;
    public UserAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public UserAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
