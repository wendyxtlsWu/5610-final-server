package com.example.finalserverjava.service;

import com.example.finalserverjava.model.Application;
import com.example.finalserverjava.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    public Application createApplication(Application newApplication) {
        return applicationRepository.save(newApplication);
    }

    public List<Application> findApplicationsForPet(String pid) {
        return applicationRepository.findApplicationsForPet(pid);
    }

    public List<Application> findApplicationsForUser(int uid) {
        return applicationRepository.findApplicationsForUser(uid);
    }

    public int updateApplication(int aid, Application application) {
        Application oldApplication = applicationRepository.findApplicationById(aid);
        oldApplication.setPetTitle(application.getPetTitle());
        applicationRepository.save(oldApplication);
        return 1;
    }

    public int deleteApplication(int aid) {
        applicationRepository.deleteById(aid);
        return 1;
    }

    public List<Application> findAllApplications() {
        return applicationRepository.findAllApplications();
    }
}
