package ch.bbw.modul133.catmanagement;

import ch.bbw.modul133.catmanagement.model.CatManagement;
import ch.bbw.modul133.catmanagement.model.FileRepository;

import java.util.ArrayList;

public class MockCatRepository implements FileRepository<CatManagement> {
    private CatManagement data = new CatManagement(new ArrayList<>());

    @Override
    public CatManagement readFile() {
        return this.data;
    }

    @Override
    public void persist(CatManagement catHotel) {
        this.data = catHotel;
    }
}
