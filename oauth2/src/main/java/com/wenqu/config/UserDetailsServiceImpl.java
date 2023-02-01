package com.wenqu.config;

import com.wenqu.domain.Permission;
import com.wenqu.domain.User;
import com.wenqu.service.PermissionService;
import com.wenqu.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user = userService.getUserByUsername(s);
       List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
       if (user != null) {
           List<Permission> permissionList = permissionService.getPermissionListByUserId(user.getId());
           permissionList.forEach(permission -> {
               GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
               grantedAuthorityList.add(grantedAuthority);
           });
           return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorityList);
        }
        return null;
    }
}
