package apap.tutorial.gopud.service;

import org.springframework.stereotype.Service;
import apap.tutorial.gopud.model.RestoranModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        boolean adaRestoran = false;
        int index = 0;
        RestoranModel restoran = null;
        while (!adaRestoran && index < listRestoran.size()) {
            if (listRestoran.get(index).getIdRestoran().equals(idRestoran)) {
                adaRestoran = true;
                restoran = listRestoran.get(index);
            }
            else
                index += 1;
        }
        return Optional.of(restoran);
    }

    public RestoranModel changeRestoran(RestoranModel restoranModel){
        return null;
    }
}
