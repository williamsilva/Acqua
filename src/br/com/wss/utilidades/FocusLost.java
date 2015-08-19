/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.utilidades;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class FocusLost extends FocusTraversalPolicy {

    ArrayList<Component> order;

    public FocusLost(ArrayList<Component> order) {
        this.order = new ArrayList<>(order.size());
        this.order.addAll(order);
    }

    @Override
    public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
        int index = (order.indexOf(aComponent) + 1) % order.size();
        return order.get(index);
    }

    @Override
    public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
        int index = order.indexOf(aComponent) - 1;
        if (index < 0) {
            index = order.size() - 1;
        }
        return order.get(index);
    }

    @Override
    public Component getFirstComponent(Container focusCycleRoot) {
        return order.get(0);
    }

    @Override
    public Component getLastComponent(Container focusCycleRoot) {
        return order.get(order.size() - 1);
    }

    @Override
    public Component getDefaultComponent(Container focusCycleRoot) {
        return order.get(0);
    }

}
