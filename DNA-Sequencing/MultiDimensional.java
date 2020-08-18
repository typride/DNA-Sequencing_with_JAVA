import java.util.*;
public class MultiDimensional{
public static void main(String[]args){
Scanner kb = new Scanner(System.in);
System.out.print("How many rolls");
d6x2(kb.nextInt());



/*

to declare multi-dimensional Array:

int[][] twDimArray = int[5][7];

"[5]" is the amount of arrays
"[7]" is the amount of spaces inside the array


int[][] otherArray = { { 1,2,3}, {4,5,6} };

^^^^^^^
these would be a 2 x 3 array:
{ {1,2,3},
  {4,5,6} }

Essentially, each element of the outer array is another array:

int[] ondeDimArray = twoDimArray[1];
int value = twoDimArray[3][5];


int[][] twoDimArr = { {1,2,3},
                      {4,5,6},
                      {7,8,9} };
                      
System.out.println(twoDimArr[0][2]); // row 0, col 2 = 3
System.out.println(twoDimArr[1][0]); // row 1, col 0 = 4 

Nested Loops:

just like for loops work well with arrays, 
two dimensional arrays and nested loops
go hand in hand.

String[][] twoDimArr = new String[3][5];
...

for (int i = 0; i < twoDimArr.length; i++){
   for (int j = 0; j < twoDimArr[i].length; j++){
      System.out.print(twoDimArr[i][j] + " ");
   }
   System.out.println();
}
int random = (int)(Math.random() * upbound + 1);


Scanner kb = new Scanner(System.in);
int numrolls = kb.nextInt();
System.out.println([numrolls][0]);
}
}
//int[][] twoDimArr = new int[numrolls][6];
*/
public static void d6x2(int numRolls){

int[][] rolls = new int[6][6];

for (int i  = 0; i < numrolls; i++){
   int firstRoll = (int)(Math.Random() * 6) ;
   int secondRoll = (int)(Math.Random() * 6);
   rolls[firstRoll][secondRoll] += 1;
   
   }  
   for (int j = 0; j < 6; j++){
      for (int k = 0; k < 6; k++){
      System.out.println((j+1) + "-" + (K + 1) + "is roleld: " + rolls[j][k]);
      
      }
   }