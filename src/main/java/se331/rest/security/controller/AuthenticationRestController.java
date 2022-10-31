package se331.rest.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.*;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.JwtUser;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;
import se331.rest.security.service.JwtUserDetailsServiceImpl;
import se331.rest.security.util.JwtTokenUtil;
import se331.rest.util.LabMapper;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@CrossOrigin
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUserDetailsServiceImpl jwtUserDetailsService;

    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map result = new HashMap();
        result.put("token", token);
        User user = userRepository.findById(((JwtUser) userDetails).getId()).orElse(null);
        int authorities = user.getAuthorities().size();
        if (user.getPatient() != null) {
            PatientAuthDTO patientAuthDTO = LabMapper.INSTANCE.getPatientAuthDTO( user.getPatient());
            if (authorities == 3)
                patientAuthDTO.getAuthorities().add("ROLE_ADMIN");
            result.put("user",patientAuthDTO );
        }else if (user.getDoctor() != null){
            DoctorAuthDTO doctorAuthDTO = LabMapper.INSTANCE.getDoctorAuthDTO(user.getDoctor());
            if (authorities == 3)
                doctorAuthDTO.getAuthorities().add("ROLE_ADMIN");
            result.put("user",doctorAuthDTO);
        }
        System.out.println(result);
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody User request){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = User.builder()
                .email(request.getEmail())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .password(encoder.encode(request.getPassword()))
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .imageUrl(request.getImageUrl())
                .build();

        userRepository.save(user);
        return ResponseEntity.ok("Register success!!");
    }

    @GetMapping("/userwithnoauth")
    public ResponseEntity<?> getUserWithNoAuth(){
        List<User> users = userRepository.findUserWithNoAuth();
        if (users != null)
            return ResponseEntity.ok(users);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found");
    }

    @PostMapping("/setrole")
    @Transactional
    public ResponseEntity<?> Setrole(@RequestParam("uid")Long uid,@RequestParam("num")int num){
//        1 is doctor 2 is patient
        Patient patient;
        Doctor doctor;
        Authority auth;


        User user = userRepository.findById(uid).orElse(null);
        String imageurl = user.getImageUrl().get(0);
        List<String> list = new ArrayList<>();
        list.add(imageurl);
        List<User> users = new ArrayList<>();
        if (num ==1){
            doctor = doctorRepository.save(Doctor.builder()
                    .name(user.getFirstname())
                    .sur_name(user.getLastname())
                    .imageUrl(list)
                    .build());

            auth = authorityRepository.findByName(AuthorityName.ROLE_DOCTOR);
            users = authorityRepository.findByName(AuthorityName.ROLE_DOCTOR).getUsers();

            users.add(user);
            authorityRepository.findByName(AuthorityName.ROLE_DOCTOR).setUsers(users);
            auth.setUsers(null);

            user.getAuthorities().add(auth);

            userRepository.save(user);
            doctor.setUser(user);
            Doctor doctor1 = new Doctor();
            doctor1.setUser(null);
            doctor1.setId(doctor.getId());
            doctor1.setName(doctor.getName());
            doctor1.setSur_name(doctor.getSur_name());
            doctor1.setImageUrl(list);

            user.setDoctor(doctor1);
            doctorRepository.AddUser(uid,doctor.getId());
        }
        else if (num ==2) {

            patient = patientRepository.save(Patient.builder()
                    .name(user.getFirstname())
                    .sur_name(user.getLastname())
                    .imageUrl(list)
                    .build());
            Vaccine vaccine = vaccineRepository.save(Vaccine.builder()
                    .vaccined_status("Not Vaccinated")
                    .patient(patient).build());
            Vaccine vaccine1 = new Vaccine();
            vaccine1.setVaccined_status(vaccine.getVaccined_status());
            vaccine1.setId(vaccine.getId());
            patient.setVaccineinfo(vaccine1);
            auth = authorityRepository.findByName(AuthorityName.ROLE_PATIENT);
            users = authorityRepository.findByName(AuthorityName.ROLE_PATIENT).getUsers();

            users.add(user);
            authorityRepository.findByName(AuthorityName.ROLE_PATIENT).setUsers(users);
            auth.setUsers(null);

            user.getAuthorities().add(auth);

            userRepository.save(user);
            patient.setUser(user);
            Patient patient1 = new Patient();
            patient1.setUser(null);
            patient1.setId(patient.getId());
            patient1.setName(patient.getName());
            patient1.setSur_name(patient.getSur_name());
            patient1.setImageUrl(list);
            patient1.setVaccineinfo(vaccine1);

            user.setPatient(patient1);
            patientRepository.AddUser(uid,patient.getId());
        }


        return ResponseEntity.ok(user);
    }



}
