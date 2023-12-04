package com.spiderverse.spider.services;

import com.spiderverse.spider.entities.Spiderverse;
import com.spiderverse.spider.repositories.SpiderverseRepository;
import com.spiderverse.spider.resources.SpiderverseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpiderverseService {
    @Autowired
    private SpiderverseRepository repository;

    public List<Spiderverse> findAll() {
        List<Spiderverse> list = repository.findAll();
        return list;
    }

    public Spiderverse findById(Long id) {
        Optional<Spiderverse> spider = repository.findById(id);
        return spider.get();
    }
}
