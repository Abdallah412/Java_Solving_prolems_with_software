
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.URLResource; 

public class Part4 {
    
    public String readURLS(String URL)
    {
        URLResource ur = new URLResource(URL);
        for (String s: ur.lines())
        {
            String lc = s.toLowerCase();
         if (lc.indexOf("youtube.com")!=-1)
         {
             System.out.println(s);
            }
            
        }
     
        return "completed analysis of webpage";
    }
    public void test()
    {
      String URL = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
      System.out.println(readURLS(URL));
        
    }

}
