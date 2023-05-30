package finki.learnify_backend.services;

import com.fasterxml.jackson.databind.util.NativeImageUtil;
import finki.learnify_backend.models.FileData;
import finki.learnify_backend.repository.FileDataRepository;
import finki.learnify_backend.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;
    private final String filePath = "C:\\Users\\Drej\\Desktop\\IKT_Project\\Learnify_backend\\src\\main\\resources\\courseImages\\";
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        FileData fileData = fileDataRepository.
                save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath + file.getOriginalFilename())
                .build());

        file.transferTo(new File(filePath + file.getOriginalFilename()));

            return "File uploaded successfully:" + file.getOriginalFilename();
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> dbFileData = fileDataRepository.findByName(fileName);
        String filePath = dbFileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
