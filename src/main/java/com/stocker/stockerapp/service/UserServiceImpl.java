package com.stocker.stockerapp.service;

import java.util.List;

import com.stocker.stockerapp.entities.User;
import com.stocker.stockerapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) throws Exception {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception());
        existingUser.setNom(user.getNom());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception());
        userRepository.delete(user);
    }
}