/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("data/yob2014.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender)
    {
    FileResource fr = new FileResource("data/yob"+year+".csv");
    int count = 0;
    int totalBirths = 0;
    int totalBoys = 0;
    int totalGirls = 0;
    int rank = 0;
    
    for (CSVRecord rec : fr.getCSVParser(false)) {

        totalBirths += 1;
        if (rec.get(1).equals("M")) {
            totalBoys += 1;
        }
        else {
            totalGirls += 1;
        }
        }
        
        
            // find the name and get the total births, currentIndex from the total females/males depending on what is chosen 
    for(CSVRecord record: fr.getCSVParser(false))
    {
       count+=1;
        if (record.get(0).equals(name)&&record.get(1).equals(gender))
        {
            
            if (record.get(1).equals("F"))
            {
             rank = count;   
            }
            if (record.get(1).equals("M"))
            {
             
             rank = count-totalGirls;
                
            }
            
       }
      
        
       } 
       if (rank == 0)
       {
           return -1;
        }

       return rank; 
}


public void testrank () {
        //FileResource fr = new FileResource();
        //FileResource fr = new FileResource("data/yob2014.csv");
        System.out.println(getRank(2012,"Mason","F"));
    }
public String getName(int year,int rank,String gender)
{
    FileResource fr = new FileResource("data/yob"+year+".csv");
    int count = 0;
    int totalBirths = 0;
    int totalBoys = 0;
    int totalGirls = 0;
    int rankcmprtr = 0;
    int femalerank = 0;
    int malerank = 0;
    String name = null;
    
    for (CSVRecord rec : fr.getCSVParser(false)) {

        totalBirths += 1;
        if (rec.get(1).equals("M")) {
            totalBoys += 1;
        }
        else {
            totalGirls += 1;
        }
        }
        
        
            // find the name and get the total births, currentIndex from the total females/males depending on what is chosen 
    for(CSVRecord record: fr.getCSVParser(false))
    {
       count+=1;
        if (record.get(1).equals(gender))
        {
            
            if (record.get(1).equals("F"))
            {
             femalerank = count;   
            if (femalerank == rank)
            {
              name=record.get(0);  
            }
            }
            if (record.get(1).equals("M"))
            {
             
             malerank = count-totalGirls;
             if (malerank==rank)
            {
                name = record.get(0);
            }   
            }
            
            
       }
       
        
       } 
       if (name==null)
       {
           return "No Name";
        }

       return name; 
    
    
}
public void testgetName()
{
 System.out.println(getName(2012,2,"M"));   
    
}
public String whatIsNameInYear(String name, int year, int newYear,String gender)
{
 int ogrank = getRank(year,name,gender);
 String newname = getName(newYear,ogrank,gender);
    
 return name +" in "+year+" would have been called "+newname+" in "+newYear;   
}
public void testwhatIsNameInYear()
{
 System.out.println(whatIsNameInYear("Mason",2012,2014,"M"));   
}

public int yearOfTheHighestRank(String name, String gender)
{
    int currentrank = 0;
    int yearofwinner = 0;
    DirectoryResource dr = new DirectoryResource();
 for(File f:dr.selectedFiles())
 {
     FileResource fr = new FileResource(f);
     String filename = f.getName();
     String year=filename.replaceAll("[^0-9]", "");
     int fileyear = Integer.parseInt(year);
     int testrank = getRank(fileyear,name,gender);
     if (currentrank ==0)
     {
         currentrank = testrank;
         yearofwinner = fileyear;
        }
     if (currentrank>testrank)
     {
         currentrank = testrank;
         yearofwinner = fileyear;
        }
    }
 //returns the year of the highest rank of the name that is being passed throught the file
 System.out.println(currentrank);
 return yearofwinner;
}

public void testyearOfTheHighestRank()
{
 System.out.println(yearOfTheHighestRank("Mason","M"));   
    
}
}
