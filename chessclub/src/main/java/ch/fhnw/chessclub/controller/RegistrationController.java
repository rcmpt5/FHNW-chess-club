package ch.fhnw.chessclub.controller;

import ch.fhnw.chessclub.business.service.RegistrationService;
import ch.fhnw.chessclub.data.domain.RegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationForm form) {
        boolean success = registrationService.register(form);
        if (success) {
            return ResponseEntity.ok("Registration successful!");
        } else {
            return ResponseEntity.status(409).body("User already exists or data invalid.");
        }
    }
}
