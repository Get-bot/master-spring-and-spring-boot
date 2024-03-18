package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private final DataService dataService;

    public BusinessCalculationService (DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {return Arrays.stream(dataService.retrieveDate()).max().orElse(0);}
}
