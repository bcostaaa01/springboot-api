package com.bruno.cats.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CatController {

    private Map<String, Cat> db = new HashMap<>() {{
        put("1", new Cat("1", "Pantufas", "Ragdoll", 5));
    }};

    @GetMapping("/cats/{id}")
    public Cat getCats(@PathVariable String id) {
        return db.get(id);
    }
}
