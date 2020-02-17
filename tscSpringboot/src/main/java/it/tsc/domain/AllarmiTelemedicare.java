package it.tsc.domain;
/**
 *
 */

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;

/**
 * @author astraservice POJO class for allarm
 */
@Entity
@Table(name = "tsc_telemedicare")
@NamedQueries(value = {
		@NamedQuery(name = AllarmiTelemedicare.SELECT_ALLARM_TMC, query = "select a FROM AllarmiTelemedicare a order by a.dataArrivo DESC"),
		@NamedQuery(name = AllarmiTelemedicare.DROP_ALLARM_TMC, query = "delete FROM AllarmiTelemedicare a where a.progressivoAllarme = :progressivoAllarme ") })
public class AllarmiTelemedicare extends BaseDomain {
	public static final String SELECT_ALLARM_TMC = "select.allarm.tmc";

	public static final String DROP_ALLARM_TMC = "drop.allarm.tmc";

	/**
	 *
	 */
	private static final long serialVersionUID = 1338024278631839150L;

	@Id
	@Column(name = "id_allarme")
	@Expose
	private String id_allarme;

	@Column(name = "ab_codi")
	@Expose
	private String ab_codi;

	@Column(name = "data_arrivo")
	@Temporal(value = TemporalType.TIMESTAMP)
	@Expose
	private Date dataArrivo;

	@Column(name = "progressivo_allarme")
	@Expose
	private String progressivoAllarme;

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

	public Date getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public String getProgressivoAllarme() {
		return progressivoAllarme;
	}

	public void setProgressivoAllarme(String progressivoAllarme) {
		this.progressivoAllarme = progressivoAllarme;
	}
}
