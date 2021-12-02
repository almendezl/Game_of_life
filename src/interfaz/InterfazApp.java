package interfaz;

import javax.swing.*;

import controlador.Controlador;
import util.Util;

public class InterfazApp extends JFrame
{   
 // Relaciones
    private PanelGrilla pnlGrilla;
    private PanelBotones pnlBotones;
    private PanelSimulacion pnlSimulacion;
    private Controlador ctrl;

 // Atributos   
    private JMenuBar mbrOpciones;
    private JMenu mnuAcerca;
    private JMenuItem mitAcerca;
    
 // Constructor
    public InterfazApp( Controlador ctrl ) 
    {
    	setTitle( "Game of Life" );  
      getContentPane( ).setLayout( null );
   
   // Enlaza el controlador	  
      this.ctrl = ctrl;
   	  
   // Instancia controles de menu
      mbrOpciones = new JMenuBar( );

   // Acerca de..
      mnuAcerca = new JMenu( );
      mnuAcerca.setMnemonic( 'A' );   	  
      mnuAcerca.setText( "About" );

      mitAcerca = new JMenuItem();
      mitAcerca.setMnemonic( 'A' );
      mitAcerca.setText( "Angie Mendez." );
      
      mnuAcerca.add( mitAcerca );
      mbrOpciones.add( mnuAcerca );
                 
      setJMenuBar( mbrOpciones );          
      
   // Instancia los paneles    
      
      pnlSimulacion = new PanelSimulacion( );
      pnlGrilla = new PanelGrilla( ctrl, pnlSimulacion );
      
      pnlBotones = new PanelBotones( ctrl);
      
      
      pnlGrilla.setBounds( 10, 10, 730, 490  );
      pnlSimulacion.setBounds( 750, 10, 150, 100 );
      pnlBotones.setBounds( 750, 130, 150, 100 );

     
   // Organizar el panel principal 
      getContentPane( ).add( pnlGrilla );
      getContentPane( ).add( pnlBotones );
      getContentPane( ).add( pnlSimulacion );
      
      
   // Conecta controlador a los paneles   
      ctrl.conectar(pnlGrilla, pnlSimulacion);
      
      setSize( 915, 555);     
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
      Util.centrarVentana( this );
    }    
    
//  Ejecucion.		
    public static void main( String args[] )
    {
        InterfazApp frmMain = new InterfazApp( new Controlador() );
      frmMain.setVisible( true );	  
    }    
		
}