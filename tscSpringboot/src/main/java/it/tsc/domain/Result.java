/**
 * 
 */
package it.tsc.domain;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * @author astraservice
 *
 */
@SuppressWarnings("rawtypes")
public class Result {
  @Expose
  private List data;

  /**
   * 
   */
  public Result() {
    
  }

  public List getData() {
    return data;
  }

  public void setData(List data) {
    this.data = data;
  }

}
