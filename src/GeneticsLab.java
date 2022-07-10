/**
 * This creates a window with a field for entering text, and associated
 * EventButton object for responding to user actions. The program will
 * take input in DNA format and generate the DNA complement, along with a count
 * of each base occurring. Non-DNA input results in an error message.
 *
 * @author M. Allen
 * @author YOUR NAME HERE
 */

import java.awt.Color;
import javax.swing.*;

public class GeneticsLab
{
    // Instance variables: placing these here allows them to be used
    // in multiple places (like the createWindow() and buttonPressed() methods).
    private JTextField input;
    private JLabel compOutput, aOut, tOut, cOut, gOut;
    
    /**
     * Simple main(): creates the Driver object, and runs its methods to do
     * the actual heavy lifting.
     *
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        GeneticsLab genLab = new GeneticsLab();
        genLab.createWindow();
    }
    
    /**
     * Creates the graphical window and its contents.
     */
    public void createWindow()
    {
        int graphicHeight = 25;
        int windowWidth = 500;
        int windowHeight = 8 * graphicHeight;
        
        JFrame win = new JFrame();
        win.setBounds( 25, 25,  windowWidth, windowHeight );
        win.setTitle( "Genome-omatic 5000" );
        Color blizzardBlue = new Color( 172, 229, 238 );
        win.getContentPane().setBackground( blizzardBlue );
        win.setLayout( null );
        win.setResizable( false );
        win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        win.setVisible( true );
        
        JLabel inLabel = new JLabel( "DNA Strand" );
        inLabel.setBounds( 0, graphicHeight, 105, graphicHeight );
        inLabel.setHorizontalAlignment( SwingConstants.CENTER );
        win.add( inLabel,0 );
        
        input = new JTextField();
        input.setBounds( 110, graphicHeight, windowWidth - 125,
                        graphicHeight );
        win.add( input,0 );
        
        EventButton calcButton = new EventButton( this );
        calcButton.setLocation( 0, graphicHeight * 3 );
        calcButton.setSize( 105, graphicHeight );
        calcButton.setText( "Complement" );
        win.add( calcButton,0 );
        
        compOutput = new JLabel();
        compOutput.setBounds( 110, graphicHeight * 3, windowWidth - 125,
                             graphicHeight );
        compOutput.setBackground( Color.white );
        compOutput.setOpaque( true );
        win.add( compOutput,0 );
        
        JLabel as = new JLabel( "A:" );
        as.setBounds( 0, graphicHeight * 5, 105, graphicHeight );
        as.setHorizontalAlignment( SwingConstants.RIGHT );
        win.add( as,0 );
        
        aOut = new JLabel();
        aOut.setBounds( as.getWidth() + 5, graphicHeight * 5,
                       graphicHeight * 2,
                       graphicHeight );
        aOut.setBackground( Color.white );
        aOut.setOpaque( true );
        aOut.setHorizontalAlignment( SwingConstants.CENTER );
        win.add( aOut,0 );
        
        JLabel cs = new JLabel( "C:" );
        cs.setBounds( aOut.getX() + aOut.getWidth() + 10, graphicHeight * 5,
                     graphicHeight, graphicHeight );
        cs.setHorizontalAlignment( SwingConstants.RIGHT );
        win.add( cs,0 );
        
        cOut = new JLabel();
        cOut.setBounds( cs.getX() + cs.getWidth() + 5, graphicHeight * 5,
                       graphicHeight * 2,
                       graphicHeight );
        cOut.setBackground( Color.white );
        cOut.setOpaque( true );
        cOut.setHorizontalAlignment( SwingConstants.CENTER );
        win.add( cOut,0 );
        
        JLabel gs = new JLabel( "G:" );
        gs.setBounds( cOut.getX() + cOut.getWidth() + 10, graphicHeight * 5,
                     graphicHeight, graphicHeight );
        gs.setHorizontalAlignment( SwingConstants.RIGHT );
        win.add( gs,0 );
        
        gOut = new JLabel();
        gOut.setBounds( gs.getX() + gs.getWidth() + 5, graphicHeight * 5,
                       graphicHeight * 2,
                       graphicHeight );
        gOut.setBackground( Color.white );
        gOut.setOpaque( true );
        gOut.setHorizontalAlignment( SwingConstants.CENTER );
        win.add( gOut,0 );
        
        JLabel ts = new JLabel( "T:" );
        ts.setBounds( gOut.getX() + gOut.getWidth() + 10, graphicHeight * 5,
                     graphicHeight, graphicHeight );
        ts.setHorizontalAlignment( SwingConstants.RIGHT );
        win.add( ts,0 );
        
        tOut = new JLabel();
        tOut.setBounds( ts.getX() + ts.getWidth() + 5, graphicHeight * 5,
                       graphicHeight * 2,
                       graphicHeight );
        tOut.setBackground( Color.white );
        tOut.setOpaque( true );
        tOut.setHorizontalAlignment( SwingConstants.CENTER );
        win.add( tOut,0 );
        
        win.repaint();
    }
    
    /**
     * When a related EventButton is pressed, it will call this method.
     *
     * The code will read in user input and compute the DNA complement, along
     * with counts of each base occurring in the input strand. Non-DNA input
     * results in an error message.
     */
    public void buttonPressed()
    {
        

    	
    	String inp = input.getText();
    	inp = inp.toUpperCase();
    	String output = "";
    	
    	int numA = 0 ;
    	int numC = 0 ;
    	int numG = 0 ; 
    	int numT = 0 ;
    	
    	for ( int i  = 0 ; i < inp.length() ; i++)
    	{
    		if ( inp.charAt(i) == 'A' || inp.charAt(i) == 'C' || inp.charAt(i) == 'G' || inp.charAt(i) == 'T' )
    		{
    			if ( inp.charAt(i) == 'A')
    			{
    				output = output + "T" ;
    				numA++;
    			}
    			
    			if ( inp.charAt(i) == 'T')
    			{
    				output = output + "A" ;
    				numT++;
    			}
    			
    			if ( inp.charAt(i) == 'C')
    			{
    				output = output + "G" ;
    				numC++;
    			}
    			
    			if ( inp.charAt(i) == 'G')
    			{
    				output = output + "C" ;
    				numG++;
    			}
    			compOutput.setText(output);
    			aOut.setText("" + numA);
    			tOut.setText("" + numT);
    			cOut.setText("" + numC);
    			gOut.setText("" + numG);
    			
    		}
    		
    		else {
    			output = output + "Error";
    			compOutput.setText(output);
    		}
    			
    	}
    }
}