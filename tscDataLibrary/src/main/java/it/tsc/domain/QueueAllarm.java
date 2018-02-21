package it.tsc.domain;
/**
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "coda_eve", schema = "telesoccorso@mysql_pu")
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = QueueAllarm.SP_V_CODA_EVE, procedureName = "sp_v_Coda_Eve", parameters = {
				@StoredProcedureParameter(name = "p_user", type = String.class, mode = ParameterMode.IN)})})
public class QueueAllarm extends BaseDomain {
	/**
	 *
	 */
	private static final long serialVersionUID = -7368201474277648327L;
	public static final String SP_V_CODA_EVE = "sp.v.coda_eve";

	@Id
	@Column
	@Expose
	private String id_allarme;

	/**
	 *
	 */
	public QueueAllarm() {

	}

	public String getId_allarme() {
		return id_allarme;
	}

	public void setId_allarme(String id_allarme) {
		this.id_allarme = id_allarme;
	}

}
