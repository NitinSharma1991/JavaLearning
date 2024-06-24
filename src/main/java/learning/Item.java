package learning;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Item {

    private int id;
    private String name;
    private String category;

}