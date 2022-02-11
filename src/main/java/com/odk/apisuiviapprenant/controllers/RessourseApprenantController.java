package com.odk.apisuiviapprenant.controllers;

import com.odk.apisuiviapprenant.models.authers.RessourseApprenant;
import com.odk.apisuiviapprenant.models.authers.RessourseApprenantServiceImpl;
import com.odk.apisuiviapprenant.models.authers.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ressourceApprenant")
public class RessourseApprenantController {

    @Autowired
    RessourseApprenantServiceImpl ressourseApprenantService;

    @PostMapping("/addUrl")
    RessourseApprenant addUrl(@RequestBody RessourseApprenant apprenant){
        return ressourseApprenantService.addUrl(apprenant);
    }

    @PostMapping("/uploadRessource")
    @ResponseBody
    RessourseApprenant uploadRessource(RessourseApprenant apprenant, @PathVariable("file")MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        apprenant.setPdf(fileName);
        String uploadDir = "src/main/resources/files/";
        UploadFile.saveFile(uploadDir, fileName, multipartFile);

        return ressourseApprenantService.addPdf(apprenant);
    }

    @GetMapping("/ressouceByApprenant/{id}")
    List<RessourseApprenant> ressouceByApprenant(@PathVariable("id") Long id){
        return ressourseApprenantService.ressourceApprenantByIdApprenant(id);
    }
}
