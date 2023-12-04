package com.spiderverse.spider.resources;

import com.spiderverse.spider.entities.Villain;
import com.spiderverse.spider.services.VillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/villains")
public class VillainResource {

    @Autowired
    private VillainService service;

    @GetMapping
    public ResponseEntity<List<Villain>> findAll() {
        List<Villain> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Villain> findById(@PathVariable Long id) {
        Villain villain = service.findById(id);
        return ResponseEntity.ok().body(villain);
    }
}
