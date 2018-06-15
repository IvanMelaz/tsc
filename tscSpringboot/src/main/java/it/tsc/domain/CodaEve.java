package it.tsc.domain;
/**
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.Expose;

/**
 * @author astraservice POJO class for allarm
 */
@Entity
@Table(name = "coda_eve", schema = "telesoccorso@mysql_pu")
// @NamedStoredProcedureQueries(value = {
// @NamedStoredProcedureQuery(name = CodaEve.SP_I_INSERTALLARM_TEL_IN_CODA_EVE,
// procedureName = "sp_i_InsertAllarmi_in_CodaEve_Brondi", parameters = {
// @StoredProcedureParameter(name = "p_telefono", type = String.class, mode =
// ParameterMode.IN),
// @StoredProcedureParameter(name = "p_filename", type = String.class, mode =
// ParameterMode.IN),
// @StoredProcedureParameter(name = "p_centrale", type = String.class, mode =
// ParameterMode.IN)})})
public class CodaEve extends BaseDomain {
	private static final long serialVersionUID = -7368201474277648327L;

	@Id
	@Column
	@Expose
	private String id_allarme;

	@Column
	@Expose
	private String ab_codi;

	@Column
	@Expose
	private String matricola;

	@Column
	@Expose
	private String evento;

	@Column
	@Expose
	private String nominativo;

	@Temporal(TemporalType.DATE)
	@Column
	@Expose
	private Date data;

	@Temporal(TemporalType.TIME)
	@Column
	@Expose
	private Date ora;

	@Column
	@Expose
	private String user;

	@Column
	@Expose
	private String telefono;

	@Column(name = "filename")
	@Expose
	private String fileName;

	/**
	 *
	 */
	public CodaEve() {

	}

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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getOra() {
		return ora;
	}

	public void setOra(Date ora) {
		this.ora = ora;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
