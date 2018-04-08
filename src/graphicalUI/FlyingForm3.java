package graphicalUI;

import airplanePkg.Airplane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jimmy
 * 
 * ska slå ihop delar av FlyForm2...
 * ...och FlightClass.
 * FlightClass gjorde det rätt.
 * FlyForm2 hade dom flesta delarna.
 * April 2018.
 */
public class FlyingForm3 extends JFrame implements ActionListener {
    private javax.swing.JButton btnFly;
    private javax.swing.JPanel flygPanel;
    private javax.swing.JPanel flyingFormWindow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea planeTextArea;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton returnButton;
    private javax.swing.JPanel textPanel;
    
    ArrayList<Airplane> planes = new ArrayList<>(4);
    
    Timer tm;// = new Timer(5, this);//ms, ActionListener
    int x = 0, velX = 25; //speed, 100, 10
    
    int startTimeSeconds;
    boolean started = false;
    int stopTime;
    
    int progress = 0;
    int prog = 0;
    
    FlightClass fc = new FlightClass();
    
    public FlyingForm3() {
        setPreferredSize(new Dimension(600, 750));//this.
        setLocation(850, 0);
        
        //från initComponents i FlyForm2. En del borttaget då det bara går i Forms.
        //ska ändra till gridbaglayout. En del annat ändrat också.
        flyingFormWindow = new javax.swing.JPanel();
        flygPanel = new javax.swing.JPanel();
        textPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        planeTextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnFly = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        
        progressBar.setMinimum(0);
        progressBar.setMaximum(47000);
        
        progressBar.setStringPainted(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        flyingFormWindow.setLayout(new java.awt.GridLayout(4, 2));

        flygPanel.setLayout(new java.awt.GridLayout(1, 1));
        flyingFormWindow.add(flygPanel);
        
        //flyttat från btnFLy
        flygPanel.setLayout(new BorderLayout());
        flygPanel.setVisible(true);
        flygPanel.add(fc, BorderLayout.CENTER);
        //till hit

        textPanel.setLayout(new java.awt.GridLayout());

        planeTextArea.setColumns(20);
        planeTextArea.setRows(5);
        jScrollPane1.setViewportView(planeTextArea);

        textPanel.add(jScrollPane1);

        flyingFormWindow.add(textPanel);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        btnFly.setText("Fly");
        btnFly.addActionListener(this);
        jPanel1.add(btnFly);

        returnButton.setText("Return");
        returnButton.addActionListener(this);
        jPanel1.add(returnButton);

        flyingFormWindow.add(jPanel1);
        flyingFormWindow.add(progressBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flyingFormWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flyingFormWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
                
        //repaint();
        setVisible(true);//this.
    }
    
    public void startFlightTimer() {
        tm = new Timer(1000, this);
        if(started == false){
            tm.start();//startar timern o actionlistenern(actionPerformed)
            started = true;
        }

        startTimeSeconds = LocalTime.now().getSecond();
        stopTime = startTimeSeconds + 10;//47
        if (stopTime > 60){
            stopTime = stopTime - 60;
        }
        System.out.println("startTimeSeconds = " + startTimeSeconds);
        System.out.println("stopTime = " + stopTime);
        /*if(LocalTime.now().getSecond() == stopTime) { //startTimeSeconds + 47){
            tm.stop();
        }*/
    }    

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == tm){                        
            for (Airplane plane : planes) {
                if(x == 0){
                    planeTextArea.setText(planeTextArea.getText() + "\n" + plane.loadPlane());
                    planeTextArea.setText(planeTextArea.getText() + "\n" + plane.takeOff());
                }
                else if(x == 225){
                    planeTextArea.setText(planeTextArea.getText() + "\n" + plane.landing());
                    planeTextArea.setText(planeTextArea.getText() + "\n" + plane.checkAndRefuel() + "\n");
                }
            }
                        
            //progressBar.updateUI();
            prog = prog + 10;
            planeTextArea.setText(planeTextArea.getText() + "planes have flown " + prog + " %" + "\n");
            progress = progress + 4700;
            progressBar.setValue(progress);
            
            x = x + velX;
            fc.movePlanes(velX);

            fc.repaint();
            
            if(LocalTime.now().getSecond() == stopTime) { //startTimeSeconds + 47){
                tm.stop();
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }
        else if (e.getSource() == btnFly) {
            //flygPanel.setLayout(new BorderLayout());
            //flygPanel.setVisible(true);
            //flygPanel.add(fc, BorderLayout.CENTER);

            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            //planeTextArea.setText(planes.get(0).returnPassengerList() + "\n" + planes.get(1).returnPassengerList() + "\n"
            //      + planes.get(2).returnPassengerList() + "\n" + planes.get(3).returnPassengerList() + "\n");
            //flyttade dom hit för att testa april 2018
            planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Blue plane to " + planes.get(0).getDestination());
            planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Red plane to " + planes.get(1).getDestination());
            planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Green plane to " + planes.get(2).getDestination());
            planeTextArea.setText(planeTextArea.getText() + "\n" + "\n" + "Cyan plane to " + planes.get(3).getDestination());
                    
            startFlightTimer();//april 2018
        }
        else if (e.getSource() == returnButton) {
            getFlyingFormWindow().setVisible(false);
        }
    }
    
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
}
