package rs.uns.ac.rs.controllers;

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


import rs.uns.ac.rs.models.DocumentEntity;
import rs.uns.ac.rs.services.DocumentService;


@RestController
public class DocumentTaskController extends AbstractRESTController<DocumentEntity, String>{
	
	@Autowired
	Environment environment;
	
	private DocumentService documentService;
	

	@Autowired
	public DocumentTaskController(DocumentService documentService) {
		super(documentService);
		this.documentService=documentService;
	}
	
	@RequestMapping(value="/createDocument",method=RequestMethod.POST )
	public DocumentEntity createDocument(@RequestBody @Valid DocumentEntity  document)
	{
		boolean documentOk=documentService.isDocumentOk(document);
		String firstName=document.getTaskCreatedBy().split(" ")[0];
		String lastName=document.getTaskCreatedBy().split(" ")[1];
		Boolean userHasPermission=documentService.checkUserHasPermission(firstName, lastName);
		if (documentOk && userHasPermission) 
		{
			return documentService.createDocument(document);
		}
		return null;
		
	}
	
	@RequestMapping(value="/documents")
	public List<DocumentEntity> getDocuments(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("role") String role)
	{
		if(role.equals("Predstavnik"))
		{
			
			return documentService.findDocumentForUser(firstName, lastName);
		}
		else
		{
			return documentService.getAllFinished();
		}
			
	
	}
	@RequestMapping(value="/documents/{documentId}")
	public DocumentEntity getSingleDocument(@PathVariable("documentId") String documentId)
	{
			return documentService.findOne(documentId);
	
	}
	
	@RequestMapping(value="/documents/{documentId}",method=RequestMethod.DELETE)
	public Boolean deleteDocument(@PathVariable("documentId") String documentId)
	{
		return documentService.delete(documentId);
	}
	
	@RequestMapping(value="/documents/{documentId}",method=RequestMethod.PUT)
	public @ResponseBody Object updateDoc(@RequestBody DocumentEntity document,@PathVariable("documentId") String documentId)
	{
		System.out.println("update " + documentId);
		return documentService.updateDoc(document, documentId);
	}
	

	
}