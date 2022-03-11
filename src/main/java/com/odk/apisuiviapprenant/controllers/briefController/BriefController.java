package com.odk.apisuiviapprenant.controllers.briefController;

import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.service.briefService.BriefService;
import com.odk.apisuiviapprenant.service.briefService.BriefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BriefController {

    @Autowired
    BriefService briefService;

    @PostMapping("ajoutBrief")
    Brief addBrief( Brief brief, @RequestParam("file") MultipartFile file) throws IOException {
        return briefService.addBrief(brief, file);
    }

    @GetMapping("allBrief")
    List<Brief> allBrief(){
        return briefService.allBrief();
    }

    @GetMapping("briefById/{id}")
    Brief briefById(@PathVariable("id")Long id){
        return briefService.briefById(id);
    }

    @GetMapping("findBriefByApprenant/{id}")
    List<Brief> findBriefByApprenant(@PathVariable("id") Long id){

        return briefService.findBriefByApprenant(id);
    }

    /*
        Pour recupere une photo en fonction de son ID
    */
    @GetMapping(value = "findBriefPhoto/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    byte[] findPhoto(@PathVariable("id") Long id) throws IOException{
        return briefService.getPhoto(id);
    }

    @PutMapping("updateBrief/{id}")
    Brief updateBrief(@RequestBody Brief brief, @PathVariable("id") Long id){
        return briefService.updateBrief(brief, id);
    }


}
