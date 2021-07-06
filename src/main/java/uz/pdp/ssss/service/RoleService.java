package uz.pdp.ssss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.ssss.entity.Role;
import uz.pdp.ssss.payload.ApiResponce;
import uz.pdp.ssss.payload.RoleDto;
import uz.pdp.ssss.repository.RoleRepository;

import java.util.Optional;


@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;


    public ApiResponce addRole(RoleDto roleDto) {

        boolean exists = roleRepository.existsByName(roleDto.getName());
        if (exists)
            return new ApiResponce("This Role alReady exists", false);
        Role role = new Role();
        role.setDescription(roleDto.getDescription());
        role.setName(roleDto.getName());
        role.setPermissionSet(roleDto.getPermissionSet());

        Role rolesaved = roleRepository.save(role);

        return new ApiResponce("Role saved success", true, rolesaved);
    }
}
