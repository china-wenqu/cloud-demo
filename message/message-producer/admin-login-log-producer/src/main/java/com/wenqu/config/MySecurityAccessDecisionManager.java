package com.wenqu.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class MySecurityAccessDecisionManager implements AccessDecisionManager {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    private List<AccessDecisionVoter<? extends Object>> decisionVoters;


    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        String requestUrl = ((FilterInvocation) object).getRequest().getRequestURI();
        // 当前用户所具有的权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (antPathMatcher.match(grantedAuthority.getAuthority(),requestUrl)){
                return;
            }
        }
        throw new AccessDeniedException("无访问权限");
    }

    /**
     * 复制默认方法，使得@PreAuthorize("hasRole('ROLE_ADMIN')") 可用
     */
    @Override
    public boolean supports(ConfigAttribute attribute) {
        for (AccessDecisionVoter voter : this.decisionVoters) {
            if (voter.supports(attribute)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        for (AccessDecisionVoter voter : this.decisionVoters) {
            if (!voter.supports(clazz)) {
                return false;
            }
        }
        return true;
    }
}