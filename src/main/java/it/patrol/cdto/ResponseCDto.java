package it.patrol.cdto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ResponseCDto {

    @SerializedName("offers")
    private List<OfferCDto> offers = new LinkedList<>();

}
