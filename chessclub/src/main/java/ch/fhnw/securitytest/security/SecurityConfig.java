// package ch.fhnw.securitytest.security;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// import com.nimbusds.jose.jwk.JWK;
// import com.nimbusds.jose.jwk.OctetSequenceKey;
// import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
// import com.nimbusds.jose.jwk.JWKSet;
// import com.nimbusds.jose.jwk.source.JWKSource;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import javax.crypto.spec.SecretKeySpec;
// import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// public class SecurityConfig {

//     @Value("${jwt.key}")
//     private String jwtKey;

//     // Define a custom user with role USER
//         @Bean
//     public UserDetailsService users() {
//         //Create two users with different roles and add them to the in-memory user store
//         return new InMemoryUserDetailsManager(
//             User.withUsername("myuser")
//                 //.password("{noop}password") //create user with an encrypted password instead of the plain text password
//                 .password("{bcrypt}$2a$10$9fxQtdWuRaYn5UchAm5iAexbPi7tmRadnDogJwXPR9fVDJyt9g/su")
//                 .authorities("READ","ROLE_USER")
//                 .build(), 
//             User.withUsername("myadmin")
//                 //.password("{noop}password") //create user with an encrypted password instead of the plain text password
//                 .password("{bcrypt}$2a$10$9fxQtdWuRaYn5UchAm5iAexbPi7tmRadnDogJwXPR9fVDJyt9g/su")
//                 .authorities("READ","ROLE_ADMIN")
//                 .build());
//     }

//     // // Define the Security Filter Chain
//     // @Bean
//     // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     //     return http
//     //             .csrf(csrf -> csrf.disable()) // Disable CSRF for REST APIs
//     //             .authorizeHttpRequests(auth -> auth
//     //                     .requestMatchers("/securitytest/token").hasRole("USER") // Only USER role can request a token
//     //                     .anyRequest().hasAuthority("SCOPE_READ")) // Only requests with SCOPE_READ can access other endpoints
//     //             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session
//     //             .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults())) // Enable JWT-based authentication
//     //                     .httpBasic(withDefaults()) // Enable HTTP Basic Authentication
//     //                 .build(); // Add missing closing parenthesis for the method chain
//     // }

//     @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     return http
//             // .csrf(AbstractHttpConfigurer::disable)
//             .authorizeHttpRequests(auth -> auth
//                     .anyRequest().permitAll() // 👈 Allow all endpoints without authentication
//             )
//                return http.build();
//     }


//     // Define a JWT Encoder
//     @Bean
//     JwtEncoder jwtEncoder() {
//         SecretKeySpec secretKey = new SecretKeySpec(jwtKey.getBytes(), "HmacSHA256");
//         JWK jwk = new OctetSequenceKey.Builder(secretKey).build();
//         JWKSource<com.nimbusds.jose.proc.SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
//         return new NimbusJwtEncoder(jwkSource);
//     }

//     // Define a JWT Decoder
//     @Bean
//     public JwtDecoder jwtDecoder() {
//         byte[] bytes = jwtKey.getBytes();
//         SecretKeySpec originalKey = new SecretKeySpec(bytes, 0, bytes.length, "RSA");
//         return NimbusJwtDecoder.withSecretKey(originalKey).macAlgorithm(MacAlgorithm.HS512).build();
//     }
// }

