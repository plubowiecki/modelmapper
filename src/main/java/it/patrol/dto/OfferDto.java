package it.patrol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private String offerId;
    private String offerUrl;
    private String offerDate;
    private int opinionCounter;


}
