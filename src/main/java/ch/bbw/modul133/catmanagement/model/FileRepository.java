package ch.bbw.modul133.catmanagement.model;

public interface FileRepository<T> {
    T readFile();

    void persist(CatManagement catHotel);
}
