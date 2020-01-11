
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
     DirectoryResource dr = new DirectoryResource();
     for (File f:dr.selectedFiles())
     {
         FileResource fr = new FileResource(f);
         CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
              System.out.println(currentRow.get("DateUTC")+" :"+currentRow.get("TemperatureF"));
         coldestsofar = getColdestOfTwo(currentRow,coldestsofar);
         //for file name call file.getName();
         solution = f.getName();
         
        }

     return    "Coldest weather was "+ coldestsofar.get("TemperatureF")+" at time "+ coldestsofar.get("TimeEST")+" in file "+solution;
        
    }
    public void testfileWithColdestTemperature()
    {
     System.out.println(fileWithColdestTemperature());

     
     
        
        
    }
}
