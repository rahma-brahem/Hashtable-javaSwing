package tn.usousse.eniso.stage.presentation.view;

import tn.usousse.eniso.stage.Model.Node;
import tn.usousse.eniso.stage.Model.Table;
import tn.usousse.eniso.stage.presentation.controller.HashtableController;
import tn.usousse.eniso.stage.service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HashTableDrawComponent extends JComponent {
    private HashtableController hashtableController;

    public HashTableDrawComponent(HashtableController hashtableController) {
        this.hashtableController = hashtableController;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int caseSize = 100;
                int startX =50;
                int startY=50;
                //int startX = (getWidth() - caseSize) / 2;
                //int startY = (getHeight() - (caseSize * hashtableController.getSize())) / 2;
                int nodeIndex = (y - startY) / caseSize;
                Node node = hashtableController.getModel().getNodes()[nodeIndex];
                if (node != null) {
                    int r = startX;
                    while (node != null) {
                        int nodeX = r + caseSize + 50;
                        int nodeY = startY + (caseSize * nodeIndex) + caseSize + 20;
                        if (x >= nodeX && x <= nodeX + caseSize - 20 && y >= nodeY - caseSize - 30 && y <= nodeY - 40) {
                            int dialogResult = JOptionPane.showConfirmDialog(HashTableDrawComponent.this,
                                    "Are you sure you want to delete this node?", "Confirmation", JOptionPane.YES_NO_OPTION);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                boolean removed = hashtableController.getService().remove(node.getValue());
                                if (removed) {
                                    repaint();
                                } else {
                                    JOptionPane.showMessageDialog(HashTableDrawComponent.this, "Node not found.");
                                }
                            }
                            break;
                        }
                        r += caseSize + 30;
                        node = node.getNext();
                    }
                }
            }
        });

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int tableSize = hashtableController.getService().getTable().getNodes().length;

        int x = 50; // Starting x-coordinate of the table
        int y = 50; // Starting y-coordinate of the table
        int width = 100; // Width of each cell
        int height = 50; // Height of each cell
        int size = tableSize; // size of the table


        g2d.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font for table content

        // Draw table header
        g2d.drawRect(x, y, width, height);
        g2d.drawString("HashTable", x + 5, y + height / 2);

        // Draw table rows
        Node[] nodes = hashtableController.getModel().getNodes();
        for (int i = 0; i < size; i++) {

            g2d.drawRect(x, y + (i * height) + height, width, height);
            Node n = nodes[i];
            int xPos = x;
            while (n != null) {



                drawNode(n, i, g2d, 100, xPos, y);
                if (n.getNext() == null) {
                    drawNull(n, i, g2d, 100, xPos + width + 30, y);
                }

                n = n.getNext();
                xPos = xPos + width + 30;

            }

        }

    }

    private void drawNode(Node node, int i, Graphics2D g2d, int caseSize, int x, int y) {
        if (node != null) {

            int lineY = 125 + 50 * i;
            g2d.drawLine(x + caseSize, lineY, x + caseSize + 50, lineY);
            int rectY = lineY + caseSize;
            g2d.drawRect(x + caseSize + 50, rectY - caseSize - 30, caseSize - 20, 40);
            g2d.drawString(node.getValue(), x + caseSize + 75, lineY);
            // Check if the mouse is on the current node

        }

        }
        //}


    private void drawNull(Node node, int i, Graphics2D g2d, int caseSize, int x, int y) {


        int lineY = 125 + 50 * i;

        g2d.drawLine(x + caseSize, lineY, x + caseSize + 50, lineY);
        int lineX = x + caseSize + 50;
        g2d.drawLine(lineX, lineY + 20, lineX, lineY - 20);
        g2d.drawLine(lineX, lineY + 10, lineX + 10, lineY);
        g2d.drawLine(lineX, lineY - 10, lineX + 10, lineY - 20);


    }



}



