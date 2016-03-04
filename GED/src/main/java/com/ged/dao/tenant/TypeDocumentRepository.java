package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.TypeDocument;

@Repository
public interface TypeDocumentRepository extends JpaRepository<TypeDocument, Integer> {

}
