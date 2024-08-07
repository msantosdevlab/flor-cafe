package com.florcafe.server.dto;

import java.util.ArrayList;
import java.util.List;

import com.florcafe.server.dto.components.ContentBtnDTO;
import com.florcafe.server.dto.components.ContentCompleteDTO;
import com.florcafe.server.dto.components.ContentSimpleDTO;
import com.florcafe.server.entities.PageTemplate;
import com.florcafe.server.entities.components.ContentBtn;
import com.florcafe.server.entities.components.ContentComplete;
import com.florcafe.server.entities.components.ContentSimple;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageTemplateDTO {
    private Long id;

    private String namePage;

    @Builder.Default
    private List<ContentSimpleDTO> contentSimple = new ArrayList<>();
    @Builder.Default
    private List<ContentCompleteDTO> contentComplete = new ArrayList<>();
    @Builder.Default
    private List<ContentBtnDTO> contentBtn = new ArrayList<>();

    public PageTemplateDTO(PageTemplate entity) {
        id = entity.getId();
        namePage = entity.getNamePage();
        
        //inicializar para evitar o NullPointerException. O Builder.Default não inicializa a lista para o construtor personalizado.
        contentSimple = new ArrayList<>();
        contentComplete = new ArrayList<>();
        contentBtn = new ArrayList<>();
 
        for (ContentSimple contSimple : entity.getContentSimple()) {
            contentSimple.add(new ContentSimpleDTO(contSimple));
        }

        for (ContentComplete contComplete : entity.getContentComplete()) {
            contentComplete.add(new ContentCompleteDTO(contComplete));
        }

        for (ContentBtn contBtn : entity.getContentBtn()) {
            contentBtn.add(new ContentBtnDTO(contBtn));
        }
    }

}
