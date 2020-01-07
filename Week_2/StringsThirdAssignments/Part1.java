
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.* ;

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
    public StorageResource getallgenes(String dna)
    {
     StorageResource Store = new StorageResource();
        //Set Start Index to 0
     int StartIndex = 0;
     
     // repeat
     while (true)
     {
        //find the next gene after startIndex
        String Currentgene = findGene(dna, StartIndex);
        
        if (Currentgene.isEmpty())
        {
            break;
            
        }
        System.out.println(Currentgene);
        Store.add(Currentgene);
        
        StartIndex = dna.indexOf(Currentgene, StartIndex)+Currentgene.length();
        // set startIndex to past the end of the gene
        
        
        
        
    }
    
    return Store;
    
    }
    
    public float cgRatio(String dna)
    {
     int Ccount = 0;
     int Gcount = 0;
     int Gindex = dna.indexOf("G");
     int Cindex = dna.indexOf("C"); 
     while(Cindex!= -1)
     {
         Ccount+=1;
         Cindex = dna.indexOf("C", Cindex+1); 
        }
     while (Gindex!=-1)
     {
         Gcount+=1;
         Gindex= dna.indexOf("G",Gindex+1);
         
        }
     float count = Gcount+Ccount;
     System.out.println(count);
        
     return count/dna.length();
        
    }
    
    public void processgenes(StorageResource sr)
    {
        //change this method so that it only looks at each individual gene and returns a value 
        
        //setup counters 
        int count = 0;
        int countr=0;
        int cmprtr = 0;
        //create a for each loop where you look at each value in the sr
        for(String s: sr.data())
        {
        
        
        // print all the strings greater than length 9 and get total number with size more than 9
        if (s.length()>9)
        {
           System.out.println("The following has a length that is greater than 9"+s);
           count+=1; 
           
        }
        //print the strings that have a cg ratio that is above .35 use the cgratio method and get the total number of genes with that cg ratio
        float rate = cgRatio(s);
        if(rate>.35)
        {
         System.out.println("The following has a cg ratio above .35"+s);
         countr+=1;
        }
        
        //print the length of the longest gene is the sr
        
        if(s.length()>cmprtr)
        {
         cmprtr = s.length();
         
        }
        
        else
        {
            System.out.println("none of the genes fell within the range");
        }
        }
    System.out.println("The longest data has the length of "+cmprtr);
    
        
    }
    public void testprocessgenes()
    {
     String dna = "ACGTATGCGCGGCTAATAGTAAATGTAGGTAATGGCCTAA";
     System.out.println(findGene(dna,0));
     System.out.println("Tested method and above are the results");
     
        
    }
    public void test()
    {
     String dna  =  "ACGTATGCGGCTATAGTAAATGTAGGTAATGGCCTAA";
     StorageResource gene = getallgenes(dna);
     for (String s: gene.data())
     {
         System.out.println(s);
         
        }
     
        
        
    }
    
}
