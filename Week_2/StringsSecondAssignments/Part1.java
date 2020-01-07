
/**
 * Write a description of Part1 here.
 * 3. Write the method findStopCodon that has three parameters, 
 * a String parameter named dna, an integer parameter named startIndex that represents where the 
 * first occurrence of ATG occurs in dna, and a String parameter named stopCodon. This method returns the index of the first occurrence of 
 * stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, 
 * this method returns the length of the dna strand.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public int findstopcodon(String dna,int startIndex, String stopCodon)
    {
     
     //Finding the location Occurance of the stop Index after the found startIndex
     int currIndex = dna.indexOf(stopCodon, startIndex+3);
     
     int diff = currIndex - startIndex;
     
     if (diff%3 ==0)
     {
      return currIndex;
    }
    else
    {
      currIndex = dna.indexOf(stopCodon, currIndex+1);  
    }
    return dna.length();

}
    //Method to find many genes
    public String findGene(String dna,int where)
    {
     int startIndex =    dna.indexOf(where);
     if (startIndex == -1)
     {
        return "";
    }
    int taaIndex = findstopcodon(dna,startIndex,"TAA");
    
    int tagIndex = findstopcodon(dna,startIndex,"TAG");
    
    int tgaIndex = findstopcodon(dna,startIndex,"TGA");
    
    int temp = Math.min(taaIndex,tagIndex);
    int minIndex = Math.min(temp,tgaIndex);
    if (minIndex == dna.length())
    {
     return "";   
    }
    return dna.substring(startIndex, minIndex+3);
        
    }
    
    public void printAllGenes(String DNA)
    {
     //Set Start Index to 0
     int StartIndex = 0;
     
     // repeat
     while (true)
     {
        //find the next gene after startIndex
        String Currentgene = findGene(DNA, StartIndex);
        
        if (Currentgene.isEmpty())
        {
            break;
            
        }
        System.out.println(Currentgene);
        
        StartIndex = DNA.indexOf(Currentgene, StartIndex)+Currentgene.length();
        // set startIndex to past the end of the gene
        
        
    }  
    }
    public void test()
    {
     String dna  =  "ACGTATGCGGCTATAGTAA";
     System.out.println(findstopcodon(dna, 0, "TAG"));
     
        
        
    }
    
}
