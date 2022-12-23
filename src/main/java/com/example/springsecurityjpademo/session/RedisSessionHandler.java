package com.example.springsecurityjpademo.session;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSessionHandler {

    private final FindByIndexNameSessionRepository<? extends Session> sessionRepository;

    public void removeAllUsersSession(String principalName) {
        log.debug("Removing all sessions for user: {}", principalName);
        sessionRepository.findByPrincipalName(principalName)
                .forEach((id, session) -> sessionRepository.deleteById(session.getId()));
    }

}
