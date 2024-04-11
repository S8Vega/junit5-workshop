package co.com.the_chaos_company.exception;

import co.com.the_chaos_company.model.user.User;

public class UserNotValidException extends RuntimeException {
    public UserNotValidException(User user) {
        super("User not valid: " + user);
    }
}
