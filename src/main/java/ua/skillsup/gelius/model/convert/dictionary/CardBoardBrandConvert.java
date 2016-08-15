package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.CardBoardBrandDto;
import ua.skillsup.gelius.model.entity.dictionary.CardBoardBrand;

public final class CardBoardBrandConvert {

    private CardBoardBrandConvert(){

    }

    public static CardBoardBrand convert(CardBoardBrandDto cardBoardBrandDto) {
        if (cardBoardBrandDto == null) {
            return null;
        }
        CardBoardBrand cardboardBrand = new CardBoardBrand();
        cardboardBrand.setId(cardBoardBrandDto.getId());
        cardboardBrand.setCardboardBrand(cardBoardBrandDto.getCardboardBrand());

        return cardboardBrand;
    }

    public static CardBoardBrandDto convert(CardBoardBrand cardboardBrand) {
        if (cardboardBrand == null) {
            return null;
        }
        CardBoardBrandDto cardBoardBrandDto = new CardBoardBrandDto();
        cardBoardBrandDto.setId(cardboardBrand.getId());
        cardBoardBrandDto.setCardboardBrand(cardboardBrand.getCardboardBrand());

        return cardBoardBrandDto;
    }
}
