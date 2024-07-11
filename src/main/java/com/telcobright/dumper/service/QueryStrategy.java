package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface QueryStrategy<T> {
    Page<T> execute(SmsRepo repository, int pageNumber, int batchSize);
}
