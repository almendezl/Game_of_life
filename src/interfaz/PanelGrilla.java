package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;
import controlador.Controlador;
 
public class PanelGrilla extends JPanel
{
 // Constantes
    private static final String BLOCK = "data/Block.gif";
    
 // Atributos de la clase 		
    private JLabel lblGrilla[][];
    private ImageIcon imgCell;
    //private ImageIcon imgBlock;
        
 // Relaciones   
    private Controlador controlador;
    private PanelSimulacion pnlSimulacion;
    /**
     * Constructor
     */    
    public PanelGrilla( Controlador controlador, PanelSimulacion pnlSimulacion) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( new GridLayout(35, 35) );
    
       this.imgCell = new ImageIcon( BLOCK );
       
    // Enlaza el Controlador y el Panle de Simulacion
       this.controlador = controlador;
       this.pnlSimulacion = pnlSimulacion;
              
    // Instancia atributos de la clase   
       lblGrilla = new JLabel[35][35];
              
    // Agrega los atributos al panel   
       for(int i=0;i<lblGrilla.length;i++)
    	for(int j=0;j<lblGrilla.length;j++)
    	{ lblGrilla[i][j] = new JLabel( "" );
    	  lblGrilla[i][j].setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
    	  lblGrilla[i][j].setHorizontalAlignment( JLabel.CENTER );
    	  lblGrilla[i][j].setVerticalAlignment( JLabel.CENTER );
    	  lblGrilla[i][j].setEnabled( true );
    	  lblGrilla[i][j].addMouseListener( new LabelClicMouse( i, j, lblGrilla[i][j], controlador, this ) );
    	  add(lblGrilla[i][j]);    	  
        }     
       //System.out.println("Se creo el panel grilla");
    }
    public void actualizarGrilla(String matrix[][]){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                if(matrix[i][j].equals("C")){
                    lblGrilla[i][j].setIcon(imgCell);
                }else{
                    lblGrilla[i][j].setIcon(null);
                }
            }
        }
    }
    public void removeLabelClicMouse() //revisar
    { for(int i=0;i<lblGrilla.length;i++)
       for(int j=0;j<lblGrilla.length;j++)
       {   lblGrilla[i][j].removeMouseListener( lblGrilla[i][j].getMouseListeners()[0] );
       }	
    }
        public void activeLabelClicMouse()
    { for(int i=0;i<lblGrilla.length;i++)
       for(int j=0;j<lblGrilla.length;j++)
       { lblGrilla[i][j].addMouseListener( new LabelClicMouse( i, j, lblGrilla[i][j], controlador, this ) );
       }	
    }
    public void concetar(PanelSimulacion pnlSimulacion) {
    	this.pnlSimulacion = pnlSimulacion;
    }
    
}

/**
 * Controlador de eventos del Mouse
 **/
class LabelClicMouse extends MouseAdapter 
{  
   private static final String BLOCK = "data/Block.gif";
   
   private JLabel label;
   private Controlador ctrl;
   private int x, y;
   private ImageIcon imgCell;
   private PanelGrilla pnlMundo;
   
   public LabelClicMouse( int x, int y, JLabel label, Controlador ctrl, PanelGrilla pnlMundo )
   { this.label = label;
     this.ctrl = ctrl;
     this.x = x; this.y = y;
     this.imgCell = new ImageIcon( BLOCK );
     this.pnlMundo = pnlMundo;
   }	
   
   public void mouseClicked(MouseEvent evento)
   {
       if (evento.isShiftDown())
       {   if (evento.isMetaDown())	// Shif+Boton derecho    	                
	       {  
	       }
	       else // Shift+Boton Izquierdo
           {	 
           }
       }
       else 
       { if (evento.isMetaDown())  // boton derecho del raton - Pone celulas o Quita celulas
         {   if ((label.getText()).equals( "" ) && label.getIcon() == null)
             {    label.setIcon( imgCell ); //System.out.println("Ponen celula: LabelClicMouse(" + x + "," + y + ")" ); 
                  ctrl.putCell( x, y, "C");
                  
             }
             else
             if (label.getIcon() != null)
             {   label.setIcon( null ); //System.out.println("Quitar celula: LabelClicMouse(" + x + "," + y + ")" ); 
                 ctrl.putCell( x, y, "-");
                 
             }      
             else
             {                
             }    
         }
        else
        { if ( evento.isAltDown() )  // boton medio del raton
          {    
          }
          else  // boton izquierdo 
          {           
          }
        }
      }
   }   
}