package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.Repositories.AlbumRepository;
import com.example.springBoot2.models.Album;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    @GetMapping("/all")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Album> getAlbum(@PathVariable int id) {
        return albumRepository.findById(id);
    }
    @PostMapping("/add")
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }
    @PutMapping("/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album album) {
        return albumRepository.save(album);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }
}