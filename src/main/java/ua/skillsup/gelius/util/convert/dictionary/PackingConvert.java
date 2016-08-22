package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.Packing;
import ua.skillsup.gelius.model.dto.dictionary.PackingDto;

public final class PackingConvert {

    private PackingConvert() {
    }

    public static Packing convert(PackingDto packingDto) {
        if (packingDto == null) {
            return null;
        }
        Packing packing = new Packing();
        packing.setId(packingDto.getId());
        packing.setPacking(packingDto.getPacking());

        return packing;
    }

    public static PackingDto convert(Packing packing) {
        if (packing == null) {
            return null;
        }
        PackingDto packingDto = new PackingDto();
        packingDto.setId(packing.getId());
        packingDto.setPacking(packing.getPacking());

        return packingDto;
    }
}