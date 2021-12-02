package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.Controlador;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel implements ActionListener
{
 // Constantes
	
 // Atributos de la clase 		
    private JLabel lblThread;
    private JButton btnHello;
    
 // Relaciones   
    private Controlador ctrl;
    
    /**
     * Constructor
     */    
    public PanelDatos(Controlador ctrl) 
    {   
        System.out.println("Crea el panel de datos");
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( null );
    
    // Integra el Controlador   
       this.ctrl = ctrl;
       
    // Instancia atributos de la clase   
 
       lblThread = new JLabel( "Thread" ); 
       lblThread.setBounds( 10, 10, 200, 10 );
       
       btnHello = new JButton(" Pause ");
       btnHello.setBounds( 100, 5, 150, 20 );
       btnHello.addActionListener(this);
       
    // Agrega los atributos al panel   
       add( lblThread ); add(btnHello);
    }

    /**
     * Actualiza el texto del label
     * @param msg
     */
    public void setMessage ( String msg )
    { lblThread.setText(msg);	   
    }

    @Override
    public void actionPerformed(ActionEvent arg0) 
    { ctrl.pause();  
      JOptionPane.showMessageDialog(null, "the thread was paused, clic in Aceptar for resume." , "Thread",  JOptionPane.INFORMATION_MESSAGE); 
      ctrl.pause();
    }
    
}