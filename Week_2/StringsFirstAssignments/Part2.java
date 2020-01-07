
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findGeneSimple(String dna, String StartCodon, String StopCodon)
    {
       //Start Codon 
       //End Codon
       String result = "";
       dna = dna.toUpperCase();
       int StartIndex = dna.indexOf(StartCodon);
       if (StartIndex == -1)//No gene found
       {
         return "";  
        }
       int StopIndex = dna.indexOf(StopCodon, StartIndex+3);
       if (StopIndex ==-1)//no end to Codon
       {
         return "";  
        }
        int difference = StopIndex-StartIndex;
    if ( difference % 3 ==0)
    {
        result = dna.substring(stopcodon,StopIndex+3);
    }
    else 
    {
     result = "";   
    }
       return result;
    }
    
    public void test()
    {
     String dna = "ACGTAGCATGGCGTAGTAACA";   
     System.out.println(findGeneSimple(dna, "ATG","TAA"));
     
     dna = "ACGTAGCGCGTAGTAACA";
     System.out.println(findGeneSimple(dna, "ATG","TAA"));
     
     dna = "ACGTAGCATGGCGTAGCA";
     System.out.println(findGeneSimple(dna, "ATG","TAA"));
     
     dna = "ACGTAGCATGGTGCGTAGCA";
     System.out.println(findGeneSimple(dna, "ATG","TAA"));
     
     dna = "ACGTAGCATGCGTGCGTAGCA";
     System.out.println(findGeneSimple(dna, "ATG","TAA"));
     
    }
    

}
