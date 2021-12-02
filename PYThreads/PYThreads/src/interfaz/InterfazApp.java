/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import java.awt.*;
import javax.swing.*;
import interfaz.PanelDatos;
import controlador.Controlador;

/**
 *
 * @author giovanni-fajardo
 */
public class InterfazApp extends JFrame
{
 // Relaciones	
    private Controlador ctrl;
    private PanelDatos pnlDatos;
     
    public InterfazApp(Controlador ctrl)
    {
      setTitle( "Taller Threads..." );  
      getContentPane( ).setLayout( null );  
            
   // Integra el controlador   
      this.ctrl = ctrl;    
      
   // Instancia atributos   
      pnlDatos = new PanelDatos(ctrl);
      pnlDatos.setBounds( 10, 10, 270, 30);  
      getContentPane( ).add( pnlDatos );
      
   // Define dimensiones de la interfaz  
      setSize( 300, 80 );     
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   // Conecta los objetos a controlar   
      ctrl.conectar(pnlDatos);
      
    }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    { System.out.println("Inicia con el main en InterfazApp");
        InterfazApp frmMain = new InterfazApp( new Controlador() );
      frmMain.setVisible( true );
        
    }
    
}
