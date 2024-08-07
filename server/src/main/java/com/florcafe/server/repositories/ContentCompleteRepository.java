package com.florcafe.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florcafe.server.entities.components.ContentComplete;

@Repository
public interface ContentCompleteRepository extends JpaRepository<ContentComplete, Long> {

}
