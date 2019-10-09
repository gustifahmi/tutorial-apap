package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
    private String addMenuFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model){
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        
        List<MenuModel> menuList = new ArrayList<>();
        
        menuList.add(new MenuModel());
        restoran.setListMenu(menuList);
        model.addAttribute("resto", restoran);

        return "form-add-menu";

    }

    @RequestMapping(value = "/menu/add/{restoranId}", params={"save"}, method = RequestMethod.POST)
    private String addMenuSubmit(@ModelAttribute RestoranModel restoran, Model model){
        RestoranModel curr = restoranService.getRestoranByIdRestoran(restoran.getIdRestoran()).get();
        List<MenuModel> menus = restoran.getListMenu();
        for(int i=0; i<menus.size(); i++) {
        	menus.get(i).setRestoran(curr);
        	menuService.addMenu(menus.get(i));
        }

        return "add-menu";
    }
    
    @RequestMapping(value = "/menu/add/{restoranId}", params= {"addRow"}, method=RequestMethod.POST)
    private String addRow(@ModelAttribute RestoranModel restoran, Model model) {
    	
    	if (restoran.getListMenu() == null || restoran.getListMenu().size() == 0) {
    		restoran.setListMenu(new ArrayList<>());
    	}
    	restoran.getListMenu().add(new MenuModel());
    	model.addAttribute("resto", restoran);
    	
    	return "form-add-menu";
    }
    
    @RequestMapping(value = "/menu/add/{restoranId}", params= {"deleteRow"}, method=RequestMethod.POST)
    private String deleteRow(@ModelAttribute RestoranModel restoran, final HttpServletRequest req,  Model model) {
    	final Integer rowId = Integer.valueOf(req.getParameter("deleteRow"));
    	restoran.getListMenu().remove(rowId.intValue());
    	
    	model.addAttribute("resto", restoran);
    	return "form-add-menu";
    }
    
    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    private String delete(@ModelAttribute RestoranModel restoran, Model model) {
    	for (MenuModel menu : restoran.getListMenu()) {
    		menuService.deleteMenu(menu);
    	}
    	return "delete";
    }
}
