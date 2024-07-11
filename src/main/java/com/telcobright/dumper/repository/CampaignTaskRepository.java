package com.telcobright.dumper.repository;

import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.entity.CampaignTask;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignTaskRepository extends JpaRepository<CampaignTask, String> {
    Page<CampaignTask> findByCampaignId(String campaignId, Pageable pageable);



    @Query("Select t from CampaignTask t where t.campaignId = :campaignId and t.status is null")
    Page<CampaignTask> getFailedTaskBatch(Pageable pageable, String campaignId);
}
