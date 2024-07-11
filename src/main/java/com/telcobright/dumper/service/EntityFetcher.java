package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EntityFetcher<T> {

    @Autowired
    private SmsRepo repository;

    private QueryStrategy<T> queryStrategy;

    public EntityFetcher(QueryStrategy<T> queryStrategy) {
        this.queryStrategy = queryStrategy;
    }

    public void setQueryStrategy(QueryStrategy<T> queryStrategy) {
        this.queryStrategy = queryStrategy;
    }

    public void fetchEntities() {
        int pageNumber = 0;
        int batchSize = 10;

        Page<T> entityPage;

        do {
            entityPage = queryStrategy.execute(repository, pageNumber++, batchSize);
            System.out.println(entityPage.getContent());
        } while (entityPage.hasContent());
    }
}
