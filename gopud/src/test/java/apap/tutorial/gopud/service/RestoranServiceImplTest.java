package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.RestoranDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RestoranServiceImplTest {

    @InjectMocks
    RestoranService restoranService = new RestoranServiceImpl();

    @Mock
    RestoranDb restoranDb;

    @Test
    public void whenAddValidRestoranItShouldCallRestoranRepositorySave() {
        RestoranModel newRestoran = new RestoranModel();
        newRestoran.setNama("mekdi");
        newRestoran.setAlamat("pacil");
        newRestoran.setNomorTelepon("14045");
        restoranService.addRestoran(newRestoran);
        verify(restoranDb, times(1)).save(newRestoran);
    }

    @Test
    public void whenGetRestoranListCalledItShouldReturnAllRestoran() {
        List<RestoranModel> allRestoranInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allRestoranInDatabase.add(new RestoranModel());
        }
        when (restoranService.getRestoranList()).thenReturn(allRestoranInDatabase);
        List<RestoranModel> dataFromServiceCall = restoranService.getRestoranList();
        assertEquals(3, dataFromServiceCall.size());
        verify(restoranDb, times(1)).findAll();
    }

    @Test
    public void whenGetRestoranByIdCalledByExistingDataItShouldReturnCorrectData() {
        RestoranModel returnedData = new RestoranModel();
        returnedData.setNama("kaefci");
        returnedData.setAlamat("TB Simatupang");
        returnedData.setIdRestoran((long)1);
        returnedData.setNomorTelepon("14022");
        RestoranModel dataFromServiceCall = restoranService.getRestoranByIdRestoran(1L);
        verify(restoranDb, times(1)).findByIdRestoran(1L);
        assertEquals("kaefci", dataFromServiceCall.getNama());
        assertEquals("TB Simatupang", dataFromServiceCall.getAlamat());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getIdRestoran());
        assertEquals(Integer.valueOf(14022), dataFromServiceCall.getNomorTelepon());
    }

    @Test
    public void whenChangeRestoranCalledItShouldChangeRestoranData() {
        RestoranModel updatedData = new RestoranModel();
        updatedData.setNama("kaefci");
        updatedData.setAlamat("dummy");
        updatedData.setIdRestoran((long)1);
        updatedData.setNomorTelepon("14022");
        when(restoranDb.findById(1L)).thenReturn(Optional.of(updatedData));
        when(restoranService.changeRestoran(updatedData)).thenReturn(updatedData);
        RestoranModel dataFromServiceCall = restoranService.changeRestoran(updatedData);
        assertEquals("kaefci", dataFromServiceCall.getNama());
        assertEquals("dummy", dataFromServiceCall.getAlamat());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getIdRestoran());
        assertEquals(Integer.valueOf(14022), dataFromServiceCall.getNomorTelepon());
    }

}