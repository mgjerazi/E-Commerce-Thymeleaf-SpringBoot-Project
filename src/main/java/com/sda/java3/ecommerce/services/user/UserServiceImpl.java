package com.sda.java3.ecommerce.services.user;

import com.sda.java3.ecommerce.domains.User;
import com.sda.java3.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl( final UserRepository clientRepository){
        this.userRepository = clientRepository;
    }

    @Override
    public List<User> getFeaturedUsers(){
        return userRepository.findAll();
    }
}
