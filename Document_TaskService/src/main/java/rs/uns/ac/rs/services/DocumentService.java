package rs.uns.ac.rs.services;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rs.uns.ac.rs.models.DocumentEntity;
import rs.uns.ac.rs.repositories.DocumentRepository;



@Service
public class DocumentService extends AbstractCRUDService<DocumentEntity, String>{

	private DocumentRepository documentRepository;
	private RestTemplate restTemplate;

	@Autowired
	public DocumentService(DocumentRepository documentRepository,RestTemplate restTemplate){
		super(documentRepository);
		this.documentRepository = documentRepository;
		this.restTemplate=restTemplate;
	}
	
	public DocumentEntity createDocument(DocumentEntity document)
	{
		document.setTaskDate(new Date());
		save(document);
		return document;
		
	}
	
	public Boolean isDocumentOk(DocumentEntity document)
	{
		if (document.getTaskDueDate()==null)
			return true;
		System.out.println(document);
		if ((new Date()).compareTo(document.getTaskDueDate())>0)
		{
			return false;
		}
		return true;
	}
	public List<DocumentEntity> getAll()
	{
		return documentRepository.findAll();
	}
	
	public List<DocumentEntity> getAllFinished()
	{
		return documentRepository.findByStatus("zavrsen");
	}
	
	public Boolean checkUserHasPermission(String firstName,String lastName)
	{
	
			CommunicationService<Boolean> c = new CommunicationService<>(Boolean.class, restTemplate);		
			String remoteUrl="http://localhost:8085/user-service/checkUserRole?firstName="+firstName+"&lastName="+lastName+"&role=Predstavnik"; 	
			System.out.println(remoteUrl);
			Boolean userAllowed = c.getS(remoteUrl);	
			return userAllowed;
			
	
	}
	
	public  List<DocumentEntity> findDocumentForUser(String firstName,String lastName)
	{
		ArrayList<DocumentEntity> newList = new ArrayList<DocumentEntity>();
		newList.addAll(documentRepository.findByTaskCreatedBy(firstName+" "+lastName));
		newList.addAll(documentRepository.findByTaskCreatedBy(lastName+" "+firstName));
		System.out.println(newList.size() + " velicina liste");
		return newList;
	}

	public DocumentEntity updateDoc(DocumentEntity doc,String documentId)
	{
		DocumentEntity document=findOne(documentId);
		//
		if (!document.getId().equals(documentId) || document.getStatus()==null || document.getStatus().equals("zavrsen"))
		{
			return null;
		}
		else
		{
			update(documentId, doc);
			return doc;
		}
		
	}
	



}