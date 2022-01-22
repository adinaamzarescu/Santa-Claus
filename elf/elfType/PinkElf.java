package elf.elfType;

import common.Constants;
import elf.Elf;
import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;

import java.util.List;

public class PinkElf extends Elf {

    /**
     * Constructor
     */
    public PinkElf() {
        super();
        setType(ElvesType.PINK);
    }

    /**
     * Modify Budget
     *
     * @param child Child Object
     */
    @Override
    public final void modifyBudget(final ChildBase child) {
        Double budget = child.getAssignedBudget();
        budget += budget * Constants.THIRTY / Constants.HUNDRED;
        child.setAssignedBudget(budget);
    }

    /**
     * Modify Gifts
     *
     * @param child Child Object
     */
    @Override
    public final void modifyGifts(final ChildBase child, final List<Gift> giftList) {
        // do nothing
    }
}
