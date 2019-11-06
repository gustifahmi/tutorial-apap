package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    //Constructor
    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public RestoranModel addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
        return restoran;
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    @Override
    public RestoranModel getRestoranByIdRestoran(Long idRestoran) {
        for(int i = 0; i < listRestoran.size(); i++) {
            if (listRestoran.get(i).getIdRestoran().equals(idRestoran)) {
                return listRestoran.get(i);
            }
        }
        return null;
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoran) {
        return null;
    }

    @Override
    public void deleteRestoran(Long idRestoran) {

    }
}
