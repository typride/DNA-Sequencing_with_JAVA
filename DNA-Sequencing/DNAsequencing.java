import java.util.*;
import java.io.*;

public class DNAsequencing{
public static void main(String[] args)throws FileNotFoundException{


      introduction();
      
      System.out.println("Gimme an input file");
      Scanner kb = new Scanner(System.in);
      String in = kb.nextLine();
      Scanner inFile = new Scanner(new File(in));
      System.out.println("Enter an output file: ");
      String out = kb.nextLine();

      File f = new File(out);
      if (f.exists()) {
         System.out.println("Error: output file already exists...");
 } else {
      
      while(inFile.hasNextLine()){
         int lineNum = 1;
         while (inFile.hasNextLine()){
            String line = inFile.nextLine();
            if(lineNum == 1){
               System.out.println("Region Name: " + line);
               lineNum++;
            }
            else if(lineNum == 2){
      String nucleo = line;
      System.out.println("Nucleotides: " + nucleo);
      nucleo.toUpperCase();
      System.out.println(nucleotides(nucleo));
      System.out.println(isProtein(nucleo));
      System.out.println();
      lineNum--;
     
            }
       }
   }
}
}
      
public static String nucleotides(String nucleo){
   int nucleotides2[] = new int[5];
   
  for(int i = 0; i < nucleo.length(); i++){
      if(nucleo.charAt(i) == ('A')){ //A = [0]
         nucleotides2[0]++;
         }
      if(nucleo.charAt(i)==('C')){ //C = [1]
         nucleotides2[1]++;
         }
      if(nucleo.charAt(i)==('G')){ //G = [2]
         nucleotides2[2]++;
         }
      if(nucleo.charAt(i)==('T')){ //C = [3]
         nucleotides2[3]++;
         }
      if(nucleo.charAt(i)==('-')){
         nucleotides2[4]++;
         }
   }
    System.out.println("Nuc. Counts : " + Arrays.toString(nucleotides2));

   double[] weight2 = new double[5];
   double total = 0;
   total =
   (nucleotides2[0] * 135.128)+
   (nucleotides2[1] * 111.108)+
   (nucleotides2[2] * 151.128)+
   (nucleotides2[3] * 125.107)+
   (nucleotides2[4] * 100.000);
   weight2[0] = Math.round(((nucleotides2[0] * 135.128/total)*100));
   weight2[1] = Math.round(((nucleotides2[1] * 111.108/total)*100));
   weight2[2] = Math.round(((nucleotides2[2] * 151.128/total)*100));
   weight2[3] = Math.round(((nucleotides2[3] * 125.107/total)*100));
   weight2[4] = Math.round(((nucleotides2[4] * 100.000/total)*100));
   return ("Total mass% : " + Arrays.toString(weight2)+" of " + (Math.round(total*10.0))/10.0);
}
  
public static String isProtein(String nucleo){

      if(nucleo.startsWith("ATG") && (nucleo.endsWith("TAA")||nucleo.endsWith("TAG")||nucleo.endsWith("TGA"))){
         if(nucleo.length() >= 15){
            return "Is Protein?: YES";
         }
      }
      return "Is Protein?: NO";
}
      
        
   public static void introduction(){
      Scanner kb = new Scanner(System.in);
      System.out.println("Welcome to Tyler Milligan's DNA Analysis");
      System.out.println();
      System.out.println("This program will tell you everything you need to know about the nuc. sequences you give me.");
      System.out.println();
      System.out.println("Including:\nnucleotide count,\npercentage of nucleotides A-C-T-G \nif it's a valid protein");
      System.out.println("\nready to begin?");
      String yeaorney = kb.nextLine();
      if(yeaorney.equalsIgnoreCase("yes")){
         System.out.println("Great!! Let's begin");
      }
  }    
}




   
