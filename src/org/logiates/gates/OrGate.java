/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class OrGate extends LogicGate {

    public OrGate() {}
    
    @Override
    protected int config(int... values) {
        int exec = 0;
        
        for (int i = 0; i < values.length; i++)
            exec |= values[i];
        return exec;
    }
    
}
