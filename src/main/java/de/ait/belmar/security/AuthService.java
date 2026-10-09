package de.ait.belmar.security;

import de.ait.belmar.domain.User;
import de.ait.belmar.exceptions.AuthenticationException;
import de.ait.belmar.repository.UserRepository;
import de.ait.belmar.security.dto.LoginRequestDto;
import de.ait.belmar.security.dto.TokenResponseDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    public AuthService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public TokenResponseDto login(LoginRequestDto loginDto) {

        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new AuthenticationException("Invalid email or password"));
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid email or password");

        }
        String token = tokenService.generateToken(user.getEmail());
        return new TokenResponseDto(token);

    }
}
