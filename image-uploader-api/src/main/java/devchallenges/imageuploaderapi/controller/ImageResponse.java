package devchallenges.imageuploaderapi.controller;

import devchallenges.imageuploaderapi.domain.Image;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ImageResponse {

    private List<Image> images;
}