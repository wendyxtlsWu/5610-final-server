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

    public List<Application> findApplicationsForPet(String bid) {
        return applicationRepository.findApplicationsForPet(bid);
    }

    public List<Application> findApplicationsForUser(int uid) {
        return applicationRepository.findApplicationsForUser(uid);
    }

    public int deleteApplication(int rid) {
        applicationRepository.deleteById(rid);
        return 1;
    }

    public List<Application> findApplications() {
        return applicationRepository.findApplications();
    }
}
