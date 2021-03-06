package com.ged.business.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ged.business.IDocumentBusiness;
import com.ged.dao.tenant.DocumentRepository;
import com.ged.domain.tenant.Bibliotheque;
import com.ged.domain.tenant.Conteneur;
import com.ged.domain.tenant.Document;
import com.ged.domain.tenant.TypeDocument;

@Service
public class DocumentBusinessImpl implements IDocumentBusiness {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Document creerDocument(Document document) {
		return documentRepository.saveAndFlush(document);
	}

	@Override
	public Collection<Document> getAllDocuments() {
		return documentRepository.findAll();
	}

	@Override
	public Collection<Document> getDocumentsByConteneur(Conteneur conteneur) {
		return conteneur.getDocuments();
	}

	@Override
	public Collection<Document> getDocumentsByType(TypeDocument typeDocument) {
		return documentRepository.getDocumentsByType(typeDocument);
	}

	@Override
	public Collection<Document> getDocumentsByBibliotheque(Bibliotheque bibliotheque) {
		Collection<Conteneur> conteneurs = bibliotheque.getConteneurs();
		Collection<Document> documents = new ArrayList<Document>();
		for (Conteneur c : conteneurs) {
			documents.addAll(c.getDocuments());
		}
		return documents;
	}

	@Override
	public Document getDocumentById(Integer id) {
		return documentRepository.findOne(id);
	}

	@Override
	public Document majDocument(Document document) {
		return creerDocument(document);
	}

	@Override
	public void supprimerDocument(Document document) {
		document.setActif(false);
	}

	@Override
	public void restaurerDocument(Document document) {
		document.setActif(true);
	}
}
