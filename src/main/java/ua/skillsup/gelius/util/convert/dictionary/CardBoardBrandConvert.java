package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.CardboardBrand;
import ua.skillsup.gelius.model.dto.dictionary.CardBoardBrandDto;

public final class CardBoardBrandConvert {

    private CardBoardBrandConvert(){

    }

    public static CardboardBrand convert(CardBoardBrandDto cardBoardBrandDto) {
        if (cardBoardBrandDto == null) {
            return null;
        }
        CardboardBrand cardboardBrand = new CardboardBrand();
        cardboardBrand.setId(cardBoardBrandDto.getId());
        cardboardBrand.setCardboardBrand(cardBoardBrandDto.getCardboardBrand());

        return cardboardBrand;
    }

    public static CardBoardBrandDto convert(CardboardBrand cardboardBrand) {
        if (cardboardBrand == null) {
            return null;
        }
        CardBoardBrandDto cardBoardBrandDto = new CardBoardBrandDto();
        cardBoardBrandDto.setId(cardboardBrand.getId());
        cardBoardBrandDto.setCardboardBrand(cardboardBrand.getCardboardBrand());

        return cardBoardBrandDto;
    }
}
