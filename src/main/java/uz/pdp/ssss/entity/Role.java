package uz.pdp.ssss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ssss.entity.enums.Permission;
import uz.pdp.ssss.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissionSet;

    @Column(length = 1000)
    private String description;


//    boolean enabled;
//    boolean accountNonExpired = true;
//    boolean accountNonLocked = true;
//    boolean credentialsNonExpired = true;
//
//    public Role(String name, Set<Permission> permissionSet, boolean enabled) {
//        this.name = name;
//        this.permissionSet = permissionSet;
//        this.enabled = enabled;
//    }
}

