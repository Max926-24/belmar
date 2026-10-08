package de.ait.belmar.service.interfaces;

import de.ait.belmar.dto.user.UserRegistrationDto;

public interface UserService {

    void register(UserRegistrationDto registrationDto);
}
