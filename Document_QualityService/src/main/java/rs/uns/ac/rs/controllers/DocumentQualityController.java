package rs.uns.ac.rs.controllers;

import java.util.Iterator;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import rs.uns.ac.rs.models.DocumentQualityEntity;
import rs.uns.ac.rs.services.DocumentService;


@RestController
public class DocumentQualityController extends AbstractRESTController<DocumentQualityEntity, String>{
	
	@Autowired
	Environment environment;
	
	private DocumentService documentService;
	

	@Autowired
	public DocumentQualityController(DocumentService documentService) {
		super(documentService);
		this.documentService=documentService;
	}
	
	@RequestMapping(value="/createDocument",method=RequestMethod.POST )
	public DocumentQualityEntity createDocument(@RequestBody @Valid DocumentQualityEntity  document,@RequestHeader("Authorization") String token)
	{
		Boolean userOk=documentService.checkUserHasPermissionToCreate(token,document.getUserId());
		Boolean documentOk=documentService.isDocumentOk(document);
		if (documentOk && userOk)
		{
			documentService.setItemsId(document);
		}
		return documentService.createDocument(document);
		
	}
	
	@RequestMapping(value="/documents")
	public List<DocumentQualityEntity> getDocuments()
	{
			return documentService.getAll();
	
	}
	@RequestMapping(value="/documents/{documentId}")
	public DocumentQualityEntity getSingleDocument(@PathVariable("documentId") String documentId)
	{
			return documentService.findOne(documentId);
	
	}
	
	@RequestMapping(value="/documents/{documentId}",method=RequestMethod.DELETE)
	public Boolean deleteDocument(@PathVariable("documentId") String documentId)
	{
		return documentService.delete(documentId);
	}
	
	@RequestMapping(value="/documents/{documentId}",method=RequestMethod.PUT)
	public @ResponseBody Object updateDoc(@RequestBody DocumentQualityEntity document,@PathVariable("documentId") String documentId,@RequestHeader("Authorization") String token)
	{
		Boolean userOk=documentService.checkUserHasPermissionToUpdate(token,document.getUserId());
		Boolean documentOk=documentService.isDocumentOk(document);
		if (documentOk && userOk)
		{		
			documentService.setItemsId(document);
			return documentService.updateDoc(document, documentId);
		}
		return null;
	}
	

	
}