package com.example.ClusteredData.Warehouse.Services;

import com.example.ClusteredData.Warehouse.Entities.Deal;
import com.example.ClusteredData.Warehouse.Repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public boolean saveDeal(Deal deal) {
        Optional<Deal> existingDeal = dealRepository.findById(deal.getDealUniqueId());
        if (existingDeal.isPresent()) {
            return false;
        }
        dealRepository.save(deal);
        return true;
    }

}