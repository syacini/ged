package com.ged.business;

import java.util.Collection;

import com.ged.domain.tenant.TypeDocument;

public interface ITypeDocumentBusiness {

	public TypeDocument creerTypeDocument(TypeDocument typeDocument);

	public Collection<TypeDocument> getAllTypesDocuments();

	public TypeDocument getTypeDocumentById(Integer id);

	public TypeDocument majTypeDocument(TypeDocument typeDocument);

	public void supprimerTypeDocument(TypeDocument typeDocument);

	public void restaurerTypeDocument(TypeDocument typeDocument);

}
