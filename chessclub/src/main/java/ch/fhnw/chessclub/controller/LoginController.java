// package ch.fhnw.chessclub.controller;

// import ch.fhnw.chessclub.business.service.LoginService;
// import ch.fhnw.chessclub.data.domain.LoginRequest;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class LoginController {

//     @Autowired
//     private LoginService loginService;

//     @PostMapping("/login")
// public ResponseEntity<String> login(@RequestBody LoginRequest credentials) {
// System.out.println("Username: " + credentials.getUsername());
// System.out.println("Password: " + credentials.getPassword());
// boolean isAuthenticated = loginService.authenticate(credentials);
// if (isAuthenticated) {
//     return ResponseEntity.ok("Login successful!");
// } else {
//     return ResponseEntity.status(401).body("Invalid username or password.");
// }

// }
// }

