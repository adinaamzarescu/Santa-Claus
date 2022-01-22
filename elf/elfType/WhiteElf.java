package elf.elfType;

import elf.Elf;
import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;

import java.util.List;

public class WhiteElf extends Elf {

    /**
     * Constructor
     */
    public WhiteElf() {
        super();
        setType(ElvesType.WHITE);
    }

    /**
     * Modify Budget
     *
     * @param child Child Object
     */
    @Override
    public void modifyBudget(final ChildBase child) {
        // do nothing
    }

    /**
     * Modify Gifts
     *
     * @param child Child Object
     */
    @Override
    public void modifyGifts(final ChildBase child, final List<Gift> giftList) {
        // do nothing
    }
}
