package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.PalletPlacementDto;
import ua.skillsup.gelius.model.entity.dictionary.PalletPlacement;

public final class PalletPlacementConvert {

    private PalletPlacementConvert() {
    }

    public static PalletPlacement convert(PalletPlacementDto palletPlacementDto) {
        if (palletPlacementDto == null) {
            return null;
        }
        PalletPlacement palletPlacement = new PalletPlacement();
        palletPlacement.setId(palletPlacementDto.getId());
        palletPlacement.setPlacement(palletPlacementDto.getPalletPlacement());

        return palletPlacement;
    }

    public static PalletPlacementDto convert(PalletPlacement palletPlacement) {
        if (palletPlacement == null) {
            return null;
        }
        PalletPlacementDto palletPlacementDto = new PalletPlacementDto();
        palletPlacementDto.setId(palletPlacement.getId());
        palletPlacementDto.setPlacement(palletPlacement.getPalletPlacement());

        return palletPlacementDto;
    }
}