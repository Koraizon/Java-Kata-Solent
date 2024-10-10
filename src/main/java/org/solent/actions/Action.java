package org.solent.actions;

import org.solent.Mower;
import org.solent.enums.Instruction;

public interface Action {
    public void execute(Mower mower);
}
