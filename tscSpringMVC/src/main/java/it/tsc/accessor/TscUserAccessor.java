/**
 * 
 */
package it.tsc.accessor;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;

import it.tsc.model.TscUser;

/**
 * @author astraservice TscUser map using @Accessor
 */
@Accessor
public interface TscUserAccessor {
  /**
   * add User using @Accessor
   * 
   * @param username
   * @param password
   * @param email
   * @param role
   * @return
   */
  @Query("INSERT INTO ks_tsc.tb_users (username, password, email,role) VALUES (:username, :password, :email,:role) IF NOT EXISTS;")
  public void addUser(@Param("username") String username, @Param("password") String password,
      @Param("email") String email, @Param("role") String role);

  /**
   * delete User using @Accessor
   * 
   * @param username
   * @return
   */
  @Query("DELETE FROM ks_tsc.tb_users WHERE username = :username;")
  public void removeUser(@Param("username") String username);

  /**
   * update User using @Accessor
   * 
   * @param username
   * @param password
   * @param email
   * @param role
   * @return
   */
  @Query("UPDATE ks_tsc.tb_users SET password=:password,email=:email WHERE username = :username AND role = :role IF EXISTS;")
  public void updateUser(@Param("username") String username, @Param("password") String password,
      @Param("email") String email, @Param("role") String role);

  /**
   * get All Users using @Accessor
   * 
   * @return
   */
  @Query("SELECT * FROM ks_tsc.tb_users;")
  public Result<TscUser> getAllUsers();

  /**
   * return Role giving username and password using @Accessor
   * 
   * @param username
   * @param password
   * @return
   */
  @Query("SELECT * FROM ks_tsc.tb_users WHERE username = :username AND password = :password ALLOW FILTERING;")
  public Result<TscUser> getUserRoles(@Param("username") String username,
      @Param("password") String password);

  /**
   * return single user
   * 
   * @param username
   * @return
   */
  @Query("SELECT * FROM ks_tsc.tb_users WHERE username = ? ALLOW FILTERING;")
  public Result<TscUser> getUser(@Param("username") String username);

}
