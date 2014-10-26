
/**
 * User class consists of user related operations i.e randomly picking the pieces from pile.
 * 
 * @author Jagadish 
 * @version 13-04-08
 */

public class user extends inputvariables
{
 
/**
   * @param  MAXLIMIT is the Maximumlimit given by the user ,it is declared as ststic because 
     it is initialized only once when the game started. 
     
 */
       
    public int action(int num,int current) //action method perform User operation
    {
       
        if(num<current)
        {
            if(num>0)
            {
              if(num<=MAXLIMIT)
                return num;
              else
                return -1;
            }
        
           else
           {
              return -2;
           }
       }
        else 
        {
            return -3;
        }
    }
    
}
