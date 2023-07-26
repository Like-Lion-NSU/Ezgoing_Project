package com.example.demo.Service;

import com.example.demo.MemberDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface MemberDetailsService  {
    MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
