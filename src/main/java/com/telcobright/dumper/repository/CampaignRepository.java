package com.telcobright.dumper.repository;

import com.telcobright.dumper.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, String> {
}
