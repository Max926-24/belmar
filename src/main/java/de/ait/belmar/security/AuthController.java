package de.ait.belmar.security;

import de.ait.belmar.dto.user.UserRegistrationDto;
import de.ait.belmar.security.dto.LoginRequestDto;
import de.ait.belmar.security.dto.TokenResponseDto;
import de.ait.belmar.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRegistrationDto registrationDto) {
        userService.register(registrationDto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@Valid @RequestBody LoginRequestDto loginDto) {
        return authService.login(loginDto);
    }
}
