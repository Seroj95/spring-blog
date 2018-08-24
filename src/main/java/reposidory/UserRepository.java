package reposidory;

import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRepository extends MongoRepository<User,String>, UserDetailsService {
    void insert(model.User user);
}
