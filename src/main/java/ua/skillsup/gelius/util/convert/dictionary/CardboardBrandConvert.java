package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.CardboardBrand;
import ua.skillsup.gelius.model.dto.dictionary.CardboardBrandDto;

public final class CardboardBrandConvert {

    private CardboardBrandConvert() {

    }

    public static CardboardBrand convert(CardboardBrandDto cardboardBrandDto) {
        if (cardboardBrandDto == null) {
            return null;
        }
        CardboardBrand cardboardBrand = new CardboardBrand();
        cardboardBrand.setId(cardboardBrandDto.getId());
        cardboardBrand.setCardboardBrand(cardboardBrandDto.getCardboardBrand());

        return cardboardBrand;
    }

    public static CardboardBrandDto convert(CardboardBrand cardboardBrand) {
        if (cardboardBrand == null) {
            return null;
        }
        CardboardBrandDto cardboardBrandDto = new CardboardBrandDto();
        cardboardBrandDto.setId(cardboardBrand.getId());
        cardboardBrandDto.setCardboardBrand(cardboardBrand.getCardboardBrand());

        return cardboardBrandDto;
    }
}
