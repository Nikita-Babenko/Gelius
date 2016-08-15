package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.InnerLayerDto;
import ua.skillsup.gelius.model.entity.dictionary.InnerLayer;

public final class InnerLayerConvert {

    private InnerLayerConvert() {
    }

    public static InnerLayer convert(InnerLayerDto innerLayerDto) {
        if (innerLayerDto == null) {
            return null;
        }
        InnerLayer innerLayer = new InnerLayer();
        innerLayer.setId(innerLayer.getId());
        innerLayer.setInnerLayer(innerLayer.getInnerLayer());

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