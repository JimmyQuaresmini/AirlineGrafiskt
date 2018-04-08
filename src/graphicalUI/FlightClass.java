package graphicalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * Created by Jimmy on 2016-11-23.
 */
public class FlightClass extends JPanel implements ActionListener {
    Timer tm;// = new Timer(5, this);//ms, ActionListener
    int x = 0, velX = 25; //speed, 100, 10

    //LocalTime seconds;
    int startTimeSeconds;
    boolean started = false;
    int stopTime;

    public FlightClass(){
        //this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //Dimension d = new Dimension(300, 150);//200,100
        //this.setPreferredSize(d);
        //this.setSize(300, 150);


        //this.paintComponent(getGraphics());

        /*tm = new Timer(1000, this);
        if(started == false){
            tm.start();
            started = true;
        }

        startTimeSeconds = LocalTime.now().getSecond();
        stopTime = startTimeSeconds + 10;//47
        if (stopTime > 60){
            stopTime = stopTime - 60;
        }
        System.out.println("startTimeSeconds = " + startTimeSeconds);
        System.out.println("stopTime = " + stopTime);
        if(LocalTime.now().getSecond() == startTimeSeconds + 47){
            tm.stop();
        }*/
        this.setVisible(true);
    }
    
    //ny april 2018 av det som var i konstruktorn
    public void startFlightTimer() {
        tm = new Timer(1000, this);
        if(started == false){
            tm.start();
            started = true;
        }

        startTimeSeconds = LocalTime.now().getSecond();
        stopTime = startTimeSeconds + 10;//47
        if (stopTime > 60){
            stopTime = stopTime - 60;
        }
        System.out.println("startTimeSeconds = " + startTimeSeconds);
        System.out.println("stopTime = " + stopTime);
        if(LocalTime.now().getSecond() == startTimeSeconds + 47){
            tm.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //flygPanel = new JPanel();
        //flygPanel.paintComponents(g);

        g.setColor(Color.BLUE);//.RED
        g.fillRect(x, 30, 30, 20);//30 som sista siffra först. //50, 70 som sista 2 siffror
        g.setColor(Color.RED);
        g.fillRect(x, 60, 30, 20);//30
        g.setColor(Color.GREEN);
        g.fillRect(x, 90, 30, 20);//30
        g.setColor(Color.CYAN);
        g.fillRect(x, 120, 30, 20);//30

        //tm.start();//startar timern o actionlistenern(actionPerformed)

        System.out.println();
        int secNow = LocalTime.now().getSecond();
        System.out.println("secNow = " + secNow);
        System.out.println();
        if(secNow == stopTime){
            tm.stop();
        }

        //x = x + velX;//kopierade hit när jag ville testa köra utan timer
    }

    public void actionPerformed(ActionEvent e){
        x = x + velX;

        repaint();//var 5:e ms
    }
    
    public void movePlanes(int speed) {
        x = x + speed;
    }
    
    public void setX (int newX) {
        this.x = newX;
    }
}
