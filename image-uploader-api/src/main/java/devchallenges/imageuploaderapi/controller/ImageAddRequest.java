package devchallenges.imageuploaderapi.controller;

import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
public class ImageAddRequest {

    private String name;
    private String file;

}