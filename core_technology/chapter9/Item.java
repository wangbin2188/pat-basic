package chapter9;

import java.util.Objects;

public class Item implements Comparable<Item>{
    private String description;
    private int partNum;

    public Item(String description, int partNum) {
        this.description = description;
        this.partNum = partNum;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNum == item.partNum &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNum);
    }

    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNum, other.partNum);
        return diff != 0 ? diff : description.compareTo(other.getDescription());
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNum=" + partNum +
                '}';
    }
}
