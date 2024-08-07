package com.example.ClusteredData.Warehouse;

import com.example.ClusteredData.Warehouse.Entities.Deal;
import com.example.ClusteredData.Warehouse.Repositories.DealRepository;
import com.example.ClusteredData.Warehouse.Services.DealService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DealServiceTests {

    @Autowired
    private DealService dealService;

    @MockBean
    private DealRepository dealRepository;

    @Test
    public void testSaveDeal() {
        Deal deal = new Deal();
        deal.setDealUniqueId("112");
        deal.setFromCurrencyIsoCode("USD");
        deal.setToCurrencyIsoCode("OMR");
        deal.setDealTimestamp(LocalDateTime.now());
        deal.setDealAmount(1000.00);

        Mockito.when(dealRepository.findById("112")).thenReturn(Optional.empty());

        assertTrue(dealService.saveDeal(deal));
    }

    @Test
    public void testSaveDuplicateDeal() {
        Deal deal = new Deal();
        deal.setDealUniqueId("112");
        deal.setFromCurrencyIsoCode("USD");
        deal.setToCurrencyIsoCode("OMR");
        deal.setDealTimestamp(LocalDateTime.now());
        deal.setDealAmount(1000.00);

        Mockito.when(dealRepository.findById("112")).thenReturn(Optional.of(deal));

        assertFalse(dealService.saveDeal(deal));
    }
}

