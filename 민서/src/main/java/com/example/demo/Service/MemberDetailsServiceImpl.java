package com.example.demo.Service;

import com.example.demo.MemberDetails;
import com.example.demo.repository.JpaMemberRepositroy;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailsServiceImpl implements MemberDetailsService {
    private final Logger LOGGER = LoggerFactory.getLogger(MemberDetailsServiceImpl.class);

    private final JpaMemberRepositroy jpaMemberRepositroy;


    @Override
    public MemberDetails loadUserByUsername(String username)  {
        LOGGER.info("[loadUserByUsername] loadUserByuSERNAME 수행. username : {}", username);
        return (MemberDetails)  jpaMemberRepositroy.getByUid(username);
    }
}
