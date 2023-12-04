package com.spiderverse.spider.services;

import com.spiderverse.spider.entities.Villain;
import com.spiderverse.spider.repositories.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VillainService {

    @Autowired
    private VillainRepository repository;

    public List<Villain> findAll() {
        return repository.findAll();
    }

    public Villain findById(Long id) {
        Optional<Villain> villain = repository.findById(id);
        return villain.get();
    }

}
