package com.code.wings.exambooster.service;

import com.code.wings.exambooster.entity.User;
import com.code.wings.exambooster.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);

    public void save(CrmUser crmUser);
}
