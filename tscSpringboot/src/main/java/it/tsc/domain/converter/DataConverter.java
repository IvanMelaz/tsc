/**
 *
 */
package it.tsc.domain.converter;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author "astraservice"
 *
 */
public class DataConverter implements AttributeConverter<Date, String> {
  private static final String DATE_FORMAT = "yyyy-MM-dd";
  private final SimpleDateFormat sdfDate = new SimpleDateFormat(DATE_FORMAT);// dd/MM/yyyy
  Date now = new Date();
  String strDate = sdfDate.format(now);

  /**
   *
   */
  public DataConverter() {
    
  }

  @Override
  public String convertToDatabaseColumn(Date attribute) {
    if (attribute != null) {
      try {
        return sdfDate.format(attribute);
      } catch (Exception e) {
        return null;
      }
    } else {
      return null;
    }
  }

  @Override
  public Date convertToEntityAttribute(String dbData) {
    if (StringUtils.isNotEmpty(dbData)) {
      try {
        return sdfDate.parse(dbData);
      } catch (Exception e) {
        return null;
      }
    } else {
      return null;
    }
  }

}
