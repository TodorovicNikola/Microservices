package rs.ac.uns.ftn.models;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class RedTabele implements Serializable{

	private String progProv;
	private String potrPris;
	private String prov;
	private String vremeOd;
	private String vremeDo;
	
	public RedTabele() {
		super();
	}
	
	public RedTabele(String progProv, String potrPris, String prov, String vremeOd, String vremeDo) {
		super();
		this.progProv = progProv;
		this.potrPris = potrPris;
		this.prov = prov;
		this.vremeOd = vremeOd;
		this.vremeDo = vremeDo;
	}

	public String getProgProv() {
		return progProv;
	}
	public void setProgProv(String progProv) {
		this.progProv = progProv;
	}
	public String getPotrPris() {
		return potrPris;
	}
	public void setPotrPris(String potrPris) {
		this.potrPris = potrPris;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getVremeOd() {
		return vremeOd;
	}
	public void setVremeOd(String vremeOd) {
		this.vremeOd = vremeOd;
	}
	public String getVremeDo() {
		return vremeDo;
	}
	public void setVremeDo(String vremeDo) {
		this.vremeDo = vremeDo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((potrPris == null) ? 0 : potrPris.hashCode());
		result = prime * result + ((progProv == null) ? 0 : progProv.hashCode());
		result = prime * result + ((prov == null) ? 0 : prov.hashCode());
		result = prime * result + ((vremeDo == null) ? 0 : vremeDo.hashCode());
		result = prime * result + ((vremeOd == null) ? 0 : vremeOd.hashCode());
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
		RedTabele other = (RedTabele) obj;
		if (potrPris == null) {
			if (other.potrPris != null)
				return false;
		} else if (!potrPris.equals(other.potrPris))
			return false;
		if (progProv == null) {
			if (other.progProv != null)
				return false;
		} else if (!progProv.equals(other.progProv))
			return false;
		if (prov == null) {
			if (other.prov != null)
				return false;
		} else if (!prov.equals(other.prov))
			return false;
		if (vremeDo == null) {
			if (other.vremeDo != null)
				return false;
		} else if (!vremeDo.equals(other.vremeDo))
			return false;
		if (vremeOd == null) {
			if (other.vremeOd != null)
				return false;
		} else if (!vremeOd.equals(other.vremeOd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RedTabele [progProv=" + progProv + ", potrPris=" + potrPris + ", prov=" + prov + ", vremeOd=" + vremeOd
				+ ", vremeDo=" + vremeDo + "]";
	}
	
	
	
}
