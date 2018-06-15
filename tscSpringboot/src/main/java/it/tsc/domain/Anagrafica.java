/**
 *
 */
package it.tsc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

/**
 * @author astraservice Anagrafica Utente
 */
@Entity
@Table(name = "anagrafica", schema = "telesoccorso@mysql_pu")
@NamedQueries(value = {
		@NamedQuery(name = Anagrafica.SELECT_ANAGRAFICA_BY_ABCODI, query = "SELECT a FROM Anagrafica a WHERE TRIM(a.ab_codi) = TRIM(:ab_codi)")})
//@formatter:off
//@formatter:on
public class Anagrafica {
	public static final String SELECT_ANAGRAFICA_BY_ABCODI = ".select.anagrafica.by.abcodi";
	@Id
	@Column
	@Expose
	private String ab_codi;

	@Column
	@Expose
	private String matricola;

	@Column
	@Expose
	private String nominativo;

	@Column
	@Expose
	private String indirizzo;

	@Column
	@Expose
	private String comune;

	@Column
	@Expose
	private String provincia;

	@Column
	@Expose
	private String cap;

	@Column
	@Expose
	private String telefono;

	@Column
	@Expose
	private String cellulare;

	@Column
	@Expose
	private String sesso;

	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Column
	@Expose
	private Date data_nascita;

	@Column
	@Expose
	private String luogo_nascita;

	@Column
	@Expose
	private int altezza;

	@Column
	@Expose
	private int peso;

	@Column
	@Expose
	private String patologia;

	@Column
	@Expose
	private String terapia;

	@Column
	@Expose
	private String evidenzia;

	@Column
	@Expose
	private String note;

	@Column
	@Expose
	private String altro;

	@Column
	@Expose
	private String dati_abita;

	@Column
	@Expose
	private String sopravvivenza;

	@Column
	@Expose
	private String dati_tecnici;

	@Temporal(TemporalType.DATE)
	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Column
	@Expose
	private Date data_inserimento;

	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Column
	@Expose
	private Date data_installazione;

	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Expose
	@Column
	private Date data_modifica;

	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Column
	@Expose
	private Date data_aggiornamento;

	@Convert(converter = it.tsc.domain.converter.DataConverter.class)
	@Column
	@Expose
	private Date data_disinstallazione;

	@Column
	@Expose
	private String motivo_disinstallazione;

	@Column
	@Expose
	private String centrale;

	@Column
	@Expose
	private String ente;

	/**
	 *
	 */
	public Anagrafica() {

	}

	public String getAb_codi() {
		return ab_codi;
	}

	public void setAb_codi(String ab_codi) {
		this.ab_codi = ab_codi;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getLuogo_nascita() {
		return luogo_nascita;
	}

	public void setLuogo_nascita(String luogo_nascita) {
		this.luogo_nascita = luogo_nascita;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getPatologia() {
		return patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public String getTerapia() {
		return terapia;
	}

	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}

	public String getEvidenzia() {
		return evidenzia;
	}

	public void setEvidenzia(String evidenzia) {
		this.evidenzia = evidenzia;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAltro() {
		return altro;
	}

	public void setAltro(String altro) {
		this.altro = altro;
	}

	public String getDati_abita() {
		return dati_abita;
	}

	public void setDati_abita(String dati_abita) {
		this.dati_abita = dati_abita;
	}

	public String getSopravvivenza() {
		return sopravvivenza;
	}

	public void setSopravvivenza(String sopravvivenza) {
		this.sopravvivenza = sopravvivenza;
	}

	public String getDati_tecnici() {
		return dati_tecnici;
	}

	public void setDati_tecnici(String dati_tecnici) {
		this.dati_tecnici = dati_tecnici;
	}

	public Date getData_inserimento() {
		return data_inserimento;
	}

	public void setData_inserimento(Date data_inserimento) {
		this.data_inserimento = data_inserimento;
	}

	public Date getData_installazione() {
		return data_installazione;
	}

	public void setData_installazione(Date data_installazione) {
		this.data_installazione = data_installazione;
	}

	public Date getData_aggiornamento() {
		return data_aggiornamento;
	}

	public void setData_aggiornamento(Date data_aggiornamento) {
		this.data_aggiornamento = data_aggiornamento;
	}

	public Date getData_disinstallazione() {
		return data_disinstallazione;
	}

	public void setData_disinstallazione(Date data_disinstallazione) {
		this.data_disinstallazione = data_disinstallazione;
	}

	public String getMotivo_disinstallazione() {
		return motivo_disinstallazione;
	}

	public void setMotivo_disinstallazione(String motivo_disinstallazione) {
		this.motivo_disinstallazione = motivo_disinstallazione;
	}

	public String getCentrale() {
		return centrale;
	}

	public void setCentrale(String centrale) {
		this.centrale = centrale;
	}

	public String getEnte() {
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Date getData_modifica() {
		return data_modifica;
	}

	public void setData_modifica(Date data_modifica) {
		this.data_modifica = data_modifica;
	}

}
