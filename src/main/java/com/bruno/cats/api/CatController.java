package com.bruno.cats.api;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CatController {

    private Map<String, Cat> db = new HashMap<>() {{
        put("1", new Cat("1", "Pantufas", "Ragdoll", 5));
    }};

    @GetMapping("/cats/{id}")
    public Cat getCats(@PathVariable String id) {
        return db.get(id);
    }

    @GetMapping("/cats")
    public Map<String, Cat> getCats() {
        return db;
    }

    @PostMapping("/cats")
    public Cat addCat(@RequestBody @Valid Cat cat) {
        cat.setId(UUID.randomUUID().toString());
        db.put(cat.getId(), cat);
        return cat;
    }

    @DeleteMapping("/cats/{id}")
    public Cat deleteCat(@PathVariable String id) {
        Cat cat = db.remove(id);
        if (cat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat not found");
        }
        return cat;
    }
}
