package dto;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class Vehicle  implements Serializable {

    private String color;
    private int model;
    private String owner;

}
