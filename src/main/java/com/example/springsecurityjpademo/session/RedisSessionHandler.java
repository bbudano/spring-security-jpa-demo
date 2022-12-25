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

    public void removeAllUserSessions(String principalName) {
        log.debug("Removing all sessions for user: {}", principalName);
        sessionRepository.findByPrincipalName(principalName)
                .forEach((id, session) -> sessionRepository.deleteById(session.getId()));
    }

    public void removeUserSession(String principalName, String sessionId) {
        var sessionOptional = sessionRepository.findByPrincipalName(principalName)
                .values().stream().filter(session -> sessionId.equals(session.getId())).findFirst();

        sessionOptional.ifPresent(session -> sessionRepository.deleteById(session.getId()));
    }

}
