/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.logiates.base;

import java.util.LinkedList;

/**
 *
 * @author martin
 */
public abstract class LogicGate {
    
    private LinkedList<LogicGate> listGates;

    public LogicGate() {
        listGates = new LinkedList<>();
    }
    
    protected abstract int exec(int... values);
    
    public int execGates(int... values){
        int exec = exec(values);
        
        for (LogicGate gate : listGates) {
            exec = gate.exec(exec);
        }
        return exec;
    }

    public LinkedList<LogicGate> getListGates() {
        return listGates;
    }

    public void addGate(LogicGate gate){
        listGates.add(gate);
    }
    
    public void deleteGates(){
        listGates.clear();
    }
    
}
