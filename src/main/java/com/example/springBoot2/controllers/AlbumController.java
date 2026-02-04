//package com.example.springBoot2.controllers;
//
//import com.example.springBoot2.models.Album;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/albums")
//public class AlbumController {
//    private final List<Album> albums = List.of(
//        new Album("The Dark Side of the Moon", "Pink Floyd", 1973, 10),
//        new Album("Back in Black", "AC/DC", 1980, 10),
//        new Album("The Bodyguard", "Whitney Houston", 1992, 10)
//    );
//
//    @GetMapping
//    public List<Album> getAlbums() {
//        return albums;
//    }
//}

package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    //1
    @GetMapping("")
    public List<Album> getAllItems() {
        return albumRepository.findAll();
    }
    //2
    @GetMapping("/{id}")
    public Album getItem(@PathVariable int id) {
        return albumRepository.findById(id).orElse(null);
    }
    //3
    @PostMapping("")
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }
    //4
    @PutMapping("/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album album) {
         album.setId(id);
        return albumRepository.save(album);
    }
    //5
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }


}