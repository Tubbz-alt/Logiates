package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class OrGate extends LogicGate {

    public OrGate() {}

    public OrGate(LogicGate prev, LogicGate next) {
        super(prev, next);
    }

    public OrGate(LogicGate prev, LogicGate next, int entriesCount) {
        super(prev, next, entriesCount);
    }

    public OrGate(int entriesCount) {
        super(entriesCount);
    }

    @Override
    public Number config(Number... values) {
        int exec = 0;

        for (int i = 0; i < values.length; i++)
            exec |= values[i].intValue();
        return exec;
    }

}
