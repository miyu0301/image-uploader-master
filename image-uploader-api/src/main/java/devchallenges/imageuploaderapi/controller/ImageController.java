package devchallenges.imageuploaderapi.controller;

import devchallenges.imageuploaderapi.domain.Image;
import devchallenges.imageuploaderapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/")
    public ResponseEntity<ImageResponse> findAll() {
        List<Image> images = imageService.findAll();
        ImageResponse currencyResponse = ImageResponse.builder()
                .images(images)
                .build();
        return new ResponseEntity<>(currencyResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> save(@RequestBody ImageAddRequest request) {
        imageService.save(request.getName(), request.getFile());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}