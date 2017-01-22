package rs.ac.uns.ftn.models;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class ClanTimaZaProveru implements Serializable{
	
	private String imeIPrezime;
	private String Funkcija;
	
	public ClanTimaZaProveru() {
		super();
	}

	public ClanTimaZaProveru(String imeIPrezime, String funkcija) {
		super();
		this.imeIPrezime = imeIPrezime;
		Funkcija = funkcija;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public String getFunkcija() {
		return Funkcija;
	}

	public void setFunkcija(String funkcija) {
		Funkcija = funkcija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Funkcija == null) ? 0 : Funkcija.hashCode());
		result = prime * result + ((imeIPrezime == null) ? 0 : imeIPrezime.hashCode());
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
		ClanTimaZaProveru other = (ClanTimaZaProveru) obj;
		if (Funkcija == null) {
			if (other.Funkcija != null)
				return false;
		} else if (!Funkcija.equals(other.Funkcija))
			return false;
		if (imeIPrezime == null) {
			if (other.imeIPrezime != null)
				return false;
		} else if (!imeIPrezime.equals(other.imeIPrezime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClanTimaZaProveru [imeIPrezime=" + imeIPrezime + ", Funkcija=" + Funkcija + "]";
	}
	
}
