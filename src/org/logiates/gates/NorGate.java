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
public class NorGate extends LogicGate {

    public NorGate() {}

    @Override
    protected int config(int... values) {
        int res = new OrGate().config(values);
        return res == 0 ? 1 : 0;
    }
    
}
