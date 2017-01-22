package rs.uns.ac.rs.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Document
public class DocumentQualityEntity implements Serializable{
		
		@Id
		private String id;
		@Indexed
		private String docMark;
		private Date docDate;
		private List<DocumentItem> docItems;
		private String userId;
		
		
		
		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}


		public DocumentQualityEntity()
		{
			
		}
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDocMark() {
			return docMark;
		}
		public void setDocMark(String docMark) {
			this.docMark = docMark;
		}
		public Date getDocDate() {
			return docDate;
		}
		public void setDocDate(Date docDate) {
			this.docDate = docDate;
		}
		public List<DocumentItem> getDocItems() {
			return docItems;
		}
		public void setDocItems(List<DocumentItem> docItems) {
			this.docItems = docItems;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((docDate == null) ? 0 : docDate.hashCode());
			result = prime * result + ((docItems == null) ? 0 : docItems.hashCode());
			result = prime * result + ((docMark == null) ? 0 : docMark.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DocumentQualityEntity other = (DocumentQualityEntity) obj;
			if (docDate == null) {
				if (other.docDate != null)
					return false;
			} else if (!docDate.equals(other.docDate))
				return false;
			if (docItems == null) {
				if (other.docItems != null)
					return false;
			} else if (!docItems.equals(other.docItems))
				return false;
			if (docMark == null) {
				if (other.docMark != null)
					return false;
			} else if (!docMark.equals(other.docMark))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "DocumentQualityEntity [id=" + id + ", docMark=" + docMark + ", docDate=" + docDate + ", docItems="
					+ docItems + "]";
		}
		
		
		
	
		
		
	

}
