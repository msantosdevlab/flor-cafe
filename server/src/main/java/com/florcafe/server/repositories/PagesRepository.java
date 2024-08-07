package com.florcafe.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.florcafe.server.entities.PageTemplate;

@Repository
public interface PagesRepository extends JpaRepository<PageTemplate, Long> {

    @Query("SELECT page FROM PageTemplate page WHERE UPPER(page.namePage) LIKE UPPER(:namePage)")
    PageTemplate findPage(String namePage);

}