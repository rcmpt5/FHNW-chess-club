package ch.fhnw.securitytest.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class TokenService {

    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        // Define the JWT scope
        String scope = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .filter(authority -> !authority.startsWith("ROLE"))
                .collect(Collectors.joining(" "));

        // Create the JWT claims
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self") // Issued by this application
                .issuedAt(now) // Issued now
                .expiresAt(now.plus(1, ChronoUnit.HOURS)) // Expires in 1 hour
                .subject(authentication.getName()) // Subject is the username
                .claim("scope", scope) // Add the scope
                .build();

        // Encode the JWT
        var encoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(), claims);
        return this.encoder.encode(encoderParameters).getTokenValue();
    }
}