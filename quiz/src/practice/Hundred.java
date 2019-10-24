package practice;

/**
 * hundred.
 * @author coalesce user.
 *
 */
public class Hundred { 
  /**
   * main.
   * @param args arguments.
   */

  public static void main(String[] args) { 
    int num = 569;
    String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    System.out.print(hundreds[num / 100]);
    num %= 100;
    System.out.print(tens[num / 10]);
    System.out.print(ones[num % 10]);
  }
}
