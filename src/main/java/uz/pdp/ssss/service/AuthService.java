package uz.pdp.ssss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.ssss.entity.Role;
import uz.pdp.ssss.entity.User;
import uz.pdp.ssss.payload.ApiResponce;
import uz.pdp.ssss.payload.RegisterDto;
import uz.pdp.ssss.repository.RoleRepository;
import uz.pdp.ssss.repository.UserRepository;
import uz.pdp.ssss.utils.AppConstant;

import java.util.Optional;


@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public ApiResponce register(RegisterDto registerDto) {
        if (userRepository.existsByUserName(registerDto.getUserName()))
            return new ApiResponce("This user already exists", false);
        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return new ApiResponce("Password va prepassword mos emas", false);
        Optional<Role> optionalRole = roleRepository.findByName(AppConstant.USER);
        if (!optionalRole.isPresent())
            return new ApiResponce("Role not found", false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUserName(),
                passwordEncoder.encode(registerDto.getPassword()),
                optionalRole.get()
        );
        userRepository.save(user);
        return new ApiResponce("User succesfully added", true);

    }
}
