
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findGeneSimple(String dna)
    {
       //Start Codon 
       //End Codon
       String result = "";
       int StartIndex = dna.indexOf("ATG");
       if (StartIndex == -1)//No gene found
       {
         return "";  
        }
       int StopIndex = dna.indexOf("TAA", StartIndex+3);
       if (StopIndex ==-1)//no end to Codon
       {
         return "";  
        }
        int difference = StopIndex-StartIndex;
    if ( difference % 3 ==0)
    {
        result = dna.substring(StartIndex,StopIndex+3);
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
     System.out.println(findGeneSimple(dna));
     
     dna = "ACGTAGCGCGTAGTAACA";
     System.out.println(findGeneSimple(dna));
     
     dna = "ACGTAGCATGGCGTAGCA";
     System.out.println(findGeneSimple(dna));
     
     dna = "ACGTAGCATGGTGCGTAGCA";
     System.out.println(findGeneSimple(dna));
     
     dna = "ACGTAGCATGCGTGCGTAGCA";
     System.out.println(findGeneSimple(dna));
     
    }
    

}
