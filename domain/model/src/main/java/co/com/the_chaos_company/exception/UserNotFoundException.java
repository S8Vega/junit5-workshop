package co.com.the_chaos_company.exception;

import co.com.the_chaos_company.model.user.Document;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Document document) {
        super("User not valid: " + document);
    }
}
