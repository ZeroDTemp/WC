package clock;

/**
 * Author: Kirubel.Birhane
 * Creation Date: 12/2/2023
//Update Logs
/**
 * Update 1 - 10/30/2024: 
 * https://docs.google.com/document/d/1ibk58PBvvoe_PAUHKYfluaoAd0nSJqQ9KeTu6n52w0k/edit?usp=sharing
 *  
 */

import javax.swing.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ShowCurrentTime {
   public static void main(String[] args) {
	   
	   
	   SwingUtilities.invokeLater(() -> {
           // Create the main frame
           JFrame mainFrame = new JFrame();
           mainFrame.setTitle("World Time");
           mainFrame.setSize(400, 300);
           mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // Create a panel to hold the components
           JPanel mainPanel = new JPanel(new BorderLayout());
           // Create a JLabel for the background image
           ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Kiru\\Downloads\\Earthjwir.gif"); // Remove extra quotes
           JLabel backgroundLabel = new JLabel(backgroundImage);
           // Create JLabels with the formatted times
           JLabel worldTimeLabel = new JLabel("<html><b><font color='white'>World Time</font></b></html>", SwingConstants.CENTER);
           JLabel centralLabel = new JLabel("<html><b><font color='white'>Current Time: Central</font></b></html>", SwingConstants.CENTER);
           JLabel gmtLabel = new JLabel("<html><b><font color='white'>Current Time: GMT</font></b></html>", SwingConstants.CENTER);
           JLabel pacificLabel = new JLabel("<html><b><font color='white'>Current Time: Pacific</font></b></html>", SwingConstants.CENTER);
           // Add the components to the backgroundLabel
           backgroundLabel.setLayout(new GridLayout(4, 1));
           backgroundLabel.add(worldTimeLabel);
           backgroundLabel.add(centralLabel);
           backgroundLabel.add(gmtLabel);
           backgroundLabel.add(pacificLabel);
           // Add the backgroundLabel to the main panel
           mainPanel.add(backgroundLabel);
           // Create a Timer to refresh the GUI every second
           Timer timer = new Timer(1000, new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   // Get the current time
                   Date now = new Date();
                   long militaryTimeCounter = 12 * 60 * 60 * 1000;
                   // Subtract 12 hours from the current time
                   Date central = new Date(now.getTime() - militaryTimeCounter);
                   // Subtract 18 hours from the current time
                   Date gmt = new Date(now.getTime() - militaryTimeCounter - 21600000);
                   // Subtract 2 hours from the current time
                   Date pacific = new Date(now.getTime() - militaryTimeCounter - 7200000);
                   // Format the time for Central
                   SimpleDateFormat dateFormatC = new SimpleDateFormat("HH:mm:ss");
                   String formattedCentral = dateFormatC.format(central);
                   // Format the time for GMT
                   SimpleDateFormat dateFormatG = new SimpleDateFormat("HH:mm:ss");
                   String formattedGMT = dateFormatG.format(gmt);
                   // Format the time for Pacific
                   SimpleDateFormat dateFormatP = new SimpleDateFormat("HH:mm:ss");
                   String formattedPacific = dateFormatP.format(pacific);
                   // Update the JLabels with the new formatted times
                   centralLabel.setText("<html><b><font color='white'>Current Time: " + formattedCentral + " Central</font></b></html>");
                   gmtLabel.setText("<html><b><font color='white'>Current Time: " + formattedGMT + " GMT</font></b></html>");
                   pacificLabel.setText("<html><b><font color='white'>Current Time: " + formattedPacific + " Pacific</font></b></html>");
               }
           });
           // Start the timer
           timer.start();
           // Add the main panel to the main frame
           mainFrame.add(mainPanel);
           // Make the window visible
           mainFrame.setVisible(true);
       });
   }
}

