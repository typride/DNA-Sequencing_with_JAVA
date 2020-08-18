import java.util.*;
public class GuessingGame{
public static void main (String[] args){


Scanner input = new Scanner(System.in);
System.out.println("What upper bound would you like?");
int upbound = input.nextInt();
chooseNumber(upbound, input);

}
   public static void chooseNumber(int upbound, Scanner input){
 
      int random = (int)(Math.random() * upbound + 1);
      int guesses = 1;
      boolean x = true;
      while(x){
 
      System.out.println("Guess the number (in ints)!");
       int numGuess = input.nextInt();
 
   if (numGuess == random){
      System.out.println("You're Right!!!");
      x = false;
      System.out.println("Your # of guesses = " + guesses);
      }
   if(numGuess < 0){
      System.out.println("aww. . . why'd you give up?");
      x = false;
      System.out.println("Your # of guesses = " + guesses);
      }
   if (numGuess < random && numGuess > 0){
      System.out.println("A little low . . .");
      guesses = guesses + 1;
      }
   if(numGuess > random){
      System.out.println("A little high . . .");
      guesses = guesses + 1;
         
      }
   }
 }
 }