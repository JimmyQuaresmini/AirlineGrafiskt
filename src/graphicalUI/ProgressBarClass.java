package graphicalUI;

import javax.swing.*;

/**
 * Created by Jimmy on 2016-11-24.
 */
public class ProgressBarClass extends SwingWorker<Void, Void>{
    private JProgressBar progressBarFlying;
    private JTextArea textAreaPlanes;
    private JPanel progressClassMainPanel;

    /*public ProgressBarClass(){
        initComponents();
    }*/

    @Override
    protected Void doInBackground() throws Exception {
        int seconds = 0;
        //progressBarFlying.setIndeterminate(false);
        for(seconds = 0; seconds < 10; seconds++){
            progressBarFlying.setValue(seconds * 10);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
            textAreaPlanes.setText(textAreaPlanes.getText() + "planes have flown " + (seconds + 1) + " seconds" + "\n");
        }

        return null;
    }

    @Override
    public void done(){
        progressBarFlying.setValue(100);
        JOptionPane.showMessageDialog(null, "Planes arrived at destination!");
    }

    public JPanel getProgressClassMainPanel() {
        return progressClassMainPanel;
    }
}
