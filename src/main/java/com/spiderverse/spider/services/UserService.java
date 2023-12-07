package com.spiderverse.spider.services;

import com.spiderverse.spider.entities.User;
import com.spiderverse.spider.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User _user = repository.getReferenceById(id);
        updateData(_user, user);

        return repository.save(_user);
    }

    private void updateData(User _user, User user) {
        _user.setName(user.getName());
        _user.setEmail(user.getEmail());
    }
}
