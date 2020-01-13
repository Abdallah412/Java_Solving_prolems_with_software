/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    public String CountryInfo(CSVParser parser, String country)
    {
     for (CSVRecord record: parser)
     {
         String countrysearch = record.get("Country");
         if (countrysearch.contains(country))
         {
             String exports = record.get("Exports");
             String value = record.get("Value (dollars)");
             String found = country+": "+ exports+": "+ value;
             return found;
            }
         
        }
        return "NOT FOUND";
    }
    public void listExportersTwoProducts(CSVParser parser, String exportitem1,String exportitem2)
    {
        for(CSVRecord record:parser)
        {
         String export = record.get("Exports");
         //check to see if exports contain both item1 and item2, print countries
         if (export.contains(exportitem1)&&export.contains(exportitem2))
         {
             String country = record.get("Country");
             System.out.println(country);
            }
            
        }
        
    }
    public int numberOfExporters(CSVParser parser,String exportItem)
    {
     //Initialize counter
     int count=0;
     //get the exports
     for(CSVRecord record: parser)
     {
     String export = record.get("Exports");
     //read the export items and count if they contain exportItem
     if(export.contains(exportItem))
     {
         count+=1;
        }
    }
    //print number of countries that contain exported item
    System.out.println("Total number of countries that export "+ exportItem+" are: "+ count);
     //return number of countries
        return count;
    }
    public void bigexporters(CSVParser parser, String amount)
    {
     //for each value in the CSV file  
     for (CSVRecord record: parser)
     {
     //observe the value in dollars
     String value = record.get("Value (dollars)");
     if(value.length()>amount.length())
     {
         //if the value in dollars is greater than the length that is being passed through then print
         String country = record.get("Country");
         System.out.println(country+": "+value);

    }
    }
}
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(CountryInfo(parser,"Germany"));
        //listExportersTwoProducts(parser,"cotton","flowers");
        //numberOfExporters(parser,"cocoa");
        bigexporters(parser,"$999,999,999,999");
        
    }
    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
}
