package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;

public interface MenuService {
    void addMenu(MenuModel menu);
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);
    MenuModel findById(Long idMenu);

    MenuModel changeRestoran(MenuModel restoran);

    void deleteMenu(Long idMenu);

    List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran);

    void deleteMenu(MenuModel menu);
}
