package elf.elfTypes;

import common.Constants;
import elf.Elf;
import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;

import java.util.List;
/**
 * The black elf decreases the assigned budget with 30%
 */
public class BlackElf extends Elf {


    /**
     * Constructor
     */
    public BlackElf() {
        super();
        setType(ElvesType.BLACK);
    }

    /**
     * Modify Budget
     *
     * @param child Child Object
     */
    @Override
    public void modifyBudget(final ChildBase child) {
        Double budget = child.getAssignedBudget();
        budget -= budget * Constants.THIRTY / Constants.HUNDRED;
        child.setAssignedBudget(budget);
    }

    /**
     * Modify Gifts
     *
     * @param child Child Object
     */
    @Override
    public void modifyGifts(final ChildBase child, final List<Gift> giftList) {
        /**
         * Do nothing
         */
    }
}
