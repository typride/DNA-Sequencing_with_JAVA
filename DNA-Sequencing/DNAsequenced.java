import java.util.*;
import java.io.*;

public class DNAsequenced{
public static void main(String[] args)throws FileNotFoundException{


      
      System.out.println("Gimme an input file");
      Scanner kb = new Scanner(System.in);
      String in = kb.nextLine();
      Scanner inFile = new Scanner(new File(in));
      
      while(inFile.hasNextLine()){
      String name = inFile.nextLine();
      System.out.println("Region Name : " + name);
      String nucleo = inFile.nextLine();
      System.out.println("Nucleotides : " + nucleo);
      nucleo.toUpperCase();
      double[] n = new double[4];
      n = nucleotides(nucleo);
      FindWeight(n);
      IsNucleotide(nucleo);
      //CodonList(nucleo);
     
      }
}

      
public static double[] nucleotides(String nucleo){
   double nucleotides2[] = new double[5];
   
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
   return nucleotides2;
     }

public static double[] FindWeight(double[] nucleotides2){
   double[] weight2 = new double[5];
   double total = 0;
   weight2[0] = nucleotides2[0] * 135.128;
   total = weight2[0];
   weight2[1] = nucleotides2[1] * 111.108;
   total += weight2[1];
   weight2[2] = nucleotides2[2] * 151.128;
   total+=weight2[2];
   weight2[3] = nucleotides2[3] * 125.107;
   total+=weight2[3];
   weight2[4] = nucleotides2[4] * 100.000;
   total+=weight2[4];
   System.out.println("Total mass% : " + Arrays.toString(weight2)+" of " + total);
   System.out.println("");
   return weight2; 
  }
  
/*  
public static String[] CodonList(String nucleotides){
   ArrayList<String> codons = new ArrayList<String>();
   for(int i = 0; i < nucleotides.length / 3;i++){
      codons.add(i);
      }
      CondonList.toArray();
      return CodonList;
   } 
   */
   public static void IsNucleotide(String nucleo){
   String nucleotides = nucleo;
   int length = nucleotides.length();
      if(nucleotides.charAt(0) == 'A' && 
         nucleotides.charAt(1) == 'T' && 
         nucleotides.charAt(2) == 'G'){
         System.out.println("yes");
         
        // nucleotides.charAt(length - 3) == 'T' 
        // && nucleotides.charAt(length - 2) == 'A' || nucleotides.charAt(length-1) == 'A'){
       //  System.out.println("yes");
         }
   }
   }
   
      
 
     

    /*  
      System.out.println("Enter an output file: ");
      String out = kb.nextLine();

      File f = new File(out);
      if (f.exists()) {
         System.out.println("Error: output file already exists...");
      } else {
         PrintStream outFile = new PrintStream(new File(out));
               
         int lineNum = 1;
         while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            
            System.out.println(line);
            
            outFile.print("Line " + lineNum + ": ");
            outFile.println(line);
            lineNum++;
            
         }
      }
      */
   





   
