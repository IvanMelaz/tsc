/**
 * 
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

/**
 * @author astraservice POJO TSC User
 */
public class PortalUser {
  @NotBlank(groups = {PortalUserRemove.class, PortalUserRenewPassword.class})
  @Expose
  @Column(name = "username")
  private String username;

  @NotBlank(groups = {PortalUserRemove.class})
  @Expose
  @Column(name = "role")
  private String role;

  @Transient
  @Expose
  private List<String> roles;

  @NotBlank(groups = {PortalUserInsert.class, PortalUserRenewPassword.class})
  @Email
  @Expose
  @Column(name = "email")
  private String email;

  @NotBlank(groups = PortalUserInsert.class)
  @Expose
  @Column(name = "password")
  private String password;

  @Column(name = "base32Secret")
  private String base32Secret;

  /**
   * default ask MFA
   */
  @Column(name = "mfaenabled")
  private boolean mfaEnabled = true;

  /**
   * 
   */
  public PortalUser() {

  }

  public PortalUser(ApplicationUser user) {
    super();
    if (user != null) {
      this.username = user.getUsername();
      this.email = user.getEmail();
      roles = new ArrayList<String>();
      for (GrantedAuthority ga : user.getAuthorities()) {
        roles.add(ga.getAuthority());
      }
    }
  }

  public PortalUser(String username, List<String> roles, String email) {
    super();
    this.username = username;
    this.roles = roles;
    this.email = email;
  }

  public PortalUser(String username, String password, List<String> roles, String email,
      String base32Secret, boolean mfaEnabled) {
    super();
    this.username = username;
    this.roles = roles;
    this.email = email;
    this.password = password;
    this.base32Secret = base32Secret;
    this.mfaEnabled = mfaEnabled;
  }

  /**
   * 
   * @author astraservice
   *
   */
  public interface PortalUserInsertValidator {

  }

  /**
   * 
   * @author astraservice
   *
   */
  // @formatter:off
	public interface PortalUserRemove extends Default {
	}

	public interface PortalUserInsert extends PortalUserRemove {
	}

	public interface PortalUserRenewPassword extends Default {
	}
	// @formatter:on

  public interface Draft extends Default {
  }

  public interface Printing extends Draft {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getBase32Secret() {
    return base32Secret;
  }

  public void setBase32Secret(String base32Secret) {
    this.base32Secret = base32Secret;
  }

  public boolean isMfaenabled() {
    return mfaEnabled;
  }

  public void setMfaenabled(boolean mfaEnabled) {
    this.mfaEnabled = mfaEnabled;
  }

}
