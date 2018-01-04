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
public class NandGate extends LogicGate {

    public NandGate() {}
    
    @Override
    protected int config(int... values) {
        int res = new AndGate().config(values);
        return res == 0 ? 1 : 0;
    }
    
}
