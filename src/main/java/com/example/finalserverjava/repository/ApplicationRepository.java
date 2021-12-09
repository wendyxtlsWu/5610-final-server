package com.example.finalserverjava.repository;

import com.example.finalserverjava.model.Application;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public interface ApplicationRepository  extends CrudRepository<Application, Integer> {
        @Query("SELECT application from Application application WHERE application.petId=:petId")
        public List<Application> findApplicationsForPet(@Param("petId") String bid);

        @Query("SELECT application from Application application WHERE application.userId=:userId")
        public List<Application> findApplicationsForUser(@Param("userId") int uid);

        @Query("SELECT application from Application application WHERE application.id=:applicationId")
        public Application findApplicationById(@Param("applicationId") int rid);

        @Query(value="SELECT * FROM applications ORDER BY applications.id DESC", nativeQuery=true)
        public List<Application> findAllApplications();

    }
