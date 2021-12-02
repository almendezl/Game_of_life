package controlador;

import interfaz.PanelDatos;
import mundo.*;



/*
 * Controaldor.java
 * Patron Interfaz - Controlador  - Mundo
 * @author Giovanni Fajardo Utria
 * @version 1.0
 */
public class Controlador
{
// Atributos	
   private PanelDatos pnlDatos;
   private PyWorld pyWorld;  
   
/**
 * Constructor por defecto
 */	
  public Controlador()
  {
      System.out.println("Crea un controlador ");
      pyWorld = new PyWorld();
  }
      
  public void conectar(PanelDatos pnlDatos)
  { this.pnlDatos = pnlDatos;
    pyWorld.initThread(this); System.out.println("Inicializa el hilo desde el mundo");
      System.out.println("Paso por controlador en el metodo conectar");
  }

  
  
/* -----------------------------------------------------------------------------  
 * Requerimientos funcionales
 * ----------------------------------------------------------------------------- 
 */
  
   public void pause()
   { System.out.println("Paso por el controlador en pause");
       pyWorld.pause();	   
   }
   
   public void actualizar(String msg)
   { System.out.println("metodo actualizar del controlador ");
       this.pnlDatos.setMessage(msg);     
   }        
           
}