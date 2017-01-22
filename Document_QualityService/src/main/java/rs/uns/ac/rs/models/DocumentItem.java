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
public class DocumentItem implements Serializable{
		
		@Id
		private String id;
		@Indexed
		private String itemMark;
		private String itemTitle;
		private Integer itemRelease;
		private Date itemDate;
		private String itemUsers;
		
		
		public DocumentItem()
		{
			
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getItemMark() {
			return itemMark;
		}
		public void setItemMark(String itemMark) {
			this.itemMark = itemMark;
		}
		public String getItemTitle() {
			return itemTitle;
		}
		public void setItemTitle(String itemTitle) {
			this.itemTitle = itemTitle;
		}
		public Integer getItemRelease() {
			return itemRelease;
		}
		public void setItemRelease(Integer itemRelease) {
			this.itemRelease = itemRelease;
		}
		public Date getItemDate() {
			return itemDate;
		}
		public void setItemDate(Date itemDate) {
			this.itemDate = itemDate;
		}
		public String getItemUsers() {
			return itemUsers;
		}
		public void setItemUsers(String itemUsers) {
			this.itemUsers = itemUsers;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((itemDate == null) ? 0 : itemDate.hashCode());
			result = prime * result + ((itemMark == null) ? 0 : itemMark.hashCode());
			result = prime * result + ((itemRelease == null) ? 0 : itemRelease.hashCode());
			result = prime * result + ((itemTitle == null) ? 0 : itemTitle.hashCode());
			result = prime * result + ((itemUsers == null) ? 0 : itemUsers.hashCode());
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
			DocumentItem other = (DocumentItem) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (itemDate == null) {
				if (other.itemDate != null)
					return false;
			} else if (!itemDate.equals(other.itemDate))
				return false;
			if (itemMark == null) {
				if (other.itemMark != null)
					return false;
			} else if (!itemMark.equals(other.itemMark))
				return false;
			if (itemRelease == null) {
				if (other.itemRelease != null)
					return false;
			} else if (!itemRelease.equals(other.itemRelease))
				return false;
			if (itemTitle == null) {
				if (other.itemTitle != null)
					return false;
			} else if (!itemTitle.equals(other.itemTitle))
				return false;
			if (itemUsers == null) {
				if (other.itemUsers != null)
					return false;
			} else if (!itemUsers.equals(other.itemUsers))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "DocumentItem [id=" + id + ", itemMark=" + itemMark + ", itemTitle=" + itemTitle + ", itemRelease="
					+ itemRelease + ", itemDate=" + itemDate + ", itemUsers=" + itemUsers + "]";
		}
		public DocumentItem(String id, String itemMark, String itemTitle, Integer itemRelease, Date itemDate,
				String itemUsers) {
			super();
			this.id = id;
			this.itemMark = itemMark;
			this.itemTitle = itemTitle;
			this.itemRelease = itemRelease;
			this.itemDate = itemDate;
			this.itemUsers = itemUsers;
		}
		
		
	

}
