package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
