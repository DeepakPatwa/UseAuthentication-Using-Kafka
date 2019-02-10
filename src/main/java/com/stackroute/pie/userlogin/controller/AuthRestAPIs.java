package com.stackroute.pie.userlogin.controller;

import com.stackroute.pie.userlogin.message.request.LoginForm;
//import com.stackroute.pie.message.request.SignUpForm;
import com.stackroute.pie.userlogin.message.response.JwtResponse;
import com.stackroute.pie.userlogin.repository.RoleRepository;
import com.stackroute.pie.userlogin.repository.UserRepository;
import com.stackroute.pie.userlogin.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
    @RestController
    @RequestMapping("/api/auth")
    public class AuthRestAPIs {

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        UserRepository userRepository;

        @Autowired
        RoleRepository roleRepository;

        @Autowired
        PasswordEncoder encoder;

        @Autowired
        JwtProvider jwtProvider;


        @GetMapping("/hi")
        public ResponseEntity<?> check(){
            return new ResponseEntity<String>("Hello", HttpStatus.OK);
        }

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtProvider.generateJwtToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
        }

//        @PostMapping("/signup")
//        public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
//            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//                return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
//                        HttpStatus.BAD_REQUEST);
//            }
//
//            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//                return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
//                        HttpStatus.BAD_REQUEST);
//            }
//
//            // Creating user's account
//            User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
//                    encoder.encode(signUpRequest.getPassword()));
//
//            Set<String> strRoles = signUpRequest.getRole();
//            Set<Role> roles = new HashSet<>();
//
//            strRoles.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                        roles.add(adminRole);
//
//                        break;
//                    case "pm":
//                        Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
//                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                        roles.add(pmRole);
//
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//                        roles.add(userRole);
//                }
//            });
//
//            user.setRoles(roles);
//            userRepository.save(user);
//
//            return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
//        }
    }

