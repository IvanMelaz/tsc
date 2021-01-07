/**
 *
 */
package it.tsc.domain;

import javax.persistence.*;

/**
 * @author "astraservice"
 *
 */
@Entity
@Table(name = "sequence")
@NamedStoredProcedureQueries(value = {
		@NamedStoredProcedureQuery(name = Sequence.SP_NEXT_VALUE, procedureName = "nextval", resultClasses = Long.class, parameters = {
				@StoredProcedureParameter(name = "seq_name", type = String.class, mode = ParameterMode.IN)}),
		@NamedStoredProcedureQuery(name = Sequence.SP_CURRENT_VALUE, procedureName = "currval", resultClasses = Long.class, parameters = {
				@StoredProcedureParameter(name = "seq_name", type = String.class, mode = ParameterMode.IN)}),
		@NamedStoredProcedureQuery(name = Sequence.SP_SET_VALUE, procedureName = "setval", resultClasses = Long.class, parameters = {
				@StoredProcedureParameter(name = "seq_name", type = String.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "new_val", type = Long.class, mode = ParameterMode.IN)})})
public class Sequence {
	public static final String SP_NEXT_VALUE = "sp.next.value";
	public static final String SP_CURRENT_VALUE = "sp.current.value";
	public static final String SP_SET_VALUE = "sp.set.value";

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "cur_value")
	Long currentValue;
	/**
	 *
	 */
	public Sequence() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}

}
