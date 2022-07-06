package ch.bbw.modul133.catmanagement;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class Cat {

    @NotNull
    @Size(min=2, max = 30)
    private String name;

    @NotNull
    private String birthday;

    private boolean isOutdoor;

    @Size(min=3, max=30)
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isOutdoor() {
        return isOutdoor;
    }

    public void setOutdoor(boolean outdoor) {
        isOutdoor = outdoor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name, String birthday, boolean isOutdoor, String color) {
        this.name = name;
        this.birthday = birthday;
        this.isOutdoor = isOutdoor;
        this.color = color;
    }

    public Cat() {
    }
}
