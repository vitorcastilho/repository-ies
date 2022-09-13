package com.ies.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.repository.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

	Boolean existsByTag(String tag);

}
