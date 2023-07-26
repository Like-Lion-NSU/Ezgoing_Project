package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface MemberDetails extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    boolean isAccountNonExpired();

    boolean isAccountNonExpried();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();

}
