package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class EntityFetcher<T>{

    @Autowired
    private  SmsRepo repository;

    public void fetchEntities() {
        int pageNumber = 0;
        int batchSize = 10;

        Page<T> entityPage;

        do {
            entityPage = (Page<T>) repository.findAll(PageRequest.of(pageNumber++, batchSize));
            System.out.println(entityPage.getContent());
        } while (entityPage.hasContent());
    }
}
