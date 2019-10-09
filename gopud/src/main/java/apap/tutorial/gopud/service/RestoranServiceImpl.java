package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.RestoranDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RestoranServiceImpl implements RestoranService{
    @Autowired
    private RestoranDb restoranDb;

    @Override
    public void addRestoran(RestoranModel restoran) {
        restoranDb.save(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return restoranDb.findAll();
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        return restoranDb.findByIdRestoran(idRestoran);
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        // mengambil object restoran yang ingin diubah
        RestoranModel targetRestoran = restoranDb.findById(restoranModel.getIdRestoran()).get();

        try{
            targetRestoran.setNama(restoranModel.getNama());
            targetRestoran.setAlamat(restoranModel.getAlamat());
            targetRestoran.setNomorTelepon(restoranModel.getNomorTelepon());
            restoranDb.save(targetRestoran);
            return targetRestoran;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public void deleteRestoran(Long idRestoran) {
        RestoranModel restoran = getRestoranByIdRestoran(idRestoran).get();
        if(restoran.getListMenu().size()==0){
            restoranDb.delete(restoran);
        }else{
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
}
