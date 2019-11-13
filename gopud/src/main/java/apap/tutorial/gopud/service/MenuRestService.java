package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.awt.*;
import java.util.List;

public interface MenuRestService {
    MenuModel createRestoran(MenuModel menu);

    MenuModel findById(Long idMenu);

    MenuModel changeMenu(Long id, MenuModel menu);

    MenuModel retrieveMenu(Long id);

    List<MenuModel> retrieveAllMenu();

    void deleteMenu(Long id);
}
