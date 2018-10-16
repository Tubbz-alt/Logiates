package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class NorGate extends LogicGate {

    public NorGate() {}

    public NorGate(LogicGate prev, LogicGate next) {
        super(prev, next);
    }

    public NorGate(LogicGate prev, LogicGate next, int entriesCount) {
        super(prev, next, entriesCount);
    }

    public NorGate(int entriesCount) {
        super(entriesCount);
    }

    @Override
    public Number config(Number... values) {
        int res = new OrGate().config(values).intValue();
        return res == 0 ? 1 : 0;
    }

}
