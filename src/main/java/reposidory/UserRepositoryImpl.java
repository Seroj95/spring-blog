package reposidory;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserRepositoryImpl implements UserDetailsService {
@Autowired
private MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;

    }
}
