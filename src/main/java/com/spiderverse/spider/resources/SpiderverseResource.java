package com.spiderverse.spider.resources;

import com.spiderverse.spider.entities.Spiderverse;
import com.spiderverse.spider.services.SpiderverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spiders")
public class SpiderverseResource {

    @Autowired
    private SpiderverseService service;

    @GetMapping
    public ResponseEntity<List<Spiderverse>> findAll() {
        List<Spiderverse> list =  service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spiderverse> findById(@PathVariable Long id) {
        Spiderverse spider = service.findById(id);
        return ResponseEntity.ok().body(spider);
    }
}
