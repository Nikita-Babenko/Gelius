package ua.skillsup.gelius.util.convert;

import ua.skillsup.gelius.dao.entity.Perforation;
import ua.skillsup.gelius.model.dto.PerforationDto;

public final class PerforationConvert {

    private PerforationConvert() {
    }

    public static Perforation convert(PerforationDto perforationDto) {
        if (perforationDto == null) {
            return null;
        }
        Perforation perforation = new Perforation();
        perforation.setId(perforationDto.getId());
        perforation.setProduct(ProductConvert.convert(perforationDto.getProduct()));
        perforation.setValue(perforationDto.getValue());

        return perforation;
    }


    public static PerforationDto convert(Perforation perforation) {
        if (perforation == null) {
            return null;
        }
        PerforationDto perforationDto = new PerforationDto();
        perforationDto.setId(perforation.getId());
        perforationDto.setProduct(ProductConvert.convert(perforation.getProduct()));
        perforationDto.setValue(perforation.getValue());

        return perforationDto;
    }
}
