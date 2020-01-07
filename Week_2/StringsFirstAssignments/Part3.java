
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurances(String Stringa, String Stringb)
    {
        int Count = 0;
        int first = Stringb.indexOf(Stringa);
        if (first != -1)
        {
        Count++;
    }
    else
    {
     return false;   
    }
    int second = Stringb.indexOf(Stringa,first+Stringa.length());
    if (second != -1)
    {
     Count++;   
    }
    else
    {
        return false;
    }
    
    return true;
        
    }
    
    public String lastPart(String Stringa, String Stringb)
    {
         int first = Stringb.indexOf(Stringa);
        if (first != -1)
        {
            return Stringb.substring(first,Stringb.length());
    }
    else
    {
     return "";   
    }
    }
    
    public void test()
    {
     String Stringa = "by";
     String Stringb = "by the way I will not allow for a bye week";
     System.out.println(twoOccurances(Stringa,Stringb));
     
     Stringa = "fart";
     Stringb = "i gotchu";
     System.out.println(twoOccurances(Stringa,Stringb));
     
     Stringa = "fart";
     Stringb = "i gotchu only on occurance of fart";
     System.out.println(twoOccurances(Stringa,Stringb));
     
     Stringa = "by";
     Stringb = "by the way I will not allow for a bye week";
     System.out.println(lastPart(Stringa,Stringb));
     
    }

}
