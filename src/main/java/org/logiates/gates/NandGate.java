package org.logiates.gates;

import org.logiates.base.LogicGate;

/**
 *
 * @author martin
 */
public class NandGate extends LogicGate {

    public NandGate() {}

    public NandGate(LogicGate prev, LogicGate next) {
        super(prev, next);
    }

    public NandGate(LogicGate prev, LogicGate next, int entriesCount) {
        super(prev, next, entriesCount);
    }

    public NandGate(int entriesCount) {
        super(entriesCount);
    }

    @Override
    public Number config(Number... values) {
        int res = new AndGate().config(values).intValue();
        return res == 0 ? 1 : 0;
    }

}
