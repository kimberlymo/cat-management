package ch.bbw.modul133.catmanagement;

import ch.bbw.modul133.catmanagement.model.Cat;
import ch.bbw.modul133.catmanagement.model.CatService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CatServiceTest {
    @Test
    public void createUpdateRead() {
        var service = new CatService(new MockCatRepository());

        var cat = new Cat();
        cat.setName("Bobby");
        cat.setColor("white");
        cat.setBirthday("today");
        cat.setOutdoor(true);

        cat = service.createCat(cat);

        var cats1 = service.getAllCats();

        assertTrue(cats1.contains(cat));

        var newCat = new Cat();
        cat.setName("Bobby");
        cat.setColor("white");
        cat.setBirthday("today");
        //  bobby got scared of the outside world
        cat.setOutdoor(false);

        service.updateById(newCat, "Bobby");

        var cats2 = service.getAllCats();

        assertTrue(cats2.contains(newCat));
        assertFalse(cats2.contains(cat));
    }
}
