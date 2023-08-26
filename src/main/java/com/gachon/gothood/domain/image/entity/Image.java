package com.gachon.gothood.domain.image.entity;

import com.gachon.gothood.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@SuperBuilder
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private Boolean gender;
}
