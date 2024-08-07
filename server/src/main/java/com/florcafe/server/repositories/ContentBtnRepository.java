package com.florcafe.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florcafe.server.entities.components.ContentBtn;

@Repository
public interface ContentBtnRepository extends JpaRepository<ContentBtn, Long> {

}
