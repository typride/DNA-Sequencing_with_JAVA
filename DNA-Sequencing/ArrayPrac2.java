
import java.util.*;
public class ArrayPrac2{
public static void main(String[] args){


exercise1();

}
public static void exercise1(){
Scanner kb = new Scanner (System.in);

int[] arr = new int[6];

System.out.print("Enter tghe number of rolls: ");
int number =kb.nextInt();

for (int i = 0; i <number; i++){
   int random = (int)(Math.random() * 6) + 1;
   arr[random]++;
   }
   
   for (int i = 0; i < arr.length; i++){
     System.out.println("Number " + (i+ 1) + " was rolled" + (i + 1));
     }
     
    }
    }
    