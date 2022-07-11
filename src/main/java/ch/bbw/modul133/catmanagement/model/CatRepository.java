package ch.bbw.modul133.catmanagement.model;

import ch.bbw.modul133.catmanagement.model.Cat;
import ch.bbw.modul133.catmanagement.model.CatManagement;
import ch.bbw.modul133.catmanagement.model.ReadData;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Component
public class CatRepository {
    private final ReadData readData = new ReadData();

    public List<Cat> getAllCats() {
        return readData.readFile().cats();
    }

    public Cat createCat(Cat catToCreate) {
        Optional<Cat> cat = getAllCats().stream()
                .filter(catDto -> catDto.getName().equals(catToCreate.getName())).findFirst();

        if (cat.isPresent()) {
            throw new IllegalArgumentException("The cat with the name: " + catToCreate.getName() + " already exists");
        }

        CatManagement newList = readData.readFile();
        newList.cats().add(catToCreate);
        readData.persist(newList);
        return catToCreate;
    }

    public Cat updateById(Cat catToUpdate, String name) {
        CatManagement newList = readData.readFile();
        int index = IntStream.range(0, getAllCats().size())
                .filter(i -> getAllCats().get(i).getName().equals(name))
                .findFirst().getAsInt();

        catToUpdate.setName(name);
        newList.cats().set(index, catToUpdate);
        readData.persist(newList);
        return catToUpdate;
    }
}
