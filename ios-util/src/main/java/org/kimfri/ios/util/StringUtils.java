package org.kimfri.ios.util;

import java.util.List;

public class StringUtils {

  private StringUtils() {}

  /**
   * Concatenate all strings in list with delimiter as delimiter.
   *
   * @param stringList List of strings that should be concatenated
   * @param delimiter The delimiter between the concatenated strings
   * @return String All strings concatenated with delimiter, or null
   * if any argument is null
   *
   * @since 1.0.0
   */
  public static String concatenate(List<String> stringList, String delimiter) {
    if(stringList == null || delimiter == null) {
      return null;
    }
    return String.join(delimiter, stringList);
  }
}
