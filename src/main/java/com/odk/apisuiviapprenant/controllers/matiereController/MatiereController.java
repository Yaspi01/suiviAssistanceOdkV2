package com.odk.apisuiviapprenant.controllers.matiereController;

import com.odk.apisuiviapprenant.models.authers.UploadFile;
import com.odk.apisuiviapprenant.models.matiereModel.Matiere;
import com.odk.apisuiviapprenant.service.matiereService.MatiereServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MatiereController {

    @Autowired
    MatiereServiceImpl matiereService;

    @PostMapping("addMatiere")
    @ResponseBody
    Matiere addMatiere(Matiere matiere, @RequestParam("file") MultipartFile file) throws IOException {
        String fileNamne = StringUtils.cleanPath(file.getOriginalFilename());
        matiere.setPhoto(fileNamne);
        String uploadDir = "src/main/resources/files/";
        UploadFile.saveFile(uploadDir, fileNamne, file);
        return matiereService.addMatiere(matiere);
    }

    @GetMapping("allMatiere")
    List<Matiere> allMatiere(){
        return matiereService.allMatiere();
    }

    @GetMapping("matiereById/{id}")
    Matiere matiereById(@PathVariable("id") Long id){
        return matiereService.matiereById(id);
    }

    @PutMapping("updateMatiere/{id}")
    Matiere updateMatiere(@PathVariable("id") Long id, @RequestBody Matiere matiere){
        return matiereService.updateMatiere(matiere, id);
    }

    /*
        Pour recupere une photo en fonction de son ID
    */
    @GetMapping(value = "findMatierePhoto/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    byte[] findPhoto(@PathVariable("id") Long id) throws IOException{
        return matiereService.getPhoto(id);
    }
}
