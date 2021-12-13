package com.example.finalserverjava.controller;


import com.example.finalserverjava.model.Application;
import com.example.finalserverjava.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/api/pets/{petId}/applications")
    public Application createApplication(
            @PathVariable("petId") String bid,
            @RequestBody Application newApplication) {
        newApplication.setPetId(bid);
        return applicationService.createApplication(newApplication);
    }

    @GetMapping("/api/pets/{petId}/applications")
    public List<Application> findApplicationsForPet(
            @PathVariable("petId") String bid) {
        return applicationService.findApplicationsForPet(bid);
    }

    @GetMapping("/api/users/{userId}/applications")
    public List<Application> findApplicationsForUsers(
            @PathVariable("userId") int uid) {
        return applicationService.findApplicationsForUser(uid);
    }

    @PutMapping("/api/applications/{applicationId}")
    public int updateApplication(
            @PathVariable("applicationId") int aid,
            @RequestBody Application application
    ) {
        return applicationService.updateApplication(aid, application);
    }

    @DeleteMapping("/api/applications/{applicationId}")
    public int deleteApplication(
            @PathVariable("applicationId") int rid
    ) {
        return applicationService.deleteApplication(rid);
    }

    @GetMapping("/api/applications")
    public List<Application> findAllApplications() {
        return applicationService.findAllApplications();
    }
}
