package g53554.humbug.view.jfx;

import g53554.humbug.model.Animal;

public class AnimalAndIndex {
    private Animal animal;
    private int index;
    private boolean sType;
    private boolean isPresent;

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public AnimalAndIndex() {
        animal = null;
        index = 0;
        sType = false;

    }

    public boolean issType() {
        return sType;
    }
    

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setsType(boolean sType) {
        this.sType = sType;
    }
}
