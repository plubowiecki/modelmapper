package it.patrol.cdto;

import it.patrol.ResponseMapper;
import it.patrol.dto.OfferDto;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class ResponseMapperTest {

    @Test
    public void testGetOffer_withTwoOffers() {
        //given
        String jsonResponse = createResponseWithTwoOffers();
        //when
        List<OfferDto> offerDtos = ResponseMapper.getOfferDtos(jsonResponse);
        //then
        Assertions.assertThat(offerDtos).isNotNull();
        Assertions.assertThat(offerDtos.size()).isEqualTo(2);
    }

    private static String createResponseWithTwoOffers() {
        return "{\n" +
            "  \"offers\": [\n" +
            "    {\n" +
            "      \"id\": \"daksjdk23848923798\",\n" +
            "      \"OfferUrl\": \"/offer-url-http\",\n" +
            "      \"Opinion\": {\n" +
            "        \"Counter\": 164\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": \"sdkjhfkjsdf892398rfh\",\n" +
            "      \"OfferUrl\": \"http://offeroffer-url-2\",\n" +
            "      \"Opinie\": {\n" +
            "        \"Counter\": 0\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    }

    @Test
    public void testGetOffer_withOneOfferAndOfferFields() {
        //given
        String offerId = "daksjdk23848923798";
        String offerUrl = "/offer-url-http";
        String offerCounter = "164";

        String jsonResponse = createResponseWithOneOffer(offerId, offerUrl, offerCounter);
        System.out.println(jsonResponse);
        //when
        OfferDto offerDto = ResponseMapper.getOfferDtos(jsonResponse)
            .stream()
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
        //then
        Assertions.assertThat(offerDto).isNotNull();
        Assertions.assertThat(offerDto.getOfferId()).isEqualTo(offerId);
        Assertions.assertThat(offerDto.getOfferUrl()).isEqualTo(offerUrl);
        Assertions.assertThat(offerDto.getOpinionCounter()).isEqualTo(Integer.valueOf(offerCounter).intValue());
    }

    private static String createResponseWithOneOffer(String offerId, String offerUrl, String offerCounter) {
        return "{\n" +
            "  \"offers\": [\n" +
            "    {\n" +
            "      \"id\": \"" + offerId + "\" ,\n" +
            "      \"OfferUrl\": \"" + offerUrl + "\" ,\n" +
            "      \"Opinion\": {\n" +
            "        \"Counter\":" + offerCounter + " \n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    }

}