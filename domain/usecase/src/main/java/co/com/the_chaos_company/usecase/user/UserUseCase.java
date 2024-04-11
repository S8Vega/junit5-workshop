package co.com.the_chaos_company.usecase.user;

import co.com.the_chaos_company.exception.UserNotFoundException;
import co.com.the_chaos_company.exception.UserNotValidException;
import co.com.the_chaos_company.model.user.Document;
import co.com.the_chaos_company.model.user.User;
import co.com.the_chaos_company.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    public User save(User user) {
        if (user.isValid()) {
            return userRepository.save(user);
        }
        throw new UserNotValidException(user);
    }

    public User findByDocument(Document document) {
        return userRepository.findByDocument(document)
                .orElseThrow(() -> new UserNotFoundException(document));
    }
}
