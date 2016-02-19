package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.domain.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
