package by.onliner.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HeaderMenu {
    CATALOG("Каталог");

    @Getter
    private String menuText;

}
