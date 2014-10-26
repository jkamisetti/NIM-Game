
/**
 * inputvariables class takes the values from begin class, these values can be share by other classes
 * 
 * @author jagadish 
 * @version 13-04-08
 */
public class inputvariables
{
    // instance variables - replace the example below with your own
    public static int player,first,MAXLIMIT;

    /**
     * Constructor for objects of class inputvariables
     */
    public void invariables(int fm,int comp, int uin)
    {
        player=fm;
        first=comp;
        MAXLIMIT=uin;
       
    }
    public int CPUFIRST()
    {
        return first; 
    }

   
    
}
