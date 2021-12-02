/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mundo;

import controlador.Controlador;

/**
 *
 * @author giovanni-fajardo
 */
public class PyWorld 
{
  private EjemploThread ejemploThread;
  private Controlador ctrl;
  
  
  public PyWorld()
  {  System.out.println("Crea el mundo");
  }
  
  public void initThread(Controlador ctrl)
  { //System.out.println("Crea el hilo en el mundo con el metodo inicializar hilo");
      this.ctrl = ctrl;
    ejemploThread = new EjemploThread(this);      
    ejemploThread.start(10);	
  }
  
  public void pause()
  {
    ejemploThread.pause();
  }
  
  public void ejecutar(int msg)
  { ctrl.actualizar(msg+"");  
  }        
  
}
