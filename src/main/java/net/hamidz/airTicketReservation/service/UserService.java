package net.hamidz.airTicketReservation.service;

import net.hamidz.airTicketReservation.entity.User;
import net.hamidz.airTicketReservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found!!!"));
        return user;
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found :-("));
        if(user != null && !user.equals("")) {
            userRepository.delete(user);
        } else {
            throw new RuntimeException("invalid user type");
        }
    }

}
