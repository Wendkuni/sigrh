package com.sigrh.gestionressourceh.web.personnel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.common.constant.TypeNature;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.services.personnel.AffectationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class AffectationController {
     AffectationService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/affectation",consumes =MULTIPART_FORM_DATA_VALUE)
    public boolean createPersonnel(@RequestPart(value = "image") MultipartFile imageDossier,MultipartFile imageSanitaire, @RequestPart(value = "affectation") String affectation) {
        try {
            objectMapper.findAndRegisterModules();
            PersonnelAffectationModel model = objectMapper.readValue(affectation, PersonnelAffectationModel.class);
            return service.create(imageDossier,imageSanitaire, model);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create affectation", e);
        }
    }
    @PutMapping(path = "/affectation/{id}")
    public boolean updateAffectation(@RequestParam Integer id, PersonnelAffectationModel model) {
        return service.update(id,model);
    }
    @PutMapping(path = "/affectation/{id}",consumes =MULTIPART_FORM_DATA_VALUE)
    public boolean updatePersonnel(@RequestPart(value = "image") MultipartFile imageDossier,MultipartFile imageSanitaire,@PathVariable Integer id, PersonnelAffectationModel model) throws IOException {
        model.setImgDos(imageDossier.getBytes());
        model.setImgSanit(imageSanitaire.getBytes());
        return service.update(id,model);
    }

    @DeleteMapping(path = "/affectation/delete/{id}")
    public boolean deleteAffectation(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/affectations")
    public List<PersonnelAffectationModel> getAllAffectation() {
        return service.findAll();
    }

    @GetMapping(path = "/affectationsBy/{id}")
    public PersonnelAffectationModel getAffectationById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/affectationsByAgent/{IDagent}")
    public List<PersonnelAffectationModel> getAffectationByAgent(@PathVariable Integer IDagent) {
        return service.findByAgent(IDagent);
    }

    @GetMapping(path = "/TypeNature")
    public ResponseEntity<ApiResponse<List<String>>> getAllTypeNature(){
        List<String> types = Arrays.stream(TypeNature.values()).map(e->e.toString().toUpperCase()).toList();
        ApiResponse<List<String>> response=new ApiResponse.Builder<List<String>>().
                status(HttpStatus.OK.value())
                .message("Liste des types nature").result(types).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/image/{id}",produces = {IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public Map<String,Object> getImage(@PathVariable int id){
        try {
            return this.service.getImage(id);
        } catch (DataFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
