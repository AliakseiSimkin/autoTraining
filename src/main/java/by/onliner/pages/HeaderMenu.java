package by.onliner.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum HeaderMenu {
    CATALOG("Каталог"),
    NEWS("Новости"),
    CARMARKET("Автобарахолка"),
    HOUSES("Дома и квартиры"),
    SERVICES("Услуги"),
    FLEAMARKET("Барахолка"),
    FORUM("Форум");


    @Getter
    private String menuText;

}
