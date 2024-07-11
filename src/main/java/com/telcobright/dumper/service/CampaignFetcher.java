package com.telcobright.dumper.service;

import com.telcobright.dumper.entity.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CampaignFetcher extends EntityFetcher<Campaign>{


    @Autowired
    private DefaultQueryStrategy defaultStrategy;

    @Autowired
    private CustomQueryStrategy customStrategy;

    @Autowired
    public CampaignFetcher(DefaultQueryStrategy defaultStrategy) {
        super(defaultStrategy);
        this.defaultStrategy = defaultStrategy;
    }

    public void fetchCampaign(boolean useCustomSpecification, Specification<Campaign> specification) {
        if (useCustomSpecification && specification != null) {
            customStrategy.setSpecification(specification);
            setQueryStrategy(customStrategy);
        } else {
            setQueryStrategy(defaultStrategy);
        }
        fetchEntities();
    }
}
