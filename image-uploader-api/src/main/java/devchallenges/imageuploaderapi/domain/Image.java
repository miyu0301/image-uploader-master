package devchallenges.imageuploaderapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.charset.StandardCharsets;
import java.time.DateTimeException;
import java.util.Date;

@Entity
@Setter
@Getter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image_name;
    private byte[] image_data;
    private Date ins_datetime;
    private Date upd_datetime;

    public static Image newImage(String image_name, String image_data) {
        Image image = new Image();
        image.image_name = image_name;
        image.image_data = image_data.getBytes();
        image.ins_datetime = new Date();
        image.upd_datetime = new Date();
        return image;
    }

}