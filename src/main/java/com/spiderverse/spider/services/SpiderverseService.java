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

    public Spiderverse insert(Spiderverse spider) {
        return repository.save(spider);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Spiderverse update(Long id, Spiderverse spider) {
        Spiderverse _spider = repository.getReferenceById(id);
        updateData(_spider, spider);
        return repository.save(_spider);
    }

    private void updateData(Spiderverse _spider, Spiderverse spider) {

        _spider.setName(spider.getName());
        _spider.setDescription(spider.getDescription());
        _spider.setSpiderName(spider.getSpiderName());

    }
}
