/**
 *
 */
package it.tsc.domain.types;

/**
 * @author "astraservice"
 *
 */
public enum SpecializzazioneMedico {
	CARDIOLOGO(1);

	private final int numVal;

	SpecializzazioneMedico(int numVal) {
		this.numVal = numVal;
	}

	public int getNumVal() {
		return numVal;
	}
}
