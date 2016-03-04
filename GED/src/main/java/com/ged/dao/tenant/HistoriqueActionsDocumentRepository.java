package com.ged.dao.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ged.domain.tenant.HistoriqueActionsDocument;
import com.ged.domain.tenant.HistoriqueActionsDocumentPK;

@Repository
public interface HistoriqueActionsDocumentRepository
		extends JpaRepository<HistoriqueActionsDocument, HistoriqueActionsDocumentPK> {

}
