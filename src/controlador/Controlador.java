/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaz.*;
import javax.swing.JLabel;
import mundo.GameOfLife;

public class Controlador {
    // Relaciones
    private PanelGrilla pnlGrilla;
    private GameOfLife gameOfLife;
    private PanelSimulacion pnlSimulacion;

    // Atributos
    // Constructor  
    public Controlador() {
        gameOfLife = new GameOfLife(this);
     //   System.out.println("Se creo el controlador ");
    }

    public void conectar(PanelGrilla pnlGrilla, PanelSimulacion pnlSimulacion) {

        this.pnlGrilla = pnlGrilla;
        this.pnlSimulacion = pnlSimulacion;
    }

    public void putCell(int x, int y, String cell) {
        gameOfLife.ponerCelula(x, y, cell);
        pnlSimulacion.sendPopulation(gameOfLife.getPopulation() + "");
    }

    public void actualizar(int population, int generation) {
        pnlGrilla.actualizarGrilla(gameOfLife.getMatrix());
        //gameOfLife.contar();
        //System.out.println(gameOfLife.getPopulation());
        pnlSimulacion.sendPopulation(population+"");
        pnlSimulacion.sendGeneration(generation+"");
    }

    // metodos botones
    public void start() {
        pnlGrilla.removeLabelClicMouse();
        gameOfLife.start();
        
    }

    public void stop() {
        //System.out.println("clic btn stop");
        pnlGrilla.activeLabelClicMouse();
        gameOfLife.stop();
    }

    public void pause() {
        //System.out.println("Clic btn pause");
        gameOfLife.pause();
    }
}