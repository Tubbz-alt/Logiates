package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class NandGate extends LogicGate {

    public NandGate() {}

    @Override
    public Number config(Number... values) {
        int res = new AndGate().config(values).intValue();
        return res == 0 ? 1 : 0;
    }

}
