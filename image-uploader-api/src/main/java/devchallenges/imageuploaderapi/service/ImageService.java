package devchallenges.imageuploaderapi.service;

import devchallenges.imageuploaderapi.domain.Image;
import devchallenges.imageuploaderapi.domain.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Image save(String name, String file) {
        return imageRepository.save(Image.newImage(name, file));
    }

}
