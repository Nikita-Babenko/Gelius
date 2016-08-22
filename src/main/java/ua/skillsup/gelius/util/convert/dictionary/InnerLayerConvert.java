package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.InnerLayer;
import ua.skillsup.gelius.model.dto.dictionary.InnerLayerDto;

public final class InnerLayerConvert {

    private InnerLayerConvert() {
    }

    public static InnerLayer convert(InnerLayerDto innerLayerDto) {
        if (innerLayerDto == null) {
            return null;
        }
        InnerLayer innerLayer = new InnerLayer();
        innerLayer.setId(innerLayerDto.getId());
        innerLayer.setInnerLayer(innerLayerDto.getInnerLayer());

        return innerLayer;
    }

    public static InnerLayerDto convert(InnerLayer innerLayer) {
        if (innerLayer == null) {
            return null;
        }
        InnerLayerDto innerLayerDto = new InnerLayerDto();
        innerLayerDto.setId(innerLayer.getId());
        innerLayerDto.setInnerLayer(innerLayer.getInnerLayer());

        return innerLayerDto;
    }
}