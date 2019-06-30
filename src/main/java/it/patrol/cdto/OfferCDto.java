package it.patrol.cdto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class OfferCDto {

    @SerializedName("id")
    private String offerId;

    @SerializedName("OfferUrl")
    private String offerUrl;

    @SerializedName("Opinion")
    private OpinionCDto opinion;

}
