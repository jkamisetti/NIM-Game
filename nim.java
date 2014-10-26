import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
/**
 * Nim class 
 * 
 * @author Jagadish 
 * @version 13-04-08
 */
public class nim extends JFrame
{
    Random rand=new Random();
    private JTextField MBOX,USERINPUT;
    private JButton play,abort,exit,go;
    public int start=0;
    private int check=0;
    private int uvalue,sys;
    private int x,y,i,NPLEFT;
    public int UCHOICE=5,TEMP;
    public int FIRST;
    String STR1,STR2="",mtext;
    private int num=rand.nextInt(90)+10;
    Font font;
    /**
     * Constructor for objects of class nim
     */
    public nim()
    {
     setTitle("NIM"); 
     makeFrame();     
     showFrame(); 
    }
    
    
 private void makeFrame()
    {
    
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        MBOX=new JTextField("click play button to start the Game",25);
        MBOX.setLayout( new FlowLayout() );
        MBOX.setEditable(false);
        MBOX.setBackground(Color.orange);
        c.add(MBOX);
        repaint();
        Label label=new Label("enter no.of pieces"); 
        label.setFont(new Font("Georgia",Font.BOLD,10));
        label.setBackground(Color.pink);
        c.add(label);
        USERINPUT=new JTextField(10);
        c.add(USERINPUT);
        USERINPUT.setEnabled(false);
        go=new JButton("Go");
        go.setBackground(Color.orange);
        c.add(go);
        go.setEnabled(false);
        play=new JButton("Play");
        play.setBackground(Color.orange);
        abort=new JButton("Abort");
        abort.setBackground(Color.orange);
        exit=new JButton("Exit"); 
        exit.setBackground(Color.orange);
        c.add(play);
        c.add(abort);
        c.add(exit);
        ButtonListener act=new ButtonListener();     // action listener class for buttons
        play.addActionListener(act);
        abort.addActionListener(act);
        exit.addActionListener(act);
        USERINPUT.addActionListener(act);
        go.addActionListener(act);
     
       }

    private void showFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }
    
     private class ButtonListener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()=="Play")
             {
                 NPLEFT=num;                   // NPLEFT variable shows no.of pieces left
                 start=1;
                 repaint();
                 inputvariables object=new inputvariables();
                 FIRST=object.CPUFIRST();
                 if(FIRST==1)
                   {
                        computer cpm=new computer();
                        sys=cpm.comuser(UCHOICE,NPLEFT);
                        remove(sys);
                        if(NPLEFT==1)
                         {
                           MBOX.setText("                                    U LOSE");
                           MBOX.repaint();
                           
                        }
                       else
                        {
                         USERINPUT.setEnabled(true);
                         mtext="Computer has taken"+" "+sys+" "+"Pieces"+":-) "+NPLEFT+" "+"Pieces Left";
                         MBOX.setText(mtext);
                         MBOX.repaint();
                         
                       }
                   }
                   else
                   {
                         MBOX.setText("User Chance");
                    }
                 play.setEnabled(false);
                 MBOX.repaint();
                 go.setEnabled(true);
                 USERINPUT.setEnabled(true);
               }
              if(e.getActionCommand()=="Abort")
             {
                 Begin gm=new Begin();
                 setVisible(false);
             }
             if(e.getActionCommand()=="Exit")
             {
                 System.exit(0);
             }
             
              if(e.getActionCommand()=="Go")
                {
                   /* User Chance */
                   STR1=USERINPUT.getText();
                    if(STR1.equals(STR2)) //  Checking  Input box 
                     {
                      MBOX.setText("Enter number of pieces");
                      MBOX.repaint();
                      JOptionPane.showMessageDialog(null,"Enter Number of pieces ");
                      
                     }
                     else
                     {
                        UCHOICE=Integer.parseInt(STR1);
                        user ur=new user();
                        uvalue=ur.action(UCHOICE,NPLEFT);
                        if(uvalue>0)
                         {
                          USERINPUT.setText("");
                          USERINPUT.repaint();
                          remove(UCHOICE);
                          USERINPUT.setEnabled(false);
                          MBOX.setText("Computers Chance");
                          MBOX.repaint();
                          check=1;
                          if(NPLEFT==1)
                           {
                             MBOX.setText("                                   U WIN");
                             USERINPUT.setEnabled(false);
                             MBOX.repaint();
                             check=0; 
                           }
                   
                         }
                        else if(uvalue<0)
                         {
                           
                           switch(uvalue)
                           {
                           case -1 : 
                                    MBOX.setText("The Number crossed u r MAXLIMIT ");
                                    MBOX.repaint();  
                                    JOptionPane.showMessageDialog(null,"The Number crossed u r MAXLIMIT");
                                    break;
                           case -2 :
                                    MBOX.setText("The Number must be >=1 ");
                                    MBOX.repaint();  
                                    JOptionPane.showMessageDialog(null,"The Number must be >=1");
                                    break;
                           case -3 :
                                    MBOX.setText("Select Number which is lessthan  current PileSize");
                                    MBOX.repaint();
                                    JOptionPane.showMessageDialog(null,"Select Number which is lessthan  current PileSize");
                                    break;
                            }
                         }
                     
                        if(check==1)
                        {
                        /* Computer Chance */
                        computer cpm=new computer();
                        sys=cpm.comuser(UCHOICE,NPLEFT);
                        remove(sys);
                        if(NPLEFT==1)
                         {
                           MBOX.setText("                                    U LOSE");
                           MBOX.repaint();
                           NPLEFT=0;
                        }
                       else
                        {
                         USERINPUT.setEnabled(true);
                         mtext="Computer has taken"+" "+sys+" "+"Pieces"+":-) "+NPLEFT+" "+"Pieces Left";
                         MBOX.setText(mtext);
                         MBOX.repaint();
                         check=0;
                       }
                      }
                    
                }
                 
                  
        
         }
        }
         
     }
     
    public void remove(int TEMP)         // user calling method
    {
        
        num=num-TEMP;
        repaint();
        NPLEFT=num;
        
    }
     
     public void paint(Graphics g)
    {
        
         x=52;y=332;
         g.setColor(Color.orange);
         g.drawRect(40,140, 220,220);
         g.fillRect(40,140,220,220);
         g.setColor(Color.blue);
         g.drawRect(50,150,200,200);
         g.fillRect(50,150,200,200);
         g.setColor(Color.white);
        
          if(start==1)
           {
             for(i=1;i<=num;i++)
              {
               if(x<=240)
                {
                 g.drawRect(x,y,15,15);
                 g.fillRect(x,y,15,15);
                 x=x+18;
         
                }
                else
                 {
                  x=52;
                  y=y-18;
                  g.drawRect(x,y,15,15);
                  g.fillRect(x,y,15,15);
                  x=x+18;
             
                  }
              }
       
           }
           MBOX.repaint();
           USERINPUT.repaint();
           go.repaint();
           play.repaint();
           abort.repaint();
           exit.repaint();
           
           if(num==1)      //if pile consists of single piece the game over
            {
       
                font=new Font("Times New Roman",Font.BOLD+Font.ITALIC,30);
                g.setFont(font);
                g.setColor(Color.yellow);
                g.drawString("Game Over",80,200);
                font=new Font("Times New Roman",Font.BOLD+Font.ITALIC,14);
                g.setFont(font);
                g.setColor(Color.yellow);
                g.drawString("Click Abort button to playagain",52,250);
            }
        }
    
     
     
    public static void main(String arg[])
    {
        nim nimobject=new nim();
    }
    
}





