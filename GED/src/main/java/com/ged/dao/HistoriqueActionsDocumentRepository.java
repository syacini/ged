package com.ged.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ged.domain.HistoriqueActionsDocument;
import com.ged.domain.HistoriqueActionsDocumentPK;

public interface HistoriqueActionsDocumentRepository
		extends JpaRepository<HistoriqueActionsDocument, HistoriqueActionsDocumentPK> {

}
