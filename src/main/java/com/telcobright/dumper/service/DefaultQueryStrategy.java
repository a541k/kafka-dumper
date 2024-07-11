package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DefaultQueryStrategy<T> implements QueryStrategy<T> {
    @Override
    public Page<T> execute(SmsRepo repository, int pageNumber, int batchSize) {
        return (Page<T>) repository.findAll(PageRequest.of(pageNumber, batchSize));
    }
}

