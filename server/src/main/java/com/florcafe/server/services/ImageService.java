package com.florcafe.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florcafe.server.entities.components.Image;
import com.florcafe.server.repositories.ImageRepository;

import jakarta.transaction.Transactional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    @Transactional
    public List<Image> insertImages(List<Image> images) {
        return repository.saveAll(images);
    }

    @Transactional
    public Image update(Image image) {
        return repository.saveAndFlush(image);
    }

    @Transactional
    public List<Image> updateImages(List<Image> images) {
        return repository.saveAllAndFlush(images);
    }

    public Optional<Image> getById(String id) {
        return repository.findById(id);
    }

}
