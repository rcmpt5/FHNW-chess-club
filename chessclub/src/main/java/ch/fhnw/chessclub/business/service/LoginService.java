package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.UserCredentials;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // Simple mock authentication (hardcoded username/password)
    public boolean authenticate(UserCredentials credentials) {
        return "admin".equals(credentials.getUsername()) && "chess123".equals(credentials.getPassword());
    }
}
