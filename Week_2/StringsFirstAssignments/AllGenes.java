
/**
 * Write a description of AllGenes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllGenes {
    public int findStopCodon(String    dna, int startIndex, String stopCodon)
    {
     int currIndex = dna.indexOf(stopCodon, startIndex+3);
     while (currIndex !=-1)
     {
         int diff = currIndex-startIndex;
         
         if (diff%3 ==0)
         {
             return currIndex;
            }
         else {
             dna.indexOf(stopCodon,currIndex+1);
             
             
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna,int where)
    {
     int startIndex =    dna.indexOf(where);
     if (startIndex == -1)
     {
        return "";
    }
    int taaIndex = findStopCodon(dna,startIndex,"TAA");
    
    int tagIndex = findStopCodon(dna,startIndex,"TAG");
    
    int tgaIndex = findStopCodon(dna,startIndex,"TGA");
    
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

}
