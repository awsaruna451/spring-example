package com.aruna.model;

import com.aruna.dao.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "role")
    private List<UserRole> userRoles;
    public Role(RoleDto roleDto) {
        this.roleId = roleDto.getRoleId();
        this.roleName = roleDto.getRoleName();
    }

}
