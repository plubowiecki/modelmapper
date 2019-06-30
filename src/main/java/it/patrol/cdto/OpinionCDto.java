package it.patrol.cdto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class OpinionCDto {

    @SerializedName("Counter")
    private int counter;

}
