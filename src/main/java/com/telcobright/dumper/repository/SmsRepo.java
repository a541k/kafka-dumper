package com.telcobright.dumper.repository;

import com.telcobright.dumper.entity.Campaign;
import com.telcobright.dumper.service.CampaignQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SmsRepo extends JpaRepository<Campaign, String> {
   /* @Query("Select c from Campaign c")
    Page<Campaign> findByQuery(Pageable pageable);

    @Query("Select c from Campaign c where c.campaignId =:campaignId")
    Optional<Campaign> findByCampaignId(@Param("campaignId") String campaignId);*/

    @Query("Select c from Campaign c")
    public List<Campaign> findAllCampaigns(Pageable page);
}
