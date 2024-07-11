package com.telcobright.dumper.service;

import com.telcobright.dumper.repository.SmsRepo;

import java.util.List;

public class PagedEntityFetcher<T> {
    private final SmsRepo campaignRepository;

    public PagedEntityFetcher(SmsRepo campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public void getCampaign(String campaignId){
       // List<T> campaignList = campaignRepository.findAllCampaigns();
    }
}
