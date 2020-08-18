import java.util.*;

public class FractionClient{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Enter a Fraction : ");
      String line = kb.nextLine();
      String[] parts = line.split("/");
      
      Fraction frac1= new Fraction();
      frac1.numerator = Integer.parseInt(parts[0]);
      frac1.denominator = Integer.parseInt(parts[1]);
      
      System.out.print("Enter a Fraction : ");
      String line2 = kb.nextLine();
      String[] parts2 = line2.split("/");
      
      Fraction frac2= new Fraction();
      frac2.numerator = Integer.parseInt(parts2[0]);
      frac2.denominator = Integer.parseInt(parts2[1]);
      
      Fraction frac3 = multiply(frac1, frac2);
      System.out.println("Result : " + frac3.numerator + "/" + frac3.denominator);
      
      } 
      public static Fraction multiply(Fraction f1, Fraction f2){
      Fraction result = new Fraction();
      result.numerator = f1.numerator * f2.numerator;
      result.denominator= f1.denominator * f2.denominator;
      return result;
      }
      
}