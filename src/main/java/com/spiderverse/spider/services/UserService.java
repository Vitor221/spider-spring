package com.spiderverse.spider.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.spiderverse.spider.entities.User;
import com.spiderverse.spider.repositories.UserRepository;
import com.spiderverse.spider.services.exceptions.DatabaseException;
import com.spiderverse.spider.services.exceptions.ResourceNotFoundException;

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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
    	try {
    		if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
    		
    		repository.deleteById(id);
    		
    	} catch(DataIntegrityViolationException e) {
    		throw new DatabaseException(e.getMessage());
    	}
        
    }

    public User update(Long id, User user) {
    	try {
    		
			User _user = repository.getReferenceById(id);
			
	        updateData(_user, user);
	        return repository.save(_user);
	        
    	} catch(HttpMessageNotReadableException e) {
    		throw new ResourceNotFoundException(id);
    	}
        
    }

    private void updateData(User _user, User user) {
        _user.setName(user.getName());
        _user.setEmail(user.getEmail());
    }
}
