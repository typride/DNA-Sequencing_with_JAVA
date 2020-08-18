import java.io.*;
import java.util.*;

public class JaneHeffernan_DNA {
   public static void main(String[] args) throws FileNotFoundException {
      welcome();
      Scanner kb = new Scanner(System.in);
    
      System.out.println("Enter the input file: ");
      String in = kb.nextLine();
      Scanner inFile = new Scanner(new File(in));
      
      System.out.println("Enter an output file: ");
      String out = kb.nextLine();
      
      File f = new File(out);
      if (f.exists()) {
         System.out.println("Error: output file already exists...");
      } else {
         PrintStream outFile = new PrintStream(new File(out));
            while(inFile.hasNextLine()){
               String name = inFile.nextLine();
               String nucleotides = inFile.nextLine();
               String nucleoStr = nucleotides.toUpperCase();
               double mass[] = new double[5];
               int nuc[] = new int[5];
               //(nuc[0] = A, nuc[1] = C, nuc[2] = G, nuc[3] = T, nuc[4] = -)
               double totalMass = 0;
               double massPer[] = new double[5];
               String dejunkedNuc = nucleoStr.replaceAll("-", "");
               int amntCod = (dejunkedNuc.length())/3;
               char codons[][] = new char[amntCod][3];
               
               
               nucCounter(nucleoStr, nuc);
               mass(nuc, mass);
               double massTotal = totalMass(mass, totalMass);
               massPer(mass, massTotal, massPer);
               codonMaker(nucleoStr, dejunkedNuc, amntCod, codons);
               boolean isProtein = isProtein(codons, amntCod, massPer);
               printer(name, nucleoStr, nuc, massPer, massTotal, amntCod, isProtein, outFile, codons); 
         }    
      }
   }
   public static void welcome(){
      System.out.println("Hello! Welcome to the DNA analyzer, this program" +
                          " can analyze a given string of nucleotides and" + 
                          " report the mass percents of each nucleotide, sort" +
                          " it into codons, and determine whether or not it is" +
                          " a protein."); 
   }
   public static int[] nucCounter(String nucleoStr, int[] nuc){
      for(int i = 0; i < nucleoStr.length(); i++){
         if(nucleoStr.charAt(i)== 'A'){
            nuc[0]++;
         }
          if(nucleoStr.charAt(i)== 'C'){
            nuc[1]++;
         }
         if(nucleoStr.charAt(i)== 'G'){
            nuc[2]++;
         }
         if(nucleoStr.charAt(i)== 'T'){
            nuc[3]++;
         }
         if(nucleoStr.charAt(i) == '-'){
            nuc[4]++;
         }
      }     
      return nuc;
   }
   
   public static double[] mass(int[] nuc, double[] mass){
      mass[0] = nuc[0] * 135.128;
      mass[1] = nuc[1] * 111.103;
      mass[2] = nuc[2] * 151.128;
      mass[3] = nuc[3] * 125.107;
      mass[4] = nuc[4] * 100.000;
      return mass;
   }
   
   public static double totalMass(double[] mass, double totalMass){
      for(int j = 0; j < 5; j++){
         totalMass += mass[j];
      }
      return totalMass;
   }      
   
   public static double[] massPer(double[] mass, double massTotal, double[] massPer){              
      for (int u = 0; u < 5; u++){
         massPer[u] = ((double)Math.round(((mass[u] / massTotal)*100)*10))/10;  
      } 
      return massPer;
   }
   
   public static char[][] codonMaker(String nucleoStr, String dejunkedNuc, int amntCod, char[][] codons){
      int nucIndex = 0;
      for (int i = 0; i < amntCod; i++){
         for (int j = 0; j < 3; j++){
           codons[i][j] = dejunkedNuc.charAt(nucIndex);
           nucIndex++; 
         }
      }
      return codons;
   }
   public static boolean isProtein(char[][] codons, int amntCod, double[] massPer){ 
      int lastCodon = amntCod-1;
      if(codons[0][0] != 'A' || codons[0][1] != 'T' || codons[0][2] != 'G'){
         return false;
      }
            if(amntCod < 5){
         return false;
      }
      if((massPer[1] + massPer[2]) < 30){
         return false;
      }
      if(codons[lastCodon][0] == 'T' && codons[lastCodon][1] == 'A' && codons[lastCodon][2] == 'A'){
         return true;
      }
      if(codons[lastCodon][0] == 'T' && codons[lastCodon][1] == 'A' && codons[lastCodon][2] == 'G'){
         return true;
      }
      if(codons[lastCodon][0] == 'T' && codons[lastCodon][1] == 'G' && codons[lastCodon][2] == 'A'){
          return true;
      }
      return false;
   }
   public static void printer(String name, String nucleoStr, int[] nuc, double[] massPer, double massTotal, 
                              int amntCod, boolean isProtein, PrintStream outFile, char[][] codons){
      outFile.println("Region Name: " + name);
      outFile.println("Nucleotides: " + nucleoStr);
      outFile.println("Nuc. Counts: " + Arrays.toString(nuc));       
      outFile.println("Total Mass%: [" + massPer[0] + ", " + massPer[1] + ", " + massPer[2] + ", " + 
                      massPer[3] + "] of " + ((double)Math.round(massTotal*10))/10);
      outFile.print("Codons List: [");
      for (int i = 0; i < amntCod; i++){
         for (int j = 0; j < 3; j++){
            outFile.print(codons[i][j]);      
         }
         if(i != (amntCod - 1)){
            outFile.print(", ");
         }
      }
      outFile.println("]");
      outFile.print("Is Protein?: ");
      if(isProtein(codons, amntCod, massPer)){
         outFile.println("YES");
      }else{
         outFile.println("NO");
      } 
      outFile.println();
   }
}         