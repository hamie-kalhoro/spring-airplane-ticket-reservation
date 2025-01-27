package net.hamidz.airTicketReservation.service.impl;

import net.hamidz.airTicketReservation.entity.User;
import net.hamidz.airTicketReservation.repository.UserRepository;
import net.hamidz.airTicketReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User saved = userRepository.save(user);
        return saved;
    }
}
