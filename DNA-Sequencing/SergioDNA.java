import java.io.*;
import java.util.*;
public class SergioDNA{
   public static void main(String [] args)throws FileNotFoundException{
      Scanner kb = new Scanner(System.in);
      
      intro();
      
      System.out.println("Please enter the input file: ");
      String file = kb.nextLine();
      Scanner input = new Scanner(new File(file));
      
      System.out.println("Enter an output file: ");
      String out = kb.nextLine();

      File f = new File(out);
      if (f.exists()) {
         System.out.println("Error: output file already exists...");
      } else {
      
      while(input.hasNextLine()){
         int lineNum = 1;
         while (input.hasNextLine()){
            String line = input.nextLine();
            if(lineNum == 1){
               System.out.println("Region Name: " + line);
               lineNum++;
            }
            else if(lineNum == 2){
               String nucleotides = line.toUpperCase();
               System.out.println("Nucleotides: " + nucleotides);
               
               System.out.println(nucCounts(nucleotides));
               
               System.out.println(massPercentages(nucleotides));
               
               System.out.println(codonList(nucleotides));
                              
               System.out.println(isProtein(nucleotides));
                           
               System.out.println();
               
               lineNum --;
            }           
         }
      }
      }
   }
   public static void intro(){
      Scanner kb = new Scanner(System.in);
      System.out.println("Welcome to DNA Analysis");
      System.out.println("What is your name?");
      String name = kb.nextLine();
      System.out.println("Would you like anything to eat or drink before we begin " + name + "?");
      String answer = kb.nextLine();
      if(answer.equalsIgnoreCase("yes")){
         System.out.println("Sorry, no food or drinks allowed");
      }
      else if(answer.equalsIgnoreCase("no")){
         System.out.println("Good you weren't going to get anything DNA analysis needs completet focus");
      }
      else{
         System.out.println("... Let's continue");
      }
      System.out.print("This program will take the dna sequence and give you the: ");
      System.out.print("Nucleotide Count, Mass Percentages of the codons A C G T in that order, ");
      System.out.println("List of Codons present, and tell you whether or not it is a protein");
      System.out.println("Are you ready?");
      String answer2 = kb.nextLine();
      if(answer.equalsIgnoreCase("yes")){
         System.out.println("Great!! Let's begin");
      }
      else if(answer.equalsIgnoreCase("no")){
         System.out.println("We are going to start either way");
      }
      else{
         System.out.println("... Let's start");
      }
   }
   public static String nucCounts (String nucleotides){
      int[] arr = new int[4];
      for(int i = 0; i < nucleotides.length(); i++){
         char letter = nucleotides.charAt(i);
         if(letter == 'A'){
            arr[0]++;
         }
         if(letter == 'C'){
            arr[1]++;
         }
         if(letter == 'G'){
            arr[2]++;
         }
         if(letter == 'T'){
            arr[3]++;
         }   
      }
      return "Nuc. Counts: "+ Arrays.toString(arr);
   }
   public static String massPercentages(String nucleotides){
      int[] arr = new int[4];
      for(int i = 0; i < nucleotides.length(); i++){
         char letter = nucleotides.charAt(i);
         if(letter == 'A'){
            arr[0]++;
         }
         if(letter == 'C'){
            arr[1]++;
         }
         if(letter == 'G'){
            arr[2]++;
         }
         if(letter == 'T'){
            arr[3]++;
         }   
      }
      //this is needed to have number of codons
      double[] mass = new double [4];
      double[] codonmass = new double [4];
      double totalcodonmass = 0;
      double junknum = 0;
      double junkmass = 0;
      double[] percentage = new double [4];
      char junk = '-';
      mass[0] = 135.128;
      mass[1] = 111.103;
      mass[2] = 151.128;
      mass[3] = 125.107;
      for(int i = 0; i < nucleotides.length(); i++){
         if(nucleotides.charAt(i) == junk){
            junknum++;
         }
      }
      junkmass = junknum * 100;
      for(int i = 0; i < 4; i++){
         codonmass[i] = (((double)mass[i]) *arr[i]);
      }
      for(int i = 0; i < 4; i++){
         totalcodonmass += codonmass[i];
      }
      double total = totalcodonmass + junkmass;
      for(int i = 0; i < 4; i++){
         percentage[i] = (Math.round(((codonmass[i] / total) * 100)*10)) / 10.0;
      }
      return "Total Mass%: " + Arrays.toString(percentage) + " of " + ((Math.round(total*10.0))/10.0);
   }
   
   public static String codonList(String nucleotides){
      String substr = "";
      String regex = "-";
      String revisedNuctides = nucleotides.replaceAll(regex, substr);
      String[] list = new String[revisedNuctides.length() / 3];
      for(int i = 0; i < revisedNuctides.length() / 3; i++){
         list[i] = Character.toString(revisedNuctides.charAt(3 * i));
         list[i] += Character.toString(revisedNuctides.charAt((3 * i) + 1));
         list[i] += Character.toString(revisedNuctides.charAt((3 * i) + 2));
      }
      return "Codons List: " + Arrays.toString(list);
   }
   
   public static String isProtein(String nucleotides){

      if(nucleotides.startsWith("ATG") && (nucleotides.endsWith("TAA")||nucleotides.endsWith("TAG")||nucleotides.endsWith("TGA"))){
         if(nucleotides.length() >= 15){
            return "Is Protein?: YES";
         }
      }
      return "Is Protein?: NO";
   }
}