/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage.presentation.view;

/**
 * @author rahma
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;








import tn.usousse.eniso.stage.Model.Table;
import tn.usousse.eniso.stage.presentation.controller.HashtableController;
import tn.usousse.eniso.stage.service.Service;

import javax.swing.*;
import java.awt.event.*;

public class Presentation implements ActionListener {

    JFrame frame = new JFrame("swing app");

    HashtableController hashtableController = new HashtableController(new Service(new Table(0)));
    HashTableDrawComponent drawComponent = new HashTableDrawComponent(hashtableController);

    public Presentation() {
    }

    public void showPresentation() {


        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem i1 = new JMenuItem("New");
        JMenuItem i2 = new JMenuItem("Add");
        JMenuItem i3 = new JMenuItem("Exit");
        file.add(i1);
        file.add(i2);
        file.add(i3);
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        mb.add(file);
        mb.add(help);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        about.addActionListener(this);
        frame.setJMenuBar(mb);
        frame.setSize(400, 400);


        frame.setSize(280, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(drawComponent);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {

            String name = JOptionPane.showInputDialog("enter Name");


            hashtableController.getService().add(name);
            drawComponent.repaint();

        } else if (e.getActionCommand().equals("New")) {

            String sizeText = JOptionPane.showInputDialog("enter table size");
            if (sizeText != null) {
                int size;
                try {
                    size = Integer.parseInt(sizeText);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "tirr", "Shtortaff", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                hashtableController.getService().setTable(new Table(size));
                drawComponent.repaint();
            }
        } else if (e.getActionCommand().equals("About")) {
            JFrame AboutFrame = new JFrame("About");
            JOptionPane.showMessageDialog(AboutFrame, "Hello welcome to our Hashtable swing app");


        }
        drawComponent.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {

                drawComponent.setBackground(Color.ORANGE);
            }
            public void mouseExited(MouseEvent evt)
            {
                drawComponent.setBackground(null);
            }
        });


    }


}
    


