package com.telcobright.dumper.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@FunctionalInterface
public interface EntityFetcher<T, ID>{
    Iterable<T> fetchEntities(Pageable pageable);
}
