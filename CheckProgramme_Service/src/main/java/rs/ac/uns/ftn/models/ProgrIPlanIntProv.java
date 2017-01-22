package rs.ac.uns.ftn.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class ProgrIPlanIntProv implements Serializable {
	
	@Id
	private String id;
	private String datum;
	private String vrstaProvere;
	private int broj;
	private String poNaloguBr;
	private String datumOd;
	private String orgJedinica;
	private ArrayList<RedTabele> redoviTabele;	
	private String datumProvere;
	private String rokZaDosNalaza;
	
	public ProgrIPlanIntProv(String id, String datum, String vrstaProvere, int broj, String poNaloguBr, String datumOd,
			String orgJedinica, ArrayList<RedTabele> redoviTabele, String datumProvere, String rokZaDosNalaza) {
		super();
		this.id = id;
		this.datum = datum;
		this.vrstaProvere = vrstaProvere;
		this.broj = broj;
		this.poNaloguBr = poNaloguBr;
		this.datumOd = datumOd;
		this.orgJedinica = orgJedinica;
		this.redoviTabele = redoviTabele;
		this.datumProvere = datumProvere;
		this.rokZaDosNalaza = rokZaDosNalaza;
	}

	public ProgrIPlanIntProv() {

	}

	public ProgrIPlanIntProv(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getVrstaProvere() {
		return vrstaProvere;
	}

	public void setVrstaProvere(String vrstaProvere) {
		this.vrstaProvere = vrstaProvere;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public String getPoNaloguBr() {
		return poNaloguBr;
	}

	public void setPoNaloguBr(String poNaloguBr) {
		this.poNaloguBr = poNaloguBr;
	}

	public String getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}

	public String getOrgJedinica() {
		return orgJedinica;
	}

	public void setOrgJedinica(String orgJedinica) {
		this.orgJedinica = orgJedinica;
	}

	public ArrayList<RedTabele> getRedoviTabele() {
		return redoviTabele;
	}

	public void setRedoviTabele(ArrayList<RedTabele> redoviTabele) {
		this.redoviTabele = redoviTabele;
	}

	public String getDatumProvere() {
		return datumProvere;
	}

	public void setDatumProvere(String datumProvere) {
		this.datumProvere = datumProvere;
	}

	public String getRokZaDosNalaza() {
		return rokZaDosNalaza;
	}

	public void setRokZaDosNalaza(String rokZaDosNalaza) {
		this.rokZaDosNalaza = rokZaDosNalaza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + broj;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((datumOd == null) ? 0 : datumOd.hashCode());
		result = prime * result + ((datumProvere == null) ? 0 : datumProvere.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orgJedinica == null) ? 0 : orgJedinica.hashCode());
		result = prime * result + ((poNaloguBr == null) ? 0 : poNaloguBr.hashCode());
		result = prime * result + ((redoviTabele == null) ? 0 : redoviTabele.hashCode());
		result = prime * result + ((rokZaDosNalaza == null) ? 0 : rokZaDosNalaza.hashCode());
		result = prime * result + ((vrstaProvere == null) ? 0 : vrstaProvere.hashCode());
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
		ProgrIPlanIntProv other = (ProgrIPlanIntProv) obj;
		if (broj != other.broj)
			return false;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (datumOd == null) {
			if (other.datumOd != null)
				return false;
		} else if (!datumOd.equals(other.datumOd))
			return false;
		if (datumProvere == null) {
			if (other.datumProvere != null)
				return false;
		} else if (!datumProvere.equals(other.datumProvere))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orgJedinica == null) {
			if (other.orgJedinica != null)
				return false;
		} else if (!orgJedinica.equals(other.orgJedinica))
			return false;
		if (poNaloguBr == null) {
			if (other.poNaloguBr != null)
				return false;
		} else if (!poNaloguBr.equals(other.poNaloguBr))
			return false;
		if (redoviTabele == null) {
			if (other.redoviTabele != null)
				return false;
		} else if (!redoviTabele.equals(other.redoviTabele))
			return false;
		if (rokZaDosNalaza == null) {
			if (other.rokZaDosNalaza != null)
				return false;
		} else if (!rokZaDosNalaza.equals(other.rokZaDosNalaza))
			return false;
		if (vrstaProvere == null) {
			if (other.vrstaProvere != null)
				return false;
		} else if (!vrstaProvere.equals(other.vrstaProvere))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProgrIPlanIntProv [id=" + id + ", datum=" + datum + ", vrstaProvere=" + vrstaProvere + ", broj=" + broj
				+ ", poNaloguBr=" + poNaloguBr + ", datumOd=" + datumOd + ", orgJedinica=" + orgJedinica
				+ ", redoviTabele=" + redoviTabele + ", datumProvere=" + datumProvere + ", rokZaDosNalaza="
				+ rokZaDosNalaza + "]";
	}
	

}
