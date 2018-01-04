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
public class AndGate extends LogicGate {

    public AndGate() {}

    @Override
    protected int config(int... values) {
        int res = 1;
        
        for (int i = 0; i < values.length; i++)
            res &= values[i];
        return res;
    }
    
}
