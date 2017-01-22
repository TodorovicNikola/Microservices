package rs.uns.ac.rs.services;


import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rs.uns.ac.rs.models.DocumentItem;
import rs.uns.ac.rs.models.DocumentQualityEntity;
import rs.uns.ac.rs.repositories.DocumentRepository;



@Service
public class DocumentService extends AbstractCRUDService<DocumentQualityEntity, String>{

	private DocumentRepository documentRepository;
	private RestTemplate restTemplate;

	@Autowired
	public DocumentService(DocumentRepository documentRepository,RestTemplate restTemplate){
		super(documentRepository);
		this.documentRepository = documentRepository;
		this.restTemplate=restTemplate;
	}
	
	public DocumentQualityEntity createDocument(DocumentQualityEntity document)
	{
		//document.setTaskDate(new Date());
		
		save(document);
		return document;
		
	}
	
	public Boolean isDocumentOk(DocumentQualityEntity document)
	{
		if (document.getDocDate()==null)
		{
			return false;
		}
		if (document.getDocMark()==null)
		{
			return false;
		}
		if (document.getDocItems().size()==0)
		{
			return false;
		}
		return true;
	}
	
	
	public void setItemsId(DocumentQualityEntity document)
	{
		Random rnd=new Random();
		Iterator<DocumentItem> iterators= document.getDocItems().iterator();
		while(iterators.hasNext())
		{
			DocumentItem doc=iterators.next();
			if (doc==null)
			{
				iterators.remove();
						
			}
			else{
				doc.setId(String.valueOf(rnd.nextLong()));
			}
		}
		
	}
	
	public List<DocumentQualityEntity> getAll()
	{
		return documentRepository.findAll();
	}
	
	public Boolean checkUserHasPermissionToUpdate(String token,String id)
	{
	
			CommunicationService<Boolean> c = new CommunicationService<>(Boolean.class, restTemplate);		
			String remoteUrl="http://localhost:8085/user-service/checkUserIdFromToken?token="+token+"&id="+id;
			
			Boolean userAllowed = c.getS(remoteUrl);	
			return userAllowed;	
			
	
	}
	public Boolean checkUserHasPermissionToCreate(String token,String documentUserId)
	{
		CommunicationService<Boolean> c = new CommunicationService<>(Boolean.class, restTemplate);		
		String remoteUrl="http://localhost:8085/user-service/checkUserRoleByToken?role=Sekretar&token="+token+"&documentUserId="+documentUserId; 	
		Boolean userAllowed = c.getS(remoteUrl);
		return userAllowed;	
		
	}

	public DocumentQualityEntity updateDoc(DocumentQualityEntity doc,String documentId)
	{
		DocumentQualityEntity document=findOne(documentId);
		//document.getStatus()==null || document.getStatus().equals("zavrsen") || 
		if (!document.getId().equals(documentId))
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