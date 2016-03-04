package com.ged.dao.tenant;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.Document;
import com.ged.domain.tenant.TypeDocument;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

	@Query("SELECT d FROM Document d WHERE d.typeDocument = :t")
	public Collection<Document> getDocumentsByType(@Param("t") TypeDocument typeDocument);
}
