package com.code.wings.exambooster.dao;
import com.code.wings.exambooster.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);
}
