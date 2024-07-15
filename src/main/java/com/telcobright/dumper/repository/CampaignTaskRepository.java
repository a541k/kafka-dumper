package com.telcobright.dumper.repository;

import com.telcobright.dumper.entity.CampaignTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CampaignTaskRepository extends JpaRepository<CampaignTask, String> {
    //status null --- tasks to be fetched
//    @Query("SELECT ct from CampaignTask ct where ct.campaignId = :campaignId and ct.status is null")
//    Iterable<CampaignTask> getTasksForCampaign(@Param("campaignId") String campaignId, Pageable pageable);

    Page<CampaignTask> findByCampaignIdAndStatusIsNull(@Param("campaignId") String campaignId, Pageable pageable);
}
