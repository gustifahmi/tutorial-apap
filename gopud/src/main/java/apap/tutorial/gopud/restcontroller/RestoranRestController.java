package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.rest.RecipeDetail;
import apap.tutorial.gopud.rest.RecipeResponse;
import apap.tutorial.gopud.rest.RestoranDetail;
import apap.tutorial.gopud.service.RestoranRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class RestoranRestController {
    @Autowired
    private RestoranRestService restoranRestService;

    @PostMapping(value = "/restoran")
    private RestoranModel createRestoran(@Valid @RequestBody RestoranModel restoran, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else{
            return
                    restoranRestService.createRestoran(restoran);
        }
    }

    @GetMapping(value = "/restoran/{idRestoran}")
    private RestoranModel retriveRestoran(@PathVariable("idRestoran") Long idRestoran){
        try{
            return restoranRestService.getRestoranByIdRestoran(idRestoran);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Restoran "+String.valueOf(idRestoran)+" Not Found");
        }
    }

    @DeleteMapping(value = "/restoran/{idRestoran}")
    private ResponseEntity<String> deleteRestoran(@PathVariable("idRestoran") Long idRestoran){
        try{
            restoranRestService.deleteRestoran(idRestoran);
            return ResponseEntity.ok("Restoran with ID "+String.valueOf(idRestoran)+" Deleted!");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Restoran with ID "+String.valueOf(idRestoran)+" Not Found!");
        }catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Restoran still has menu, please delete the menu first!");
        }
    }

    @PutMapping(value = "/restoran/{idRestoran}")
    private RestoranModel updateRestoran(
            @PathVariable (value="idRestoran") Long idRestoran,
            @RequestBody RestoranModel restoran
    ) {
        try {
            return restoranRestService.changeRestoran(idRestoran, restoran);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Restoran "+String.valueOf(idRestoran)+" Not Found");
        }
    }

    @GetMapping(value="/restorans")
    private List<RestoranModel> retriveListRestoran(){
        return
                restoranRestService.retriveListRestoran();
    }

    @GetMapping(value = "/restoran/{idRestoran}/status")
    private Mono<String> getStatus(@PathVariable Long idRestoran){
        return restoranRestService.getStatus(idRestoran);
    }

    // Mapping Get ini hanya untuk mengecek apakah service consumer kita berhasil atau tidak
    @GetMapping(value = "/full")
    private Mono<RestoranDetail> postStatus(){
        return restoranRestService.postStatus();
    }

    @GetMapping(value = "/restoran/recipes")
    private Mono<RecipeResponse> retrieveRecipes(@RequestParam(value = "excludeIngredient") String excludeIngredient){
        return restoranRestService.retrieveRecipes(excludeIngredient);
    }
}
