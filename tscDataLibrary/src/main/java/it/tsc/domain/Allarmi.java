package it.tsc.domain;
/**
 *
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

/**
 * @author astraservice POJO class for allarm
 */
@Entity
@Table(name = "allarmi", schema = "telesoccorso@mysql_pu")
@NamedQueries(value = {
		@NamedQuery(name = Allarmi.SELECT_ALL_ALLARMS, query = "SELECT a.id_allarme,a.ab_codi,a.data_arrivo,a.evento,a.user FROM Allarmi a"),
		@NamedQuery(name = Allarmi.UPDATE_ALLARM, query = "UPDATE Allarmi a SET a.user=:user WHERE a.id_allarme=:id_allarme")})
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = Allarmi.SP_INSERT_ALLARM, procedureName = "sp_i_GeneraAllarme", parameters = {
				@StoredProcedureParameter(name = "p_ab_codi", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_matricola", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_mux", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_evento", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_centrale", type = String.class, mode = ParameterMode.IN)})})
public class Allarmi extends BaseDomain {
	public static final String SELECT_ALL_ALLARMS = "json.select.allarms";
	public static final String UPDATE_ALLARM = "update.allarm";
	public static final String SP_INSERT_ALLARM = "sp.insert.allarmo";
	/**
	 *
	 */
	private static final long serialVersionUID = 1985698665937980250L;
	@Id
	@Column
	@Expose
	private String id_allarme;
	@Column
	@Expose

	private String id_prova;
	@Column
	@Expose

	private String ab_codi;
	@Column
	@Expose
	private String evento;

	@Expose
	@Column
	private Date data_arrivo;

	@Column
	@Expose
	private String user;

	@Column
	@Expose
	private String esito;

	@Column
	@Expose
	private Date data_esito;

	@Column
	@Expose
	private String conclusioni;

	@Column
	@Expose
	private Date data_chiuso;

	/**
	 *
	 */
	public Allarmi() {
		// TODO Auto-generated constructor stub
	}

	public String getAb_codi() {
		return ab_codi;
	}

	public void setAb_codi(String ab_codi) {
		this.ab_codi = ab_codi;
	}

	public Date getData_arrivo() {
		return data_arrivo;
	}

	public void setData_arrivo(Date data_arrivo) {
		this.data_arrivo = data_arrivo;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getId_allarme() {
		return id_allarme;
	}

	public void setId_allarme(String id_allarme) {
		this.id_allarme = id_allarme;
	}

	public String getId_prova() {
		return id_prova;
	}

	public void setId_prova(String id_prova) {
		this.id_prova = id_prova;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Date getData_esito() {
		return data_esito;
	}

	public void setData_esito(Date data_esito) {
		this.data_esito = data_esito;
	}

	public String getConclusioni() {
		return conclusioni;
	}

	public void setConclusioni(String conclusioni) {
		this.conclusioni = conclusioni;
	}

	public Date getData_chiuso() {
		return data_chiuso;
	}

	public void setData_chiuso(Date data_chiuso) {
		this.data_chiuso = data_chiuso;
	}

}
