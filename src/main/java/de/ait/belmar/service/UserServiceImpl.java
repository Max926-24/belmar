package de.ait.belmar.service;

import de.ait.belmar.domain.User;
import de.ait.belmar.domain.enums.Role;
import de.ait.belmar.dto.user.UserRegistrationDto;
import de.ait.belmar.exceptions.RegistrationException;
import de.ait.belmar.repository.UserRepository;
import de.ait.belmar.service.interfaces.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void register(UserRegistrationDto registrationDto) {

        if (repository.existsByEmail(registrationDto.getEmail())) {
            throw new RegistrationException("User with email " +
                    registrationDto.getEmail() + " already exists");
        }

        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setName(registrationDto.getName());

        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(Role.ROLE_USER);

        repository.save(user);


    }
}
