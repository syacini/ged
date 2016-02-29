package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.TypeDocument;

@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Integer> {

}
