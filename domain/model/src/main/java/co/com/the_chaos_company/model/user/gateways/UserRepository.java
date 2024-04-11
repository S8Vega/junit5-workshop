package co.com.the_chaos_company.model.user.gateways;

import co.com.the_chaos_company.model.user.Document;
import co.com.the_chaos_company.model.user.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByDocument(Document document);
}
