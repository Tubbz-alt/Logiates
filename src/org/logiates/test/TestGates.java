///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.logiates.test;
//
//import org.logiates.gates.AndGate;
//import org.logiates.gates.NandGate;
//import org.logiates.gates.NorGate;
//import org.logiates.gates.OrGate;
//
///**
// *
// * @author martin
// */
//public class TestGates {
//    public static void main(String[] args) {
//        AndGate and = new AndGate();
//        OrGate or = new OrGate();
//        NandGate nand = new NandGate();
//        NorGate nor = new NorGate();
//        System.out.println("And: "+and.execGates(1,1,0));
//        System.out.println("Or: "+or.execGates(1,1,0));
//        System.out.println("Nand: "+nand.execGates(1,1,0));
//        System.out.println("NOR: "+nor.execGates(1,1,0));
//        System.out.println("-------------------");
//        and.addGate(or);
//        System.out.println("AND-OR: "+and.execGates(1,1,0));
//    }
//}
