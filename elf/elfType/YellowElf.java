package elf.elfType;

import elf.Elf;
import entities.children.ChildBase;
import entities.gift.Gift;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class YellowElf extends Elf {

    /**
     * Constructor
     */
    public YellowElf() {
        super();
        setType(ElvesType.YELLOW);
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
     * Create a preferred list by category
     * Iterate by each category and see a gift can be given.
     * chooses the cheapest gift from the preference list.
     * if there are no gifts in teh preference list or
     * if the quantity of the cheapest gift = 0  then this child won't receive a gift
     *  @param child    Child Object
     * @param giftList gift list
     */
    @Override
    public void modifyGifts(final ChildBase child, final List<Gift> giftList) {
        if (child.getReceivedGifts().isEmpty()) {
            Map<String, List<Gift>> preferred = new HashMap<>();
            for (Gift gift : giftList) {
                String category = gift.getCategory();
                if (child.getGiftsPreferences().contains(category)) {
                    if (preferred.containsKey(category)) {
                        preferred.get(category).add(gift);
                    } else {
                        ArrayList<Gift> gifts = new ArrayList<>();
                        gifts.add(gift);
                        preferred.put(category, gifts);
                    }
                }
            }
            if (preferred.size() > 0) {
                for (List<Gift> list : preferred.values()) {
                    list.sort(Comparator.comparing(Gift::getPrice));
                    Gift gift = list.get(0);
                    if (gift.getQuantity() > 0) {
                        child.getReceivedGifts().add(gift);
                        gift.setQuantity(gift.getQuantity() - 1);
                        break;
                    }
                }
            }
        }

    }
}
