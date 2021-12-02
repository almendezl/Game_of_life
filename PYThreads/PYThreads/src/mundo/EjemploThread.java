package mundo;

public class EjemploThread implements Runnable
{
// Atributos de instancia	
   private boolean paused, stopped;
   private int mseg;
   
// Relacion con el mundo
   private PyWorld pyWorld;

   public EjemploThread(PyWorld pyWorld)
   { System.out.println("Crea el hilo ");
       this.paused = this.stopped = false;
     this.pyWorld = pyWorld;
   }
   
   public void setSleep(int mseg) { this.mseg = mseg; }
   
   public void start(int mseg)
           
   { System.out.println("Se va al metodo start del hilo");
       new Thread(this, "Player").start(); this.mseg = mseg; }
   
   public synchronized void pause() 
   { if (paused) resume();
     else paused = true;    
   }

   public synchronized void resume()
   { paused = false; notify(); } 
   
   public synchronized void stop() 
   { stopped = true; notify(); }
   
   public void run()
   { int i = 0;
     while (!stopped)
     { try 
       { synchronized (this) 
	 { if (paused) 
	   {   wait(); 
           }
	 }
         Thread.sleep(this.mseg); 
         pyWorld.ejecutar(i++); // Metodo que actualiza el mundo 
       } 
       catch (InterruptedException ex)
       { System.out.println(ex);
       }
     }    
   }
}
