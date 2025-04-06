package ch.fhnw.chessclub.business.service;

import ch.fhnw.chessclub.data.domain.RegistrationForm;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {

    private Set<String> registeredUsers = new HashSet<>(); // Simulating a DB

    public boolean register(RegistrationForm form) {
        // Very basic "is user already registered"
        if (registeredUsers.contains(form.getUsername())) {
            return false; // username taken
        }

        registeredUsers.add(form.getUsername());
        System.out.println("User registered: " + form.getUsername());
        return true;
    }
}
