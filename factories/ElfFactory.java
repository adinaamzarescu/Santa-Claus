package factories;

import elf.elfTypes.BlackElf;
import elf.elfTypes.YellowElf;
import elf.elfTypes.WhiteElf;
import elf.elfTypes.PinkElf;
import elf.Elf;
import enums.ElvesType;

public final class ElfFactory {
    private static ElfFactory instance = null;

    private ElfFactory() {
    }

    /**
     * Make singleton instance for factory
     *
     * @return instance
     */
    public static ElfFactory getInstance() {
        if (instance == null) {
            instance = new ElfFactory();
        }
        return instance;
    }

    /**
     * Method to create Elf Objects
     *
     * @param type Elf type
     * @return Elf Object
     */
    public Elf createElf(final String type) {
        if (ElvesType.YELLOW.getValue().equals(type)) {
            return new YellowElf();
        } else if (ElvesType.WHITE.getValue().equals(type)) {
            return new WhiteElf();
        } else if (ElvesType.BLACK.getValue().equals(type)) {
            return new BlackElf();
        } else if (ElvesType.PINK.getValue().equals(type)) {
            return new PinkElf();
        }
        return null;
    }
}
