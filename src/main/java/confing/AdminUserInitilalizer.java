package confing;

import model.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import reposidory.UserRepository;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;
import java.util.logging.Logger;

public class AdminUserInitilalizer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    private static final Logger loger = (Logger) LoggerFactory.getLogger(AdminUserInitilalizer.class);

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if (userRepository.loadUserByUsername("admin")!=null){
            loger.info(String::new);
            return;
        }
        String password=UUID.randomUUID().toString();
        User user=new User();
        user.setUsername("admin");
        user.setPassword(encoder.encode(password));
        user.getRegistrationDate(new Date());
//        user.setRoles(new HashSet<>(Arrays.asList(User.ROLE_USER, User.ROLE_ADMIN)));

        userRepository.insert(user);

//        logger.info(String.format("SUCCESS: Created admin user with username %s and password %s", "admin", password));
    }


}
