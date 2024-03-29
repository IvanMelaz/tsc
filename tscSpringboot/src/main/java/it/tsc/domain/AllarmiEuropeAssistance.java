package it.tsc.domain;
/**
 *
 */

import com.google.gson.annotations.Expose;
import it.tsc.domain.types.FasciaOraria;
import it.tsc.domain.types.SpecializzazioneMedico;
import it.tsc.domain.types.TipologiaConsulenza;
import it.tsc.domain.types.TipologiaServizio;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author astraservice POJO class for allarm
 */
@Entity
@Table(name = "tsc_europe")
@NamedQueries(value = {
		@NamedQuery(name = AllarmiEuropeAssistance.SELECT_ALLARM_EA, query = "SELECT a FROM AllarmiEuropeAssistance a ORDER BY a.dataArrivo DESC")})
public class AllarmiEuropeAssistance extends BaseDomain {
	/**
	 *
	 */
	private static final long serialVersionUID = 1338024278631839150L;
	public static final String SELECT_ALLARM_EA = "select.allarm.ea";

	@Id
	@Column
	@Expose
	private String id_allarme;

	@Column
	@Expose
	private String ab_codi;

	@Column(name = "data_richiesta")
	@Temporal(value = TemporalType.TIMESTAMP)
	@Expose
	private Date dataRichiesta;

	@Column(name = "data_arrivo")
	@Temporal(value = TemporalType.TIMESTAMP)
	@Expose
	private Date dataArrivo;

	@Column
	@Expose
	private String nomeCliente;

	@Column
	@Expose
	private String cognomeCliente;

	@Column
	@Expose
	private String numeroTelefono1;

	@Column
	@Expose
	private String numeroTelefono2;

	@Column
	@Expose
	private String email;

	@Column
	@Expose
	private String indirizzo;

	@Column
	@Expose
	private String numeroOrdine;

	@Column
	@Expose
	private String numeroDossier;

	@Column
	@Expose
	private String codiceBP;

	@Enumerated(EnumType.STRING)
	@Column
	@Expose
	private TipologiaServizio tipologiaServizio;

	@Enumerated(EnumType.STRING)
	@Column
	@Expose
	private TipologiaConsulenza tipologiaConsulenza;

	@Enumerated(EnumType.STRING)
	@Column
	@Expose
	private SpecializzazioneMedico specializzazioneMedico;

	@Column
	@Expose
	private String quesitoMedico;

	@Enumerated(EnumType.STRING)
	@Column
	@Expose
	private FasciaOraria fasciaOraria;

	@Column
	@Expose
	private String linkMyClinic;

	@Column
	@Expose
	private boolean test;

	public String getId_allarme() {
		return id_allarme;
	}

	public void setId_allarme(String id_allarme) {
		this.id_allarme = id_allarme;
	}

	public String getAb_codi() {
		return ab_codi;
	}

	public void setAb_codi(String ab_codi) {
		this.ab_codi = ab_codi;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getNumeroTelefono1() {
		return numeroTelefono1;
	}

	public void setNumeroTelefono1(String numeroTelefono1) {
		this.numeroTelefono1 = numeroTelefono1;
	}

	public String getNumeroTelefono2() {
		return numeroTelefono2;
	}

	public void setNumeroTelefono2(String numeroTelefono2) {
		this.numeroTelefono2 = numeroTelefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(String numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getCodiceBP() {
		return codiceBP;
	}

	public void setCodiceBP(String codiceBP) {
		this.codiceBP = codiceBP;
	}

	public TipologiaServizio getTipologiaServizio() {
		return tipologiaServizio;
	}

	public void setTipologiaServizio(TipologiaServizio tipologiaServizio) {
		this.tipologiaServizio = tipologiaServizio;
	}

	public TipologiaConsulenza getTipologiaConsulenza() {
		return tipologiaConsulenza;
	}

	public void setTipologiaConsulenza(
			TipologiaConsulenza tipologiaConsulenza) {
		this.tipologiaConsulenza = tipologiaConsulenza;
	}

	public SpecializzazioneMedico getSpecializzazioneMedico() {
		return specializzazioneMedico;
	}

	public void setSpecializzazioneMedico(
			SpecializzazioneMedico specializzazioneMedico) {
		this.specializzazioneMedico = specializzazioneMedico;
	}

	public String getQuesitoMedico() {
		return quesitoMedico;
	}

	public void setQuesitoMedico(String quesitoMedico) {
		this.quesitoMedico = quesitoMedico;
	}

	public FasciaOraria getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(FasciaOraria fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public String getLinkMyClinic() {
		return linkMyClinic;
	}

	public void setLinkMyClinic(String linkMyClinic) {
		this.linkMyClinic = linkMyClinic;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AllarmiEuropeAssistance)) return false;
		AllarmiEuropeAssistance that = (AllarmiEuropeAssistance) o;
		return isTest() == that.isTest() && getId_allarme().equals(that.getId_allarme()) && getAb_codi().equals(that.getAb_codi()) && getDataRichiesta().equals(that.getDataRichiesta()) && getDataArrivo().equals(that.getDataArrivo()) && getNomeCliente().equals(that.getNomeCliente()) && getCognomeCliente().equals(that.getCognomeCliente()) && getNumeroTelefono1().equals(that.getNumeroTelefono1()) && getNumeroTelefono2().equals(that.getNumeroTelefono2()) && getEmail().equals(that.getEmail()) && getIndirizzo().equals(that.getIndirizzo()) && getNumeroOrdine().equals(that.getNumeroOrdine()) && getNumeroDossier().equals(that.getNumeroDossier()) && getCodiceBP().equals(that.getCodiceBP()) && getTipologiaServizio() == that.getTipologiaServizio() && getTipologiaConsulenza() == that.getTipologiaConsulenza() && getSpecializzazioneMedico() == that.getSpecializzazioneMedico() && getQuesitoMedico().equals(that.getQuesitoMedico()) && getFasciaOraria() == that.getFasciaOraria() && getLinkMyClinic().equals(that.getLinkMyClinic());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId_allarme(), getAb_codi(), getDataRichiesta(), getDataArrivo(), getNomeCliente(), getCognomeCliente(), getNumeroTelefono1(), getNumeroTelefono2(), getEmail(), getIndirizzo(), getNumeroOrdine(), getNumeroDossier(), getCodiceBP(), getTipologiaServizio(), getTipologiaConsulenza(), getSpecializzazioneMedico(), getQuesitoMedico(), getFasciaOraria(), getLinkMyClinic(), isTest());
	}

	@Override
	public String toString() {
		return "AllarmiEuropeAssistance{" +
				"id_allarme='" + id_allarme + '\'' +
				", ab_codi='" + ab_codi + '\'' +
				", dataRichiesta=" + dataRichiesta +
				", dataArrivo=" + dataArrivo +
				", nomeCliente='" + nomeCliente + '\'' +
				", cognomeCliente='" + cognomeCliente + '\'' +
				", numeroTelefono1='" + numeroTelefono1 + '\'' +
				", numeroTelefono2='" + numeroTelefono2 + '\'' +
				", email='" + email + '\'' +
				", indirizzo='" + indirizzo + '\'' +
				", numeroOrdine='" + numeroOrdine + '\'' +
				", numeroDossier='" + numeroDossier + '\'' +
				", codiceBP='" + codiceBP + '\'' +
				", tipologiaServizio=" + tipologiaServizio +
				", tipologiaConsulenza=" + tipologiaConsulenza +
				", specializzazioneMedico=" + specializzazioneMedico +
				", quesitoMedico='" + quesitoMedico + '\'' +
				", fasciaOraria=" + fasciaOraria +
				", linkMyClinic='" + linkMyClinic + '\'' +
				", test=" + test +
				'}';
	}
}
