/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage.Model;

/**
 *
 * @author rahma
 */
public class Table {
    private Node[]nodes;
    public Table(int size){
         this.nodes =new Node[size];
    }

    public Node[] getNodes() {
        return this.nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }
    
}
