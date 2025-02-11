package com.bruno.cats.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@RestController
public class PhotoController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("id", "hello.jpg"));
    }};

    @GetMapping("/photos")
    private Collection<Photo> photos() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo photo(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }

        return photo;
    }

    @PostMapping("/photos")
    public Photo addPhoto(Photo photo) {
        db.put(photo.getId(), photo);
        return photo;
    }

    @PutMapping("/photos/{id}")
    public Photo updatePhoto(@PathVariable String id, Photo photo) {
        if (!db.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        db.put(id, photo);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public Photo deletePhoto(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo not found");
        }
        return photo;
    }
}
