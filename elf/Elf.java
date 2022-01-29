package elf;

import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;

import java.util.List;

public abstract class Elf {

    /**
     * Constructor
     */
    public Elf() {
    }

    private ElvesType type;

    public final void setType(final ElvesType type) {
        this.type = type;
    }

    /**
     * Modify Budget
     * @param child Child Object
     */
    public abstract void modifyBudget(ChildBase child);

    /**
     * Modify Gifts
     * @param child Child Object
     */
    public abstract void modifyGifts(ChildBase child, List<Gift> giftList);
}
