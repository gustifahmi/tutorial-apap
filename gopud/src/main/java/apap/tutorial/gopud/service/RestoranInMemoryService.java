package apap.tutorial.gopud.service;

import org.springframework.stereotype.Service;
import apap.tutorial.gopud.model.RestoranModel;
import java.util.List;
import java.util.ArrayList;

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
    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        boolean adaRestoran = false;
        int index = 0;
        while (!adaRestoran && index < listRestoran.size()){
            if(listRestoran.get(index).getIdRestoran().equalsIgnoreCase(idRestoran))
                adaRestoran = true;
            else
                index += 1;
        }
        if (adaRestoran)
            return listRestoran.get(index);
        else
            return null;
    }
}
