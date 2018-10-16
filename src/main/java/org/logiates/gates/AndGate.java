package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class AndGate extends LogicGate {

    public AndGate() {}

    public AndGate(LogicGate prev, LogicGate next) {
        super(prev, next);
    }

    public AndGate(LogicGate prev, LogicGate next, int entriesCount) {
        super(prev, next, entriesCount);
    }

    public AndGate(int entriesCount) {
        super(entriesCount);
    }

    @Override
    public Number config(Number... values) {
        int res = 1;

        for (int i = 0; i < values.length; i++)
            res &= values[i].intValue();
        return res;
    }

}
