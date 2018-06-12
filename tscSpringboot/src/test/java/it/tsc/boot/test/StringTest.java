/**
 *
 */
package it.tsc.boot.test;

/**
 * @author "astraservice"
 *
 */
public class StringTest {

	/**
	 *
	 */
	public StringTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fieldName = "1,2,3,";
		if (fieldName.trim().endsWith(",")) {
			fieldName = fieldName.substring(0, fieldName.length() - 1);
		}
		System.out.println(fieldName);
	}

}
