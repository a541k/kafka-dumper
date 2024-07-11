package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;

import java.util.List;

@FunctionalInterface
public interface CampaignQuery<T> {
    List<T> fetch();
}
