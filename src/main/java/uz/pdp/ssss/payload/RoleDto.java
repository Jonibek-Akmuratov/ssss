package uz.pdp.ssss.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ssss.entity.enums.Permission;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private String name;
    private List<Permission> permissionSet;
    private String description;


}
