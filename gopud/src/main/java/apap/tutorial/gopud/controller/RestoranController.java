package apap.tutorial.gopud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuService;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

import javax.validation.constraints.Null;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    //URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    //URL mapping yang digunakan untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            //Request Parameter untuk dipass
            @RequestParam(value = "idRestoran") Long idRestoran, Model model
    ) {
        try{
            RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

            //Add model restoran ke "resto" untuk dirender
            model.addAttribute("resto", restoran);
            List<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
            model.addAttribute("menuList", menuList);

        }catch (NoSuchElementException nullException){
            return "view-restoran-error";
        }
        //Return view template
        return "view-restoran";
    }

    //URL Mapping viewAll
    @RequestMapping(value="/restoran/view-all")
    public String viewAll(Model model) {

        //Mengambil data semua objek restoran yang ada
        List<RestoranModel> restoranList = restoranService.getRestoranList();

        //Add objek restoran ke "restoranList" untuk dirender
        model.addAttribute("restoranList", restoranList);

        //Return view template view-all-store
        return "view-all-restoran";

    }


    //API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        //Mengambil existing data restoran
        try{
            RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran);
            model.addAttribute("restoran", existingRestoran);
            return "form-change-restoran";
        }catch (NoSuchElementException e){
            model.addAttribute("idRestoran", idRestoran);
            return "change-restoran-error";
        }
    }

    //API yang digunakan untuk submit form change resetoran
    @RequestMapping(value="restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        try{
            RestoranModel newRestoranData = restoranService.addRestoran(restoran);
            model.addAttribute("restoran", newRestoranData);
        }
        catch (NoSuchElementException e){
            model.addAttribute("idRestoran", idRestoran);
            return "change-restoran-error";
        }

        return "change-restoran";
    }

    //URL mapping delete
    @RequestMapping("/restoran/delete/{idRestoran}")
    public String delete(@PathVariable("idRestoran") Long idRestoran, Model model) {
        try{
            restoranService.deleteRestoran(idRestoran);
        }catch (NoSuchElementException e){
            model.addAttribute("errorMessage", "Id " +  idRestoran.toString() + " tidak ditemukan");
            return "delete-restoran-error";
        }catch (UnsupportedOperationException e){
            model.addAttribute("errorMessage", "Tidak berhasil dihapus karena restoran memiliki menu!");
            return "delete-restoran-error";
        }
        return "delete-restoran";
    }
}