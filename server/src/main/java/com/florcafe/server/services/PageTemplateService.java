package com.florcafe.server.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.florcafe.server.dto.PageTemplateDTO;
import com.florcafe.server.dto.components.ContentBtnDTO;
import com.florcafe.server.dto.components.ContentCompleteDTO;
import com.florcafe.server.dto.components.ContentSimpleDTO;
import com.florcafe.server.entities.PageTemplate;
import com.florcafe.server.entities.components.ContentBtn;
import com.florcafe.server.entities.components.ContentComplete;
import com.florcafe.server.entities.components.ContentSimple;
import com.florcafe.server.mappers.ComponentsMapper;
import com.florcafe.server.repositories.PagesRepository;
import com.florcafe.server.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PageTemplateService {

    @Autowired
    private PagesRepository repository;

    @Autowired
    private ComponentsMapper componentsMapper;

    @Transactional
    public PageTemplateDTO insert(PageTemplateDTO dto) {
        PageTemplate entity = new PageTemplate();
        entity.setNamePage(dto.getNamePage());

        for (ContentSimpleDTO csDTO : dto.getContentSimple()) {
            ContentSimple contentSimple = componentsMapper.simpleDtoToEntity(csDTO);
            contentSimple.setIdPage(entity);
            entity.getContentSimple().add(contentSimple);
        }

        for (ContentCompleteDTO completeDTO : dto.getContentComplete()) {
            ContentComplete contentblock = componentsMapper.completeDtoToEntity(completeDTO);
            contentblock.setIdPage(entity);
            entity.getContentComplete().add(contentblock);
        }

        for (ContentBtnDTO cbtnDTO : dto.getContentBtn()) {
            ContentBtn contentblock = componentsMapper.btnDtoToEntity(cbtnDTO);
            contentblock.setIdPage(entity);
            entity.getContentBtn().add(contentblock);
        }

        entity = repository.save(entity);

        return new PageTemplateDTO(entity);
    }

    @Transactional(readOnly = true)
    public PageTemplateDTO findPage(String namePage) {
        try {
            PageTemplate result = repository.findPage(namePage);
            PageTemplateDTO dto = new PageTemplateDTO(result);
            return dto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public PageTemplateDTO update(String namePage, PageTemplateDTO dto) {
        try {
            PageTemplate entity = repository.findPage(namePage);

            entity.setNamePage(dto.getNamePage());

            entity.getContentSimple().clear();
            for (ContentSimpleDTO csDTO : dto.getContentSimple()) {
                ContentSimple contentSimple = componentsMapper.simpleDtoToEntity(csDTO);
                contentSimple.setIdPage(entity);
                entity.getContentSimple().add(contentSimple);
            }

            entity.getContentComplete().clear();
            for (ContentCompleteDTO completeDTO : dto.getContentComplete()) {
                ContentComplete contentblock = componentsMapper.completeDtoToEntity(completeDTO);
                contentblock.setIdPage(entity);
                entity.getContentComplete().add(contentblock);
            }

            entity.getContentBtn().clear();
            for (ContentBtnDTO cbtnDTO : dto.getContentBtn()) {
                ContentBtn contentblock = componentsMapper.btnDtoToEntity(cbtnDTO);
                contentblock.setIdPage(entity);
                entity.getContentBtn().add(contentblock);
            }

            entity = repository.saveAndFlush(entity);
            return new PageTemplateDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Página não encontrada");
        }
    }

    @Transactional(readOnly = true) 
    public PageTemplate findById(Long id) {
        Optional<PageTemplate> result = repository.findById(id);
        PageTemplate page = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return page;
    }

}
