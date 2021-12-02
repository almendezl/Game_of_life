package interfaz;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelSimulacion extends JPanel {
    //Atributos
    private JLabel lblGeneration;
    private JLabel lblValGeneration;
    private JLabel lblPopulation;
    private JLabel lblValPopulation;

    public PanelSimulacion() {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Simulation")));//borde y titulo del panel
        setLayout(new GridLayout(2,2));//forma de organizar el panel

        //instanciar los labels
        lblGeneration = new JLabel("Generation: ");
        lblValGeneration = new JLabel("");
        lblPopulation = new JLabel("Population: ");
        lblValPopulation = new JLabel("");

        //Agregar lo labels al panel
        add(lblGeneration);
        add(lblValGeneration);
        add(lblPopulation);
        add(lblValPopulation);
        //System.out.println("Se creo el panel simulacion");
    }

    public void sendGeneration(String generation) {
        lblValGeneration.setText(generation);
    }

    public void sendPopulation(String population) {
        lblValPopulation.setText(population);
    }
}
