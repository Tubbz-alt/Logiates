/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.logiates.test;

import org.logiates.base.LogicGate;
import org.logiates.gates.AndGate;
import org.logiates.gates.NandGate;
import org.logiates.gates.NorGate;
import org.logiates.gates.OrGate;

/**
 *
 * @author martin
 */
public class TestGates {
    public static void main(String[] args) {
        AndGate and = new AndGate();
        OrGate or = new OrGate();
        NandGate nand = new NandGate();
        NorGate nor = new NorGate();
        System.out.println("And: "+and.execute(1,1,0));
        System.out.println("Or: "+or.execute(1,1,0));
        System.out.println("Nand: "+nand.execute(1,1,0));
        System.out.println("NOR: "+nor.execute(1,1,0));
        System.out.println("-------------------");
        and.joinGate(or).joinGate(nand).joinGate(nor);
        System.out.println(nand.getPredecessorCount());
        System.out.println(nand.getSucessorCount());
        System.out.println(nand.getJoinedCount());
    }
    
}
