package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class AndGate extends LogicGate {

    public AndGate() {}

    @Override
    public Number config(Number... values) {
        int res = 1;

        for (int i = 0; i < values.length; i++)
            res &= values[i].intValue();
        return res;
    }

}
