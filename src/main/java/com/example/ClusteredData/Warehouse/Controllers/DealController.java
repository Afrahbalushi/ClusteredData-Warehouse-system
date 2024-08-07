package com.example.ClusteredData.Warehouse.Controllers;

import com.example.ClusteredData.Warehouse.Entities.Deal;
import com.example.ClusteredData.Warehouse.Services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    private DealService dealService;

    @PostMapping
    public ResponseEntity<String> saveDeal(@RequestBody Deal deal) {
        if (dealService.saveDeal(deal)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Deal saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Deal already exists");
        }
    }

}