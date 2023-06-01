package finki.learnify_backend.controllers;

import finki.learnify_backend.services.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/api/course-images")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ImageStoringController {
    private final FileDataService fileDataService;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = fileDataService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=fileDataService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpg"))
                .body(imageData);

    }


}
