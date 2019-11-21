package cz.sspbrno.bookstore.interfaces;

import cz.sspbrno.bookstore.controllers.Store;

public interface Interactable {
    void interact();
    void updateText();
    void setStore(Store store);
}
