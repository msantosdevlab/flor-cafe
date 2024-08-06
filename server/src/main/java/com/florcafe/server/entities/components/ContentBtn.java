package com.florcafe.server.entities.components;

import com.florcafe.server.entities.PageTemplate;
import com.florcafe.server.entities.enums.Areas;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_content_btn")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContentBtn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private String btnName;
    private String btnHref;
    private String btnTarget;

    @ManyToOne
    @JoinColumn(name = "id_page")
    private PageTemplate idPage;

    @Enumerated(EnumType.STRING)
    private Areas area;
}
