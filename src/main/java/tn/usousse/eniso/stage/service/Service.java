/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage.service;

import tn.usousse.eniso.stage.Model.Node;
import tn.usousse.eniso.stage.Model.Table;

/**
 * @author rahma
 */

public class Service {
    private Table table;

    public Service(Table table) {
        this.table = table;
    }

    public Service() {
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean add(String value) {
        if (find(value)) {
            return false;
        } else {
            int index = hash(value);
            Node noeud = new Node(value);

            if (table.getNodes()[index] == null) {
                table.getNodes()[index] = noeud;
            } else {
                Node currentNode = table.getNodes()[index];
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(noeud);
            }

            return true;
        }
    }


    public boolean find(String value) {
        int i = hash(value);
        Node currentNode = this.table.getNodes()[i];

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }


    public void list() {
        for (int i = 0; i < this.table.getNodes().length; i++) {
            System.out.print(i + "--");
            Node currentNode = this.table.getNodes()[i];
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + "--");
                currentNode = currentNode.getNext();
            }
            System.out.println("null");
        }
    }


    public int hash1(String value) {
        int s = 0;
        for (char ch : value.toCharArray()) {
            s = s + (int) ch;
        }
        return (s % 3);
    }

    public int hash(String value) {
        int s = 0;
        int x = value.length() - 1;
        char[] charr = value.toCharArray();
        for (int i = 0; i < charr.length; i++) {

            s = (int) (s + (int) charr[i] * Math.pow(31, x));
            x = x - 1;
        }
        return (s % table.getNodes().length);
    }

    public boolean remove(String value) {
        int index = hash(value);
        Node currentNode = this.table.getNodes()[index];
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                if (prevNode == null) {
                    this.table.getNodes()[index] = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                return true;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }


}

