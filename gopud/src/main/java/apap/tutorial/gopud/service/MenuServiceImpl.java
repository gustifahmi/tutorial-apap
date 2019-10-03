package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.HashMap;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDb menuDb;

    @Override
    public void addMenu(MenuModel menu) {
        menuDb.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDb.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran) {
        List<MenuModel> menuList = findAllMenuByIdRestoran(idRestoran);
        Collections.sort(menuList, new HargaComparator());
        return menuList;
    }

    @Override
    public void deleteMenu(MenuModel menu) {menuDb.delete(menu);}
}

class HargaComparator implements Comparator<MenuModel> {
    public int compare(MenuModel menu1, MenuModel menu2) {
        return menu1.getHarga().compareTo(menu2.getHarga());
    }
}