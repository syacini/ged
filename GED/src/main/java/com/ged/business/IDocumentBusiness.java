package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.Bibliotheque;
import com.ged.domain.tenant.Conteneur;
import com.ged.domain.tenant.Document;
import com.ged.domain.tenant.TypeDocument;

public interface IDocumentBusiness {

	public Document creerDocument(Document document);

	public Collection<Document> getAllDocuments();

	public Collection<Document> getDocumentsByConteneur(Conteneur conteneur);

	public Collection<Document> getDocumentsByType(TypeDocument typeDocument);

	public Collection<Document> getDocumentsByBibliotheque(Bibliotheque bibliotheque);

	public Document getDocumentById(Integer id);

	public Document majDocument(Document document);

	public void supprimerDocument(Document document);
	
	public void restaurerDocument(Document document);

}
