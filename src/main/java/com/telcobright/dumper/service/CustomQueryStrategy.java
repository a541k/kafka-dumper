package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CustomQueryStrategy<T> implements QueryStrategy<T> {
    private Specification<T> specification;

    public CustomQueryStrategy(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public Page<T> execute(SmsRepo repository, int pageNumber, int batchSize) {
        return (Page<T>) repository.findAll(specification, PageRequest.of(pageNumber, batchSize));
    }

    public void setSpecification(Specification<T> specification) {
        this.specification = specification;
    }
}
