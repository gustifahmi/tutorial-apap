package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;

    //URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
            //Request parameter untuk dipass
            @RequestParam(value="idRestoran") String idRestoran,
            @RequestParam(value="nama") String nama,
            @RequestParam(value="alamat") String alamat,
            @RequestParam(value="nomorTelepon") Integer nomorTelepon,
            Model model
    ) {

        //Membuat objek RestoranModel
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        //Memanggil service addRestoran
        restoranService.addRestoran(restoran);

        //add variabel nama restoran ke "namaResto" untuk dirender
        model.addAttribute("namaResto", nama);

        //Return view template
        return "add-restoran";
    }

    //URL mapping view
    @RequestMapping("/restoran/view")
    public String view(
            //Request parameter untuk dipass
            @RequestParam(value = "idRestoran")
                    String idRestoran,
                    Model model
    ) {
        //Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        //Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        //Return view template
        return "view-restoran";
    }

    //URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {
        //Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        //Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        //Return view template
        return "viewall-restoran";
    }
}