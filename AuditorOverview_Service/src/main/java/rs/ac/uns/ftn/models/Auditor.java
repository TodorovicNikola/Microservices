package rs.ac.uns.ftn.models;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class Auditor implements Serializable {
	private String imeIPrezime;
	private String oblast;
	
	public Auditor() {
		super();
	}
	
	public Auditor(String imeIPrezime, String oblast) {
		super();
		this.imeIPrezime = imeIPrezime;
		this.oblast = oblast;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}
	
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	
	public String getOblast() {
		return oblast;
	}
	
	public void setOblast(String oblast) {
		this.oblast = oblast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imeIPrezime == null) ? 0 : imeIPrezime.hashCode());
		result = prime * result + ((oblast == null) ? 0 : oblast.hashCode());
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
		Auditor other = (Auditor) obj;
		if (imeIPrezime == null) {
			if (other.imeIPrezime != null)
				return false;
		} else if (!imeIPrezime.equals(other.imeIPrezime))
			return false;
		if (oblast == null) {
			if (other.oblast != null)
				return false;
		} else if (!oblast.equals(other.oblast))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auditor [imeIPrezime=" + imeIPrezime + ", oblast=" + oblast + "]";
	}
	
	
}
