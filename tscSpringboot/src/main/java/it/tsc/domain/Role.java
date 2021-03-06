/**
 * 
 */
package it.tsc.domain;

/**
 * @author astraservice
 *
 */
public enum Role {

  ROLE_ADMIN, ROLE_SADMIN, ROLE_USER, ROLE_BACKOFFICE, ROLE_IMPERSONATE;

  /**
   * return String Value for role
   * 
   * @param role
   * @return
   */
  public String value(Role role) {
    switch (role) {
      case ROLE_ADMIN:
        return "ROLE_ADMIN";
      case ROLE_SADMIN:
        return "ROLE_SADMIN";
      case ROLE_USER:
        return "ROLE_USER";
      case ROLE_BACKOFFICE:
        return "ROLE_BACKOFFICE";
      case ROLE_IMPERSONATE:
        return "ROLE_IMPERSONATE";
      default:
        throw new RuntimeException("Role cannot be converted");
    }
  }

  /**
   * return role from string value
   * 
   * @param text
   * @return
   */
  public static Role fromString(String text) {
    for (Role role : Role.values()) {
      if (text.contains(role.toString())) {
        return role;
      }
    }
    return null;
  }
}
