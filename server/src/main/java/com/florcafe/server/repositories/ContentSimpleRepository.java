package com.florcafe.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florcafe.server.entities.components.ContentSimple;

@Repository
public interface ContentSimpleRepository extends JpaRepository<ContentSimple, Long> {

}
