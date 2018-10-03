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
		@NamedQuery(name = Allarmi.SELECT_ALL_ALLARMS, query = "SELECT a FROM Allarmi a"),
		@NamedQuery(name = Allarmi.UPDATE_ALLARM, query = "UPDATE Allarmi a SET a.user=:user WHERE a.id_allarme=:id_allarme"),
		@NamedQuery(name = Allarmi.ALLARM_FIND_QUERY, query = "SELECT a.id_allarme FROM Allarmi a")})
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = Allarmi.SP_INSERT_ALLARM, procedureName = "sp_i_GeneraAllarme", parameters = {
				@StoredProcedureParameter(name = "p_ab_codi", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_matricola", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_mux", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_evento", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "p_centrale", type = String.class, mode = ParameterMode.IN)})})
public class Allarmi extends BaseDomain {
	public static final String SELECT_ALL_ALLARMS = "json.select.allarms";
	public static final String ALLARM_FIND_QUERY = "allarm.find.query";
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

	@Column(name = "data")
	@Expose
	private String data;

	@Column(name = "ora")
	@Expose
	private String ora;

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
	private String data_chiuso;

	@Column
	@Expose
	private String ora_chiuso;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getOra_chiuso() {
		return ora_chiuso;
	}

	public void setOra_chiuso(String ora_chiuso) {
		this.ora_chiuso = ora_chiuso;
	}

	public void setData_chiuso(String data_chiuso) {
		this.data_chiuso = data_chiuso;
	}

	@Override
	public String toString() {
		return "Allarmi [id_allarme=" + id_allarme + ", id_prova=" + id_prova
				+ ", ab_codi=" + ab_codi + ", evento=" + evento + ", data="
				+ data + ", ora=" + ora + ", user=" + user + ", esito=" + esito
				+ ", data_esito=" + data_esito + ", conclusioni=" + conclusioni
				+ ", data_chiuso=" + data_chiuso + ", ora_chiuso=" + ora_chiuso
				+ "]";
	}

}
