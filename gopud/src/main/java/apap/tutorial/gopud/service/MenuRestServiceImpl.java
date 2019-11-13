package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService{
    @Autowired
    private MenuDb menuDb;

    @Override
    public MenuModel findById(Long idMenu) {
        Optional<MenuModel> menu = menuDb.findById(idMenu);
        if (menu.isPresent()){
            return menu.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public MenuModel createRestoran(MenuModel menu) {
        return menuDb.save(menu);
    }

    @Override
    public MenuModel changeMenu(Long id, MenuModel updatedMenu) {
        updatedMenu.setId(id);
        return menuDb.save(updatedMenu);
    }

    @Override
    public MenuModel retrieveMenu(Long id){
        return findById(id);
    }

    @Override
    public List<MenuModel> retrieveAllMenu() {
        return menuDb.findAll();
    }

    @Override
    public void deleteMenu(Long id) {
        menuDb.deleteById(id);
    }

}
