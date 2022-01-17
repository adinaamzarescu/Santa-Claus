package elf;

import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Elf {

    /**
     * Constructor
     */
    public Elf() {
    }

    private ElvesType type;

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
