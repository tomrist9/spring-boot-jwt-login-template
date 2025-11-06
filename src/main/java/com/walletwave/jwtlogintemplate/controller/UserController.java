package com.walletwave.jwtlogintemplate.controller;

import com.walletwave.jwtlogintemplate.constants.ApplicationConstants;
import com.walletwave.jwtlogintemplate.dto.LoginRequestDTO;
import com.walletwave.jwtlogintemplate.dto.LoginResponseDTO;
import com.walletwave.jwtlogintemplate.model.Customer;
import com.walletwave.jwtlogintemplate.repository.CustomerRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final Environment env;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        String hashPwd = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashPwd);
        customer.setCreateDt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);

        if (savedCustomer.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User registered successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("User registration failed");
    }

    @GetMapping("/user")
    public ResponseEntity<Customer> getUserDetailsAfterLogin(Authentication authentication) {
        return customerRepository.findByEmail(authentication.getName())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

   @PostMapping("/login")
   public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
      String jwt="";
      Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(),
              loginRequest.password());
      Authentication authenticationResponse = authenticationManager.authenticate(authentication);
      if (null != authenticationResponse && authenticationResponse.isAuthenticated()) {
          if(null != env){
              String secret = env.getProperty(ApplicationConstants.JWT_SECRET_KEY,
                      ApplicationConstants.JWT_SECRET_DEFAULT_VALUE);
              SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
          jwt = Jwts.builder().issuer("Wallet wave").subject("JWT Token")
                      .claim("username", authenticationResponse.getName())
                      .claim("authorities", authenticationResponse.getAuthorities().stream().map(
                              GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                      .issuedAt(new Date())
                      .expiration(new Date((new Date()).getTime() + 30000000))
                      .signWith(secretKey).compact();

          }
      }

      return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstants.JWT_HEADER, jwt)
              .body(new LoginResponseDTO(HttpStatus.OK.getReasonPhrase(), jwt));
   }
}
