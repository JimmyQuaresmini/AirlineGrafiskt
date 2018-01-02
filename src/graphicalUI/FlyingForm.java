package graphicalUI;

import airplanePkg.Airplane;
import javafx.concurrent.Task;
//import javax.swing.SwingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 2016-11-23.
 */
public class FlyingForm extends JFrame {// JPanel implements ActionListener
    private JProgressBar progressBar;
    private JButton btnFly;
    private JButton returnButton;
    private JPanel flygPanel;
    private JPanel flyingFormWindow;
    private JTextArea planeTextArea;
    private JPanel textPanel;

    //Timer tm = new Timer(5, this);//ms, ActionListener
    //int x = 100, velX = 10; //speed

    ArrayList<Airplane> planes = new ArrayList<>(4);

    public FlyingForm() {
        /*JFrame frame = new JFrame();
        frame.setTitle("Fly airplanes");
        frame.setContentPane(this.flygPanel);//new FlyingForm()
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/


        btnFly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //paintComponent(Graphics g);

                //System.out.println("Fly button pressed");
                //flygPanel = new JPanel();
                //flygPanel.setSize(370, 150);//200,100
                //Dimension d = new Dimension(370, 150);//384, 106
                //flygPanel.setPreferredSize(d);

                flygPanel.setLayout(new BorderLayout());
                FlightClass fc = new FlightClass();
                //JButton jb = new JButton("hello");

                flygPanel.setVisible(true);
                //flygPanel.add(jb, BorderLayout.EAST);
                flygPanel.add(fc, BorderLayout.CENTER);

                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                //Task task = new Task();//javax.swing.SwingWorker.

                //planeTextArea.setText(planes.get(0).returnPassengerList() + "\n" + planes.get(1).returnPassengerList() + "\n"
                  //      + planes.get(2).returnPassengerList() + "\n" + planes.get(3).returnPassengerList() + "\n");

                ProgressBarClass pbc = new ProgressBarClass();
                pbc.execute();

                JFrame frame = new JFrame();
                frame.setContentPane(pbc.getProgressClassMainPanel());//new ProgressBarClass()
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocation(350, 100);
                frame.setVisible(true);

                int prog = 0;
                for(int i = 0; i < 10; i++){
                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }*/
                    progressBar.setValue(prog);//10
                    prog = prog + 4700;//10;
//progressBar.updateUI();
                    //planeTextArea.setText(planeTextArea.getText() + "plane has flown " + prog + " %" + "\n");

                    /*fc.repaint();
                    flygPanel.repaint();*/
                }
                planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Blue plane to " + planes.get(0).getDestination());
                planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Red plane to " + planes.get(1).getDestination());
                planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Green plane to " + planes.get(2).getDestination());
                planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Cyan plane to " + planes.get(3).getDestination());
            }
        });

        //flygPanel = new JPanel();
        //flygPanel.setVisible(true);
        //flygPanel.paintComponents(g);
    }

    /*public void startAirplanes (){//gör till klass som implementerar runnable

    }*/

    /*public void paintComponent(Graphics g){
        //super.paintComponent(g);

        //flygPanel = new JPanel();
        //flygPanel.paintComponents(g);

        g.setColor(Color.RED);
        g.fillRect(x, 30, 50, 30);

        tm.start();//startar timern o actionlistenern(actionPerformed)
    }

    public void actionPerformed(ActionEvent e){
        x = x + velX;

        repaint();//var 5:e ms
    }*/

    public JPanel getFlygPanel() {
        return flygPanel;
    }

    public void setFlygPanel(JPanel flygPanel) {
        this.flygPanel = flygPanel;
    }

    public JPanel getFlyingFormWindow() {
        return flyingFormWindow;
    }

    public void setFlyingFormWindow(JPanel flyingFormWindow) {
        this.flyingFormWindow = flyingFormWindow;
    }

    public void setPlanes(ArrayList<Airplane> planes) {
        this.planes = planes;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        progressBar = new JProgressBar(0, 47000);//detta orsakar felet med att man inte ser nya värdet jag sätter. 10 är för litet. Blir inte procent p g a detta.
        //progressBar.setValue(0);
        progressBar.setStringPainted(true);
        //progressBar.setIndeterminate(true);

    }
}
