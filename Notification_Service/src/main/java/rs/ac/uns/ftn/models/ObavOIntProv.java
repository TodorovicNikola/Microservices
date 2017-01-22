package rs.ac.uns.ftn.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document
public class ObavOIntProv implements Serializable {

	@Id
	private String id;
	private String oznaka;
	private String datum;
	private String vrstaProvere;
	private String poZahtevuBr;
	private String orgJedinica;
	private String nadlezniRuk;
	private String datumOd;
	private String datumDo;
	private String zahtDok;
	private List<ClanTimaZaProveru> timZaProveru;
	private List<String> komentari;
	private Boolean verifikovan;
	
	public ObavOIntProv() {
		super();
	}

	public ObavOIntProv(String id, String oznaka, String datum, String vrstaProvere, String poZahtevuBr,
			String orgJedinica, String nadlezniRuk, String datumOd, String datumDo, String zahtDok,
			List<ClanTimaZaProveru> timZaProveru, List<String> komentari, Boolean verifikovan) {
		super();
		this.id = id;
		this.oznaka = oznaka;
		this.datum = datum;
		this.vrstaProvere = vrstaProvere;
		this.poZahtevuBr = poZahtevuBr;
		this.orgJedinica = orgJedinica;
		this.nadlezniRuk = nadlezniRuk;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.zahtDok = zahtDok;
		this.timZaProveru = timZaProveru;
		this.komentari = komentari;
		this.verifikovan = verifikovan;
	}

	public ObavOIntProv(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
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

	public String getPoZahtevuBr() {
		return poZahtevuBr;
	}

	public void setPoZahtevuBr(String poZahtevuBr) {
		this.poZahtevuBr = poZahtevuBr;
	}

	public String getOrgJedinica() {
		return orgJedinica;
	}

	public void setOrgJedinica(String orgJedinica) {
		this.orgJedinica = orgJedinica;
	}

	public String getNadlezniRuk() {
		return nadlezniRuk;
	}

	public void setNadlezniRuk(String nadlezniRuk) {
		this.nadlezniRuk = nadlezniRuk;
	}

	public String getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(String datumOd) {
		this.datumOd = datumOd;
	}

	public String getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(String datumDo) {
		this.datumDo = datumDo;
	}

	public String getZahtDok() {
		return zahtDok;
	}

	public void setZahtDok(String zahtDok) {
		this.zahtDok = zahtDok;
	}

	public List<ClanTimaZaProveru> getTimZaProveru() {
		return timZaProveru;
	}

	public void setTimZaProveru(List<ClanTimaZaProveru> timZaProveru) {
		this.timZaProveru = timZaProveru;
	}

	public List<String> getKomentari() {
		return komentari;
	}

	public void setKomentari(List<String> komentari) {
		this.komentari = komentari;
	}

	public Boolean getVerifikovan() {
		return verifikovan;
	}

	public void setVerifikovan(Boolean verifikovan) {
		this.verifikovan = verifikovan;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((datumDo == null) ? 0 : datumDo.hashCode());
		result = prime * result + ((datumOd == null) ? 0 : datumOd.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((komentari == null) ? 0 : komentari.hashCode());
		result = prime * result + ((nadlezniRuk == null) ? 0 : nadlezniRuk.hashCode());
		result = prime * result + ((orgJedinica == null) ? 0 : orgJedinica.hashCode());
		result = prime * result + ((oznaka == null) ? 0 : oznaka.hashCode());
		result = prime * result + ((poZahtevuBr == null) ? 0 : poZahtevuBr.hashCode());
		result = prime * result + ((timZaProveru == null) ? 0 : timZaProveru.hashCode());
		result = prime * result + ((verifikovan == null) ? 0 : verifikovan.hashCode());
		result = prime * result + ((vrstaProvere == null) ? 0 : vrstaProvere.hashCode());
		result = prime * result + ((zahtDok == null) ? 0 : zahtDok.hashCode());
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
		ObavOIntProv other = (ObavOIntProv) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (datumDo == null) {
			if (other.datumDo != null)
				return false;
		} else if (!datumDo.equals(other.datumDo))
			return false;
		if (datumOd == null) {
			if (other.datumOd != null)
				return false;
		} else if (!datumOd.equals(other.datumOd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (komentari == null) {
			if (other.komentari != null)
				return false;
		} else if (!komentari.equals(other.komentari))
			return false;
		if (nadlezniRuk == null) {
			if (other.nadlezniRuk != null)
				return false;
		} else if (!nadlezniRuk.equals(other.nadlezniRuk))
			return false;
		if (orgJedinica == null) {
			if (other.orgJedinica != null)
				return false;
		} else if (!orgJedinica.equals(other.orgJedinica))
			return false;
		if (oznaka == null) {
			if (other.oznaka != null)
				return false;
		} else if (!oznaka.equals(other.oznaka))
			return false;
		if (poZahtevuBr == null) {
			if (other.poZahtevuBr != null)
				return false;
		} else if (!poZahtevuBr.equals(other.poZahtevuBr))
			return false;
		if (timZaProveru == null) {
			if (other.timZaProveru != null)
				return false;
		} else if (!timZaProveru.equals(other.timZaProveru))
			return false;
		if (verifikovan == null) {
			if (other.verifikovan != null)
				return false;
		} else if (!verifikovan.equals(other.verifikovan))
			return false;
		if (vrstaProvere == null) {
			if (other.vrstaProvere != null)
				return false;
		} else if (!vrstaProvere.equals(other.vrstaProvere))
			return false;
		if (zahtDok == null) {
			if (other.zahtDok != null)
				return false;
		} else if (!zahtDok.equals(other.zahtDok))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObavOIntProv [id=" + id + ", oznaka=" + oznaka + ", datum=" + datum + ", vrstaProvere=" + vrstaProvere
				+ ", poZahtevuBr=" + poZahtevuBr + ", orgJedinica=" + orgJedinica + ", nadlezniRuk=" + nadlezniRuk
				+ ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", zahtDok=" + zahtDok + ", timZaProveru="
				+ timZaProveru + ", komentari=" + komentari + ", verifikovan=" + verifikovan + "]";
	}

}
