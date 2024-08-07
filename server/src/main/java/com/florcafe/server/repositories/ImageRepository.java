package com.florcafe.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florcafe.server.entities.components.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

}
