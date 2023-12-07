package com.spiderverse.spider.resources;

import com.spiderverse.spider.entities.Spiderverse;
import com.spiderverse.spider.services.SpiderverseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Spiderverse> insert(@RequestBody Spiderverse spider) {
        Spiderverse _spider = service.insert(spider);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(_spider.getEarthId()).toUri();

        return ResponseEntity.created(uri).body(_spider);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Spiderverse> update(@PathVariable Long id, @RequestBody Spiderverse spider) {
        Spiderverse _spider = service.update(id, spider);

        return ResponseEntity.ok().body(_spider);
    }
}
