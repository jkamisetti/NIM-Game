import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
/**
 * Start class takes the initial values from the user  and send the values to nim class
 * 
 * @author Jagadish
 * @version 13-04-08
 */
public class Begin extends JFrame 
{
    private JTextField gname;
    private JTextField MLIMIT;
    private JCheckBox simpleplayer,smartplayer;
    private ButtonGroup CheckButtonGroup1,CheckButtonGroup2;
    private JButton ok,cancel;
    private JCheckBox user,cpu;
    private pan myPanel;
    private Label lb1,lb2,lb3;
    private int fm=0,uin,comp=0;
    protected String store,stcomp="";
   
    /**
     * Constructor for objects of class start
     */
    public Begin()
    {
        super("BEGIN");
      
        gname=new JTextField("NIM",100);
        gname.setEditable(false);
        gname.setBackground(Color.gray);
        gname.setHorizontalAlignment(JTextField.CENTER );
        gname.setFont(new Font("Garamond",Font.BOLD,60));
        MLIMIT=new JTextField(10);
        simpleplayer=new JCheckBox("Simple CPU Player ",true);
        simpleplayer.setBackground(Color.pink);
        smartplayer=new JCheckBox("Smart CPU Player ",false);
        smartplayer.setBackground(Color.pink);
        lb1=new Label("Select Opponent Player");
        lb1.setFont(new Font("Georgia",Font.BOLD,12));
        lb1.setBackground(Color.green);
        lb2=new Label("Who Goes First");
        lb2.setFont(new Font("Georgia",Font.BOLD,12));
        lb2.setBackground(Color.green);
        lb3=new Label("Enter MaxLimit 0<MLIMIT<100");
        lb3.setBackground(Color.green);
        lb3.setFont(new Font("Georgia",Font.BOLD,12));
        user=new JCheckBox("User ",true);
        user.setBackground(Color.pink);
        cpu=new JCheckBox("CPU ",false);
        cpu.setBackground(Color.pink);
        ok=new JButton("OK");
        ok.setBackground(Color.orange);
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.orange);
        makeFrame();
        showFrame();
        
    }
   
     private void makeFrame()
    {
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add(gname);
        c.add(simpleplayer);
        c.add(smartplayer);
        c.add(lb1);
        c.add(lb2);
        c.add(lb3);
        c.add(user);
        c.add(cpu);
        Buttonlistener ban=new Buttonlistener();              // action listener class for button
        ok.addActionListener(ban);
        cancel.addActionListener(ban);
        c.add(ok);
        c.add(cancel);
        MLIMIT.addActionListener(ban);
        c.add(MLIMIT);        
        Checkboxlistener handler=new Checkboxlistener();        // action listener class for Checkbox
        simpleplayer.addItemListener(handler);
        smartplayer.addItemListener(handler);
        user.addItemListener(handler);
        cpu.addItemListener(handler);
        CheckButtonGroup1=new ButtonGroup();
        CheckButtonGroup1.add(simpleplayer);
        CheckButtonGroup1.add(smartplayer);
        CheckButtonGroup2=new ButtonGroup();
        CheckButtonGroup2.add(user);
        CheckButtonGroup2.add(cpu);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel(); 
        JPanel panel3=new JPanel();
        JPanel panel4 = new JPanel();
        panel1.add(gname);
        add(panel1,BorderLayout.NORTH);
        panel2.add(lb1);
        panel2.add(simpleplayer);
        panel2.add(smartplayer);
        panel2.add(lb2);
        panel2.add(user);
        panel2.add(cpu);
        panel2.add(lb3);
        panel2.add(MLIMIT);
        panel2.setLayout( new GridLayout(8,1));
        add(panel2,BorderLayout.CENTER);
        panel3.add(ok);
        panel3.add(cancel);
        panel3.setLayout( new GridLayout(1,2));
        add(panel3,BorderLayout.SOUTH);
      }
     private void showFrame()
    {
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,400);
        setLocationRelativeTo( null);    
        setVisible( true ); 
        
     }
     
     private class Checkboxlistener implements ItemListener
     {
         public void itemStateChanged(ItemEvent e)
         {
             if(e.getSource()==simpleplayer)
             {
               
                 fm=0;
             }
             
             if(e.getSource()==smartplayer)
             {
                
                 fm=1;
             }
             if(e.getSource()==cpu)
             {
                 comp=1;
                
                 
             }
             
         }
     } 
     
     private class Buttonlistener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             if(e.getActionCommand()=="OK")
             {
                
               
                setVisible( false );
                store=MLIMIT.getText();
               
                 if(store.equals(stcomp)) //  Checking  Input box 
                {
                    
                    Begin gm=new Begin();
                    JOptionPane.showMessageDialog(null,"Enter MaximumLimit");
                }
                else
                {
                    
                uin=Integer.parseInt(store);
                if(uin>0&&uin<100)
                 {
                   inputvariables obj=new inputvariables();
                   obj.invariables(fm,comp,uin);
                   nim mk=new nim();   
                   
                 }
                else
                 {
                   
                    Begin gm=new Begin();
                    JOptionPane.showMessageDialog(null,"Enter Maximum Limit 1<M<100");
                 }
                }
            }
            
             if(e.getActionCommand()=="Cancel")
             {
                 System.exit(0);
             }
             
             
         }
     } 
     
    
    
    public static void main(String arg[])
    {
        Begin gm=new Begin();
    }
 
    
}




