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
    
    //private LinkedList<LogicGate> listGates;
    private LogicGate prev;
    private LogicGate next;
    
    public LogicGate() {
        //listGates = new LinkedList<>();
        this(null, null);
    }
    
    public LogicGate(LogicGate prev, LogicGate next) {
        this.prev = prev;
        this.next = next;
    }
    
    protected abstract int config(int... values);
    
    public int execute(int... values){
        int exec = config(values);
        if (next != null)
            exec = next.execute(values);
//        for (LogicGate gate : listGates) {
//            exec = gate.config(exec);
//        }
        return exec;
    }
    
    public boolean isAlone(){
        //return listGates.isEmpty();
        return prev == next && next == null;
    }

//    public int getJoinedGatesCount(){
//        return listGates.size();
//    }
    
    public boolean isFirst(){
        return !isAlone() && prev == null;
    }
    
    public boolean isLast(){
        return !isAlone() && next == null;
    }
    
    public int getPredecessorCount(){
        int count = 0;
        if (prev != null) {
            LogicGate p = prev;
            while (p != null) {                
                count++;
                p = p.prev;
            }
        }
        return count;
    }
    
    public int getSucessorCount(){
        int count = 0;
        if (next != null) {
            LogicGate n = next;
            while (n != null) {                
                count++;
                n = n.next;
            }
        }
        return count;
    }
    
    public int getJoinedCount(){
        return getPredecessorCount()+getSucessorCount();
    }
    
    public LinkedList<LogicGate> getJoinesGates() {
        LinkedList<LogicGate> listJoinedGates = new LinkedList<>();
        
        if (!isAlone()) {
            LogicGate aux = prev;
            while (aux != null) {                
                listJoinedGates.addFirst(aux);
                aux = aux.prev;
                // El segundo while podria hacerse dentro pero queda 
            }
            aux = next;
            while (aux != null) {
                listJoinedGates.add(aux);
                aux = aux.next;
            }
        }
        return listJoinedGates;
    }

    public LogicGate joinGateBefore(LogicGate gate){
        if (gate != null) {
            prev = gate;
            gate.next = this;
        }
    }
    
    public LogicGate joinGate(LogicGate gate){
        if (gate != null) {
            //listGates.add(gate);
            next = gate;
            gate.prev = this;
        }
        return gate;
    }
    
    public boolean disjoinGates(){
        //listGates.clear();
        if (isAlone())
            return false;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getClass().getSimpleName()).append(": ")
                .append(hashCode()).toString();
    }

}
