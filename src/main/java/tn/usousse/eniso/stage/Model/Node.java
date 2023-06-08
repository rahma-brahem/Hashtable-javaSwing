/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage.Model;

/**
 *
 * @author rahma
 */
public class Node {
    private String value;
    private Node next ;

    public Node() {
    }

    public Node(String value){
        this.value =value;
        this.next =null;
    }

    public String getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
