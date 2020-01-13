
/**
 * Write a description of Coldesttemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Coldesttemp {
    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        //null variable of coldest so far
     CSVRecord coldestsofar = null;
     
     //look at each temp in file and compare using a compare method
     for(CSVRecord currentRow:parser)
     {

         coldestsofar = getColdestOfTwo(currentRow,coldestsofar);

        }
        
     return coldestsofar;   
    }
    
    
    public CSVRecord getColdestOfTwo(CSVRecord currentRow, CSVRecord coldestsofar)
    {
     if (coldestsofar == null)
     {
         coldestsofar = currentRow;
        }
     else
     {
         double currentTemp =Double.parseDouble(currentRow.get("TemperatureF"));
         double coldestTemp = Double.parseDouble(coldestsofar.get("TemperatureF"));
         double invalid = -9999;

         
         if (currentTemp<coldestTemp && currentTemp!=invalid)
         {
          coldestsofar = currentRow;
                 
        }
        }
        return coldestsofar;
    }
    
    public void testcoldestHourInFile()
    {
     FileResource fr = new FileResource("nc_weather/2015/weather-2015-09-08.csv");
     CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
     System.out.println("Coldest temperature was " + coldest.get("TemperatureF") +
                   " at " + coldest.get("TimeEDT"));
     
        
    }
    
    public String fileWithColdestTemperature()
    {
     CSVRecord coldestsofar = null;
     String solution = null;
     String path = null;
     DirectoryResource dr = new DirectoryResource();
     for (File f:dr.selectedFiles())
     {
         FileResource fr = new FileResource(f);
         CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
         coldestsofar = getColdestOfTwo(currentRow,coldestsofar);
         //for file name call file.getName();
         solution = f.getName();
         path = f.getPath();
         
         
        }
     //print out the corrsponding values in the solution file
     //String filename = String.ParseSting(solution);
     System.out.println(    "Coldest day was in file "+solution);
     System.out.println("Coldest temperature was: "+coldestsofar.get("TemperatureF")+ "Coldest day was: "+coldestsofar.get("DateUTC"));
     System.out.println("All the Temperatures on the coldest day were:");
     FileResource ir = new FileResource(path);
     CSVParser parser = ir.getCSVParser();
     for (CSVRecord record:parser)
     {
         String date = record.get("DateUTC");
         String time = record.get("TimeEST");
         String temp = record.get("TemperatureF");
         System.out.println(date+" "+time+": "+temp);
         
        }
     return "Done";
        
    }
    public void testfileWithColdestTemperature()
    {
     System.out.println(fileWithColdestTemperature());

     
     
        
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        //look at the data and find the lowest humidity
        //first declare a null humidity variable 
        CSVRecord leasthumid = null;
        String invalid = "N/A";
        //next for each value of the humidity do something 
        for(CSVRecord currentRow:parser)
        {
         
         
         //compare the values of humidity  
         String currentstrhum = (currentRow.get("Humidity"));
         if (leasthumid == null && !currentstrhum.contains(invalid))
         {
             leasthumid = currentRow;
            }
            
         //if there is a tie in the lowest humidity then print the first occurance - nothing special just have the comparison > and no equal to
         double currenthumidity = Double.parseDouble(currentRow.get("Humidity"));
         double leasthumidity = Double.parseDouble(leasthumid.get("Humidity"));
         if (currenthumidity<leasthumidity && !currentstrhum.contains(invalid))
         {
             leasthumid = currentRow;
             
            }

    
        
    }
    return leasthumid;
}

public void testLowestHumidityInFile()
{
 FileResource fr = new FileResource();
 CSVParser parser = fr.getCSVParser();
 CSVRecord csv = lowestHumidityInFile(parser);
 System.out.println("lowest humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    
}

public CSVRecord lowestHumidityInManyFiles()
{
 DirectoryResource dr = new DirectoryResource();
 CSVRecord leasthumid = null;
 for(File f: dr.selectedFiles())
 {
     FileResource fr = new FileResource(f);
     leasthumid = lowestHumidityInFile(fr.getCSVParser());
        //next for each value of the humidity do something 
       
        
    }
     
     
     return leasthumid;
    }
    

    public void testlowestHumidityInManyFiles()
{
 System.out.println(lowestHumidityInManyFiles());   
 //System.out.println("lowest humidity is "+humidity.get("Humidity")+" at time"+humidity.get("DateUTC"));   
}


public double averageTemperatureInFile(CSVParser parser)
{
    double sum = 0;
    double average = 0;
    int count =0;
    for (CSVRecord currentRow:parser)
    {
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
         sum = sum+ currentTemp;
         count+=1;
        }
        return sum/count;
    }
public void testAverageTemperatureInFile()
{
  FileResource fr = new FileResource();
 CSVParser parser = fr.getCSVParser();
 System.out.println("Average temperature was "+averageTemperatureInFile(parser));  
    
}

public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
{
    double sum = 0;
    double average =0;
    int count = 0;
    for (CSVRecord currentRow:parser)
    {
     double currenthum = Double.parseDouble(currentRow.get("Humidity"));
     double currenttemp = Double.parseDouble(currentRow.get("TemperatureF"));
     if (currenthum>= value)
     {
         sum = sum+currenttemp;
         count+=1;
        }
       
    }
    if (count ==0)
    {
        System.out.println("No temperatures with that Humidity");
    }
    average = sum/count;
    
    return average;
}

public void testaverageTemperatureWithHighHumidityInFile()
{
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    int value = 80;
    System.out.println("Average temperature with humidity of value: " + value + " was "+averageTemperatureWithHighHumidityInFile(parser,value));
    
    
    
}
}

