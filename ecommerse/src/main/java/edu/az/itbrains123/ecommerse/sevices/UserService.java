package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.user.UserInfoDto;
import edu.az.itbrains123.ecommerse.dtos.user.UserRegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean register (UserRegisterDto userRegisterDto);

    UserInfoDto getUserInfo (String userEmail);
}
