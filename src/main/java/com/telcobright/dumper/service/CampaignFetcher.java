package com.telcobright.dumper.service;

import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.repository.CampaignRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampaignFetcher implements EntityFetcher<Campaign, String>{
    private final CampaignRepository campaignRepository;

    public CampaignFetcher(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Page<Campaign> fetchEntities(Pageable pageable) {
        return campaignRepository.findAll(pageable);
    }
}
