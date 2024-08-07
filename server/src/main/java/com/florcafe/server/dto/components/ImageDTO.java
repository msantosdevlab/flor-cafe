package com.florcafe.server.dto.components;

import com.florcafe.server.entities.components.Image;
import com.florcafe.server.entities.enums.Areas;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO {

    private String id;
    private String url;
    private String nameImage;
    private String extension;

    @Enumerated(EnumType.STRING)
    private Areas area;

    public ImageDTO(Image entity) {
        id = entity.getId();
        url = entity.getUrl();
        nameImage = entity.getNameImage();
        extension = entity.getExtension().name();
        area = entity.getArea();
    }


}
