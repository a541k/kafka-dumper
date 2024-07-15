package com.telcobright.dumper.service;

import com.telcobright.dumper.entity.CampaignTask;
import com.telcobright.dumper.repository.CampaignTaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampaignTaskFetcher {
    private final CampaignTaskRepository repository;

    public CampaignTaskFetcher(CampaignTaskRepository repository) {
        this.repository = repository;
    }

    public Page<CampaignTask> getTasksForCampaign(String CampaignId, Pageable pageable){
        return repository.findByCampaignIdAndStatusIsNull(CampaignId, pageable);
    }
}
