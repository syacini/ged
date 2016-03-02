package com.ged.business;

import java.util.Collection;

import com.ged.domain.Bibliotheque;
import com.ged.domain.Conteneur;
import com.ged.domain.Document;
import com.ged.domain.TypeDocument;

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
