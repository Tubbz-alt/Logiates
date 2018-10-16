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
public abstract class LogicGate implements LogicFunction {

    private LogicGate prev;
    private LogicGate next;

    private final int entriesCount;

    public LogicGate() {
        this(null, null);
    }

    public LogicGate(LogicGate prev, LogicGate next) {
        this(prev, next, 1);
    }

    public LogicGate(LogicGate prev, LogicGate next, int entriesCount) {
        this.prev = prev;
        this.next = next;
        if (entriesCount < 0)
            throw new IndexOutOfBoundsException("Entry count must be zero or higher");
        this.entriesCount = entriesCount;
    }

    public abstract Number config(Number... values);

    public Number execute(Number... values){
        Number exec;
        if (values != null) {
            if (values.length > entriesCount)
                throw new IndexOutOfBoundsException("The entries count is higher " +
                        "than supported entries: "+values.length);
            exec = config(values);
            if (next != null)
                exec = next.execute(values);
            return exec;
        }
        else if (entriesCount > 0)
            throw new NullPointerException("Entries null");
        else {
            exec = 0;
            if (next != null)
                exec = next.execute(values);
            return exec;
        }
    }

    public boolean isAlone(){
        //return listGates.isEmpty();
        return prev == next && next == null;
    }

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
        return gate;
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

    public LogicGate getPrev() {
        return prev;
    }

    public void setPrev(LogicGate prev) {
        this.prev = prev;
    }

    public LogicGate getNext() {
        return next;
    }

    public void setNext(LogicGate next) {
        this.next = next;
    }

    public int getEntriesCount() {
        return entriesCount;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getClass().getSimpleName()).append(": ")
                .append(hashCode()).toString();
    }

}
