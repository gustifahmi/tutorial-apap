package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

public interface MenuService {
    void addMenu(MenuModel menu);
    List<MenuModel> findAllMenuByIdRestoran(Long idRestoran);
    List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran);
    void deleteMenu(MenuModel menu);
}
