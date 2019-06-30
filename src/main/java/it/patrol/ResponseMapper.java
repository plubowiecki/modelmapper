package it.patrol;

import com.google.gson.Gson;
import it.patrol.cdto.ResponseCDto;
import it.patrol.dto.OfferDto;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResponseMapper {

    public static List<OfferDto> getOfferDtos(String json) {
        Gson gson = new Gson();
        ResponseCDto responseCDto = gson.fromJson(json, ResponseCDto.class);

        return Optional
            .of(responseCDto)
            .map(ResponseCDto::getOffers)
            .orElse(Collections.emptyList())
            .stream()
            .map(offerCDto -> new ModelMapper().map(offerCDto, OfferDto.class))
            .collect(Collectors.toList());
    }

}
