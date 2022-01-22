package factories;

import entities.children.ChildBase;
import fileio.input.ChildrenInputData;

import java.util.ArrayList;

public final class ChildrenFactory {
    private static ChildrenFactory instance = null;

    private ChildrenFactory() {
    }

    /**
     * Make singleton instance for entities.children factory
     *
     * @return instance
     */
    public static ChildrenFactory getInstance() {
        if (instance == null) {
            instance = new ChildrenFactory();
        }
        return instance;
    }

    /**
     * Create Children
     * @param child input child
     * @return child object
     */
    public ChildBase createChildren(final ChildrenInputData child) {
        ElfFactory elfFactory = ElfFactory.getInstance();
        ChildBase ch = new ChildBase.Builder().id(child.getId()).firstName(child.getFirstName()).
                lastName(child.getLastName()).age(child.getAge()).
                city(child.getCity()).niceScore(child.getNiceScore()).
                niceScoreBonus(child.getNiceScoreBonus()).
                giftsPreferences(child.getGiftsPreferences()).
                elf(elfFactory.createElf(child.getElf())).receivedGifts(new ArrayList<>()).build();
        ch.initialize();
        return ch;
    }
}
