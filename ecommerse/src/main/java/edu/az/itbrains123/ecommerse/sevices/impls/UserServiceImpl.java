package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.user.UserInfoDto;
import edu.az.itbrains123.ecommerse.dtos.user.UserRegisterDto;
import edu.az.itbrains123.ecommerse.models.UserEntity;
import edu.az.itbrains123.ecommerse.repositories.UserRepository;
import edu.az.itbrains123.ecommerse.sevices.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        try {
            UserEntity findUser=userRepository.findByEmail(userRegisterDto.getEmail());
            if(findUser!=null){
                return false;
            }

            UserEntity user=modelMapper.map(userRegisterDto, UserEntity.class);
            String password=bCryptPasswordEncoder.encode(userRegisterDto.getPassword());
            user.setPassword(password);
            UUID uuid=UUID.randomUUID();
            user.setEmailToken(uuid.toString());
            user.setEmailConfirmend(false);
            userRepository.save(user);

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public UserInfoDto getUserInfo(String userEmail) {
        UserEntity user=userRepository.findByEmail(userEmail);
        UserInfoDto result=modelMapper.map(user, UserInfoDto.class);
        return result;
    }
}
