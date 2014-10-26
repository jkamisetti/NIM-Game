import java.awt.*;
import java.util.*;
/**
 * computer class contains the logic of cpu player
 * 
 * @author Jagadish
 * @version 13-04-08
 */
public class computer extends inputvariables
{
    // instance variables - replace the example below with your own
    public int x,CPULIMIT=20;
    private int temp;
    Random rno=new Random();
    public int comuser(int UCHOICE,int PLEFT)
    {
        
        if(player==0)             // This condion is to check simple computer palyer
        {
           if((PLEFT-1)>=MAXLIMIT)
           {
            x=(rno.nextInt(UCHOICE)+1)+UCHOICE;
            if((PLEFT-x)>0)
              {
                  return x;  
               }
               else
               {
                 int full=PLEFT-x;
                 return (x+full-1);
               }
              
            }
            else
            {
              return PLEFT-1;
            }
        }
    
            if(player==1)       //This condion is to check smart computer palyer
             {
              x=(PLEFT-1)%(MAXLIMIT+1); //numberPieces=(currentPileSize– 1)%(maxLimit +1)        
              if(x<PLEFT)
               {
                   if(PLEFT>1)
                       return x;
                   if((PLEFT-x)>0)
                     {
                       return x;  
                     }
                   else
                     {
                     int full=PLEFT-x;
                     return (x+full-1);
                     
                     }
                }
                else
                  {
                    return (x%PLEFT)+1;
                  }
      
              }
             else
               {
                  return 0;
               }
    
   }
    
}