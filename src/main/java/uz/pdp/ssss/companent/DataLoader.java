package uz.pdp.ssss.companent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.ssss.entity.Role;
import uz.pdp.ssss.entity.User;
import uz.pdp.ssss.entity.enums.Permission;
import uz.pdp.ssss.repository.RoleRepository;
import uz.pdp.ssss.repository.UserRepository;
import uz.pdp.ssss.utils.AppConstant;

import java.util.Arrays;

import static uz.pdp.ssss.entity.enums.Permission.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initilizayionMode;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initilizayionMode.equals("always")) {
            Permission[] permission = Permission.values();
            Role ROLE_ADMIN = roleRepository.save(new Role(
                    AppConstant.ADMIN,
                    Arrays.asList(permission)
            ));
            Role ROLE_USER = roleRepository.save(new Role(
                    AppConstant.USER,
                    Arrays.asList(GET_ONE_COMMIT, GET_ONE_POST, GET_ALL_POST, GET_ONE_ROLE)
            ));
            userRepository.save(new User(
                    "Admin",
                    "Admin",
                    passwordEncoder.encode("Admin123"),
                    ROLE_ADMIN
            ));
            userRepository.save(new User(
                    "User",
                    "User",
                    passwordEncoder.encode("User123"),
                    ROLE_USER
            ));
        }
    }
}
