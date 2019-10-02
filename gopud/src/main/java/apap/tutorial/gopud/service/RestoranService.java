package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;
import java.util.Optional;

public interface RestoranService {
    //Method untuk menambah restoran
    void addRestoran(RestoranModel restoran);

    //Method untuk mendapatkan semua data Restoran yang tersimpan
    List<RestoranModel> getRestoranList();

    //Method untuk mendapatkan data sebuah Restoran berdasarkan id
    Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran);

    RestoranModel changeRestoran(RestoranModel restoranModel);
}