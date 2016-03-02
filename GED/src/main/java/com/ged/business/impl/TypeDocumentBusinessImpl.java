package com.ged.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.ged.business.ITypeDocumentBusiness;
import com.ged.dao.TypeDocumentRepository;
import com.ged.domain.TypeDocument;

public class TypeDocumentBusinessImpl implements ITypeDocumentBusiness {

	@Autowired
	private TypeDocumentRepository tdRepository;

	@Override
	public TypeDocument creerTypeDocument(TypeDocument typeDocument) {
		return tdRepository.saveAndFlush(typeDocument);
	}

	@Override
	public Collection<TypeDocument> getAllTypesDocuments() {
		return tdRepository.findAll();
	}

	@Override
	public TypeDocument getTypeDocumentById(Integer id) {
		return tdRepository.findOne(id);
	}

	@Override
	public TypeDocument majTypeDocument(TypeDocument typeDocument) {
		return creerTypeDocument(typeDocument);
	}

	@Override
	public void supprimerTypeDocument(TypeDocument typeDocument) {
		typeDocument.setActif(false);
		for (TypeDocument td : typeDocument.getTypesDocumentsEnfants()) {
			supprimerTypeDocument(td);
		}
	}

	@Override
	public void restaurerTypeDocument(TypeDocument typeDocument) {
		typeDocument.setActif(true);
		for (TypeDocument td : typeDocument.getTypesDocumentsEnfants()) {
			restaurerTypeDocument(td);
		}
	}

}
