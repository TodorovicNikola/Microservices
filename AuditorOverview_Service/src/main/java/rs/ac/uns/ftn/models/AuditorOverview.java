package rs.ac.uns.ftn.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class AuditorOverview implements Serializable{
	
	@Id
	private String id;
	private List<Auditor> auditors;
	
	public AuditorOverview() {
		super();
	}
		
	public AuditorOverview(String id) {
		super();
		this.id = id;
	}

	public AuditorOverview(String id, List<Auditor> auditors) {
		super();
		this.id = id;
		this.auditors = auditors;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public List<Auditor> getAuditors() {
		return auditors;
	}

	public void setAuditors(List<Auditor> auditors) {
		this.auditors = auditors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditors == null) ? 0 : auditors.hashCode());
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
		AuditorOverview other = (AuditorOverview) obj;
		if (auditors == null) {
			if (other.auditors != null)
				return false;
		} else if (!auditors.equals(other.auditors))
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
		return "AuditorOverview [id=" + id + ", auditors=" + auditors + "]";
	}

}
