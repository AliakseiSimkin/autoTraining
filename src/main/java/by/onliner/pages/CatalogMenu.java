package by.onliner.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CatalogMenu {
    ELECTRONICS(1),
    COMPUTERS(2),
    APPLIANCES(3),
    CONSTRUCTION(4),
    HOUSE(5),
    VEHICLES(6),
    BEAUTY(7),
    CHILDREN(8),
    WORK(9);

    @Getter
    private int subMenuNumber;
}
