package ch.bbw.modul133.catmanagement.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class ReadData {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File file;

    public ReadData() {
        try {
            file = new ClassPathResource("database.json").getFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Es ist ein Fehler aufgetreten. Das File konnte nicht gelesen werden");
        }
    }

    public CatManagement readFile() {
        try {
            return objectMapper.readValue(file, CatManagement.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Es ist ein Fehler aufgetreten. Das File konnte nicht gelesen werden");
        }
    }

    public void persist(CatManagement catHotel) {
        try {
            objectMapper.writeValue(file, catHotel);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Es ist ein Fehler aufgetreten. Das File konnte nicht gelesen werden");
        }
    }
}
