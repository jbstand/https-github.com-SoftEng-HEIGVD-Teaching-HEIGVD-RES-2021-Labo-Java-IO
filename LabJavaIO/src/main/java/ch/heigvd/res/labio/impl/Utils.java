package ch.heigvd.res.labio.impl;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String [] result = {"", lines};
    String sep = "";
    if(lines.contains("\r\n")){
      sep = "\r\n";
    }else if(lines.contains("\n")){
      sep = "\n";
    }else if(lines.contains("\r")){
      sep = "\r";
    }else{
      return result;
    }
    String[] splitted = lines.split("(?<=" + sep + ")");
    result[0] = splitted[0];
    result[1] = String.join(sep, Arrays.copyOfRange(splitted, 1, splitted.length));
    return result;
  }

}
