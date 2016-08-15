package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.FaceLayerDto;
import ua.skillsup.gelius.model.entity.dictionary.FaceLayer;

public final class FaceLayerConvert {

    private FaceLayerConvert() {
    }

    public static FaceLayer convert(FaceLayerDto faceLayerDto) {
        if (faceLayerDto == null) {
            return null;
        }
        FaceLayer faceLayer = new FaceLayer();
        faceLayer.setId(faceLayerDto.getId());
        faceLayer.setFaceLayer(faceLayerDto.getFaceLayer());

        return faceLayer;
    }

    public static FaceLayerDto convert(FaceLayer faceLayer) {
        if (faceLayer == null) {
            return null;
        }
        FaceLayerDto faceLayerDto = new FaceLayerDto();
        faceLayerDto.setId(faceLayer.getId());
        faceLayerDto.setFaceLayer(faceLayer.getFaceLayer());

        return faceLayerDto;
    }
}