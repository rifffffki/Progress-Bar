import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JFrame {
    private JProgressBar progressBar; 
    private JButton nextButton;
    private JButton prevButton;
    private int progress = 0; 
    
    public ProgressBar() { 
        setTitle("Progress Bar");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));  
    
        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(300, 30));
        progressBar.setStringPainted(true); 
        progressBar.setValue(0);
        
        JPanel buttonPanel = new JPanel();
        
        nextButton = new JButton("Increase (+10%)");
        nextButton.addActionListener(e -> advanceProgress());
        
        prevButton = new JButton("Decrease (-10%)");
        prevButton.addActionListener(e -> decreaseProgress());
        prevButton.setEnabled(false); 
        
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        
        add(progressBar);
        add(buttonPanel);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void advanceProgress() {
        if (progress < 100) {
            progress += 10; 
            progressBar.setValue(progress);
            
            prevButton.setEnabled(true);
            
            if (progress >= 100) {
                nextButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Progress Complete!");
            }
        }
    }
    
    private void decreaseProgress() {
        if (progress > 0) {
            progress -= 10; 
            progressBar.setValue(progress);
            
            nextButton.setEnabled(true);
            
            if (progress <= 0) {
                prevButton.setEnabled(false);
            }
        }
    }
    
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(ProgressBar::new);
    }
}
