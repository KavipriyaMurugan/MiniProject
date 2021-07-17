import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
public class OnlineTest extends JFrame implements ActionListener {
	    JLabel l;  
	    JRadioButton jb[]=new JRadioButton[5];  
	    JButton b1,b2;  
	    ButtonGroup bg;  
	    int count=0,current=0,x=1,y=1,now=0;  
	    int m[]=new int[10];      
	    OnlineTest(String s)  
	    {  
	        super(s);  
	        l=new JLabel();  
	        add(l);  
	        bg=new ButtonGroup();  
	        for(int i=0;i<5;i++)  
	        {  
	            jb[i]=new JRadioButton();     
	            add(jb[i]);  
	            bg.add(jb[i]);  
	        }  
	        b1=new JButton("Next");  
	        b2=new JButton("Bookmark");  
	        b1.addActionListener(this);  
	        b2.addActionListener(this);  
	        add(b1);add(b2);  
	        set();  
	        l.setBounds(30,40,450,20);  
	        jb[0].setBounds(50,80,100,20);  
	        jb[1].setBounds(50,110,100,20);  
	        jb[2].setBounds(50,140,100,20);  
	        jb[3].setBounds(50,170,100,20);  
	        b1.setBounds(100,240,100,30);  
	        b2.setBounds(270,240,100,30);  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        setLayout(null);  
	        setLocation(250,100);  
	        setVisible(true);  
	        setSize(600,350);  
	    }  
	    public void actionPerformed(ActionEvent e)  
	    {  
	        if(e.getSource()==b1)  
	        {  
	            if(check())  
	                count=count+1;  
	            current++;  
	            set();    
	            if(current==9)  
	            {  
	                b1.setEnabled(false);  
	                b2.setText("Result");  
	            }  
	        }  
	        if(e.getActionCommand().equals("Bookmark"))  
	        {  
	            JButton bk=new JButton("Bookmark"+x);  
	            bk.setBounds(480,20+30*x,100,30);  
	            add(bk);  
	            bk.addActionListener(this);  
	            m[x]=current;  
	            x++;  
	            current++;  
	            set();    
	            if(current==9)  
	                b2.setText("Result");  
	            setVisible(false);  
	            setVisible(true);  
	        }  
	        for(int i=0,y=1;i<x;i++,y++)  
	        {  
	        if(e.getActionCommand().equals("Bookmark"+y))  
	        {  
	            if(check())  
	                count=count+1;  
	            now=current;  
	            current=m[y];  
	            set();  
	            ((JButton)e.getSource()).setEnabled(false);  
	            current=now;  
	        }  
	        }  
	      
	        if(e.getActionCommand().equals("Result"))  
	        {  
	            if(check())  
	                count=count+1;  
	            current++;  
	            //System.out.println("correct ans="+count);  
	            JOptionPane.showMessageDialog(this,"correct ans="+count);  
	            System.exit(0);  
	        }  
	    }  
	    void set()  
	    {  
	        jb[4].setSelected(true);  
	        if(current==0)  
	        {  
	            l.setText("Que1: Who invented Java language?");  
	            jb[0].setText("Dennis Ritchie");jb[1].setText("James Goshling");jb[2].setText("Larry Page");jb[3].setText("Serge Page");   
	        }  
	        if(current==1)  
	        {  
	            l.setText("Que2: what is the file name extension of a java Source program?");  
	            jb[0].setText(".j");jb[1].setText(".ja");jb[2].setText(".java");jb[3].setText(".jax");  
	        }  
	        if(current==2)  
	        {  
	            l.setText("Que3: what does JVM stands for?");  
	            jb[0].setText("Java Variable machine");jb[1].setText("None of the above");jb[2].setText("Java Virtual Mechanism");jb[3].setText("Java Virtual Machine");  
	        }  
	        if(current==3)  
	        {  
	            l.setText("Que4: what is JIT in Java?");  
	            jb[0].setText("Java In Time Complier");jb[1].setText("Java In Timer Thread");jb[2].setText("Java In Timer");jb[3].setText("Java In Time Runnable");  
	        }  
	        if(current==4)  
	        {  
	            l.setText("Que5: Every Statement in Java Language should end with a?");  
	            jb[0].setText("Dot or Period");jb[1].setText("Commo");jb[2].setText("SemiColon");jb[3].setText("Colon");  
	        }  
	        if(current==5)  
	        {  
	            l.setText("Que6: In Standalone Java Applications,Which method is Mandotory?");  
	            jb[0].setText("Main Method");jb[1].setText("Display Method");jb[2].setText("show Method");jb[3].setText("Print Method");  
	        }  
	        if(current==6)  
	        {  
	            l.setText("Que7: Name of a class,variable,Method or an Interface in Java language is Called? ");  
	            jb[0].setText("Value");jb[1].setText("None of above");jb[2].setText("Identifier");  
	                        jb[3].setText("Argument");  
	        }  
	        if(current==7)  
	        {  
	            l.setText("Que8:which among the following is not a valid Data Type in java?");  
	            jb[0].setText("long");jb[1].setText("float");jb[2].setText("double");  
	                        jb[3].setText("bool");         
	        }  
	        if(current==8)  
	        {  
	            l.setText("Que9: which among the following is not a data type in java?");  
	            jb[0].setText("short");jb[1].setText("long double");jb[2].setText("int");jb[3].setText("double");  
	        }  
	        if(current==9)  
	        {  
	            l.setText("Que10: Which data type among the following is an implementation of objects or OOPs?");  
	            jb[0].setText("byte");jb[1].setText("int");jb[2].setText("None of the above");  
	                        jb[3].setText("char");  
	        }  
	        l.setBounds(30,40,450,20);  
	        for(int i=0,j=0;i<=90;i+=30,j++)  
	            jb[j].setBounds(50,80+i,200,20);  
	    }  
	    boolean check()  
	    {  
	        if(current==0)  
	            return(jb[1].isSelected());  
	        if(current==1)  
	            return(jb[2].isSelected());  
	        if(current==2)  
	            return(jb[3].isSelected());  
	        if(current==3)  
	            return(jb[0].isSelected());  
	        if(current==4)  
	            return(jb[2].isSelected());  
	        if(current==5)  
	            return(jb[2].isSelected());  
	        if(current==6)  
	            return(jb[1].isSelected());  
	        if(current==7)  
	            return(jb[3].isSelected());  
	        if(current==8)  
	            return(jb[1].isSelected());  
	        if(current==9)  
	            return(jb[2].isSelected());  
	        return false;  
	    }  
	    public static void main(String s[])  
	    {  
	        new OnlineTest("Online Test Of Java");  
	    }  
	}  