package mundo;

import controlador.Controlador;

public class Simulation implements Runnable {

    //Relaciones
    private Controlador ctrl;
    private GameOfLife gameOfLife;

    //Atributos 
    private boolean stop;
    private boolean stopped;
    private boolean paused;
    private int mseg;

    public Simulation(Controlador ctrl, GameOfLife gameOfLife) {
        stop = stopped = paused = false;
        this.ctrl = ctrl;
        this.gameOfLife = gameOfLife;
       // System.out.println("Se creo Simulation");
    }

    public void setSleep(int mseg) {
        this.mseg = mseg;
    }

    public void start(int mseg) {
        new Thread(this, "Player").start();
        this.mseg = mseg;
        
    }

    public synchronized void pause() {
        if (paused) {
            resume();
        } else {
            paused = true;
        }
    }

    public synchronized void resume() {
        paused = false;
        notify();
    }

    public synchronized void stop() {
        stopped = true;
        notify();
        //gameOfLife.setGeneration(0);
        //gameOfLife.setPopulation(0);
        gameOfLife.reiniciarMatriz();
        ctrl.actualizar(gameOfLife.getPopulation(),gameOfLife.getGeneration());
    }

    @Override
    public void run() {

        while (!stopped) {
            try {
                synchronized (this) {
                    if (paused) {
                        wait();
                    }
                }
                Thread.sleep(this.mseg);
                gameOfLife.jugar();
                //gameOfLife.contar();
                
                
                ctrl.actualizar(gameOfLife.getPopulation(), gameOfLife.getGeneration());
                gameOfLife.setGeneration(gameOfLife.getGeneration()+1);
                //System.out.println(gameOfLife.getPopulation());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}