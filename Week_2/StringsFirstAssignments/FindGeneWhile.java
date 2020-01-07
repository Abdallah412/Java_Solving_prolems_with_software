
/**
 * Write a description of FindGeneWhile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindGeneWhile {
    public String findGene(String DNA)
    {
     int startIndex = DNA.indexOf("ATG");
     
     int currIndex = DNA.indexOf("TAA",startIndex+3);
     
     while (currIndex != -1)
     {
         if ((currIndex - startIndex)%3 ==0)
         {
             return DNA.substring(startIndex, currIndex+3);
             
             
             
            }
         else
         {
             currIndex = DNA.indexOf("TAA", currIndex+1);
            }
     }
     
     return "";
        
    }
    public void test()
    {
     String dna = "ATCTACGAATGTGCACGTAGTGATAA";
     System.out.println("Dna Strand is "+ dna);
     String gene = findGene(dna);
     System.out.println("Gene is " + gene);
        
    }

}
