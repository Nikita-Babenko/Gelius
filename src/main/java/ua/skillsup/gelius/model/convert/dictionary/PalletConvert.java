package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.PalletDto;
import ua.skillsup.gelius.model.entity.dictionary.Pallet;

public final class PalletConvert {

    private PalletConvert() {
    }

    public static Pallet convert(PalletDto palletDto) {
        if (palletDto == null) {
            return null;
        }
        Pallet pallet = new Pallet();
        pallet.setId(palletDto.getId());
        pallet.setPallet(palletDto.getPallet());

        return pallet;
    }

    public static PalletDto convert(Pallet pallet) {
        if (pallet == null) {
            return null;
        }
        PalletDto palletDto = new PalletDto();
        palletDto.setId(pallet.getId());
        palletDto.setPallet(pallet.getPallet());

        return palletDto;
    }
}