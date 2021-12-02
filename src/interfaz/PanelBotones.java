package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import java.awt.GridLayout;

public class PanelBotones extends JPanel implements ActionListener {
    //Atributos

    private JButton btnStart;
    private JButton btnStop;
    private JButton btnPause;

    //Relaciones
    private Controlador ctrl;

    public PanelBotones(Controlador ctrl) {

        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder(""))); //borde del panel
        setLayout(new GridLayout(3,1));//forma de organizar el panel

        this.ctrl = ctrl;

        //instanciar los atributos
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnPause = new JButton("Pause");

        btnStart.setBackground(Color.WHITE);
        btnStop.setBackground(Color.WHITE);
        btnPause.setBackground(Color.WHITE);

        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        btnPause.addActionListener(this);
        
        btnStop.setEnabled(false);
        btnPause.setEnabled(false);

        //agregar los botones al panel
        add(btnStart);
        add(btnPause);
        add(btnStop);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            ctrl.start();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            btnPause.setEnabled(true);
        }
        if (e.getSource() == btnStop) {
            ctrl.stop();
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            btnPause.setEnabled(false);
        }
        if (e.getSource() == btnPause) {
            ctrl.pause();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            btnPause.setText(btnPause.getText().equals("Pause")? "Continue":"Pause");
            btnPause.setEnabled(true);
        }
    }
}
