package com.gachon.gothood.domain.image.repository;

import com.gachon.gothood.domain.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
