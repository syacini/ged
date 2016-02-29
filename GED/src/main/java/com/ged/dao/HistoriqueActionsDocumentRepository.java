package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.HistoriqueActionsDocument;
import com.ged.domain.HistoriqueActionsDocumentPK;

@Repository
public interface HistoriqueActionsDocumentRepository
		extends JpaRepository<HistoriqueActionsDocument, HistoriqueActionsDocumentPK> {

}
