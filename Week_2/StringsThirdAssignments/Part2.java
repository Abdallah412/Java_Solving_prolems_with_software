
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part2 {
    
    public int findStopCodon(String dna, int startIndex, String stopcodon)
    {
        //find the stop codon being passed in 
     int currIndex = dna.indexOf(stopcodon, startIndex+3);
     System.out.println("able to reach start of while loop to find stop codon");

     while (currIndex != -1)
     {
         //check difference to see if there is an issye
         int diff = currIndex - startIndex;
         if (diff%3 == 0)
         {
             return currIndex;
            }
         else
         {
             currIndex = dna.indexOf(stopcodon, currIndex+1);
            }

        }
     
        return -1;
    }
    
    public String findGene(String dna, int where)
    {
        dna = dna.toUpperCase();
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex == -1 || where ==-1)
        {
         return "";   
        }
        System.out.println("able to find ATG now searching for dna");
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        
        int minIndex = 0;
        if (taaIndex == -1 ||(tgaIndex != -1 && tgaIndex <taaIndex))
        {
            minIndex = tgaIndex;
        }
        else
        {
            minIndex = taaIndex;
            
        }
        if (minIndex == -1 ||(tagIndex != -1 && tagIndex <minIndex))
        {
            minIndex = tagIndex;
            
        }
        if (minIndex == -1)
        {
         return "";   
        }
        System.out.println("returning found DNA");
        return dna.substring(startIndex,minIndex+3);
        
    }
    public StorageResource getAllGenes(String dna)
    {
        
        StorageResource geneList = new StorageResource();
        
        int startIndex = 0;
        System.out.println("able to reach start of while loop in getallgenes method");
        while (true)
        {
            String currentGene = findGene(dna,startIndex);
                    System.out.println("able to reach start pass curren gene variable initialization in while loop");
            if (currentGene.isEmpty())
            {
                break;
            }
            
            geneList.add(currentGene);
            
            
            startIndex = dna.indexOf(currentGene,startIndex) +currentGene.length();
            System.out.println("set new startIndex for genes");
        }
        System.out.println("able to exit while loop");
        return geneList;
    }
    
    public void printAllGenes(String dna)
    {
        //setting startIndex at 0
        int startIndex = 0;
        
        while (true)
        {
            String currentGene = findGene(dna,startIndex);
            
            if (currentGene.isEmpty())
            {
                break;
            }
            
            System.out.println(currentGene);
            
            startIndex = dna.indexOf(currentGene,startIndex) +currentGene.length();
            
        }
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
     System.out.println("total amount of g's and c's"+count);
        
     return count/dna.length();
        
    }
    
    public void processgenes(StorageResource sr)
    {
        //change this method so that it only looks at each individual gene and returns a value 
        
        //setup counters 
        int totcount = 0;
        int count = 0;
        int countr=0;
        int cmprtr = 0;
        int countctg = 0;
        //create a for each loop where you look at each value in the sr
        for(String s: sr.data())
        {
        
        totcount+=1;
        // print all the strings greater than length 9 and get total number with size more than 9
        if (s.length()>60)
        {
           System.out.println("The following has a length that is greater than 60: "+s);
           count+=1; 
           
        }
        //print the strings that have a cg ratio that is above .35 use the cgratio method and get the total number of genes with that cg ratio
        float rate = cgRatio(s);
        if(rate>.35)
        {
         System.out.println("The following has a cg ratio above .35: "+s);
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
        
        if (s.contains("CTG"))
        {
         countctg+=1;   
        }
        }
    System.out.println("The longest data has the length of "+cmprtr);
    System.out.println("Total count of DNA is: "+totcount);
    System.out.println("Total number of genes greater than 60: "+count);
    System.out.println("Total number og genes with large cg ratio: "+countr);
    System.out.println("total ctg's:"+countctg);
    
        
    }
    
    public void teston(String dna)
    {
        System.out.println("Tested on the following gene: " + dna);
        StorageResource genes = getAllGenes(dna);
        processgenes(genes);
       
        
    
        
    }
    public void test()
    {
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString().toUpperCase();
        

        teston(dna);
        
       
        
    }
}
