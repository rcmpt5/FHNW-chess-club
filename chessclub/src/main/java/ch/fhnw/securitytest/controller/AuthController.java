package ch.fhnw.securitytest.controller;

import ch.fhnw.securitytest.security.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/securitytest")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        if (authentication.isAuthenticated()) { // Check if the user is authenticated
            return tokenService.generateToken(authentication);
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}