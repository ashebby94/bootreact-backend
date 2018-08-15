package com.bootreact.backend.mvc.controller;

import com.bootreact.backend.mvc.entity.Computer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/v1/api")
public class ComputerController {

    private Map<Integer, Computer> computerMap;

    public ComputerController() {
        computerMap = new HashMap<>();
        computerMap.put(1, new Computer(1,"macbook", "95.216.151.235", "5F-CF-C4-1B-5E-9F", "Lagos, Nigeria", "2017-05-14"));
        computerMap.put(2, new Computer(2,"samsung", "66.150.125.57", "CA-6A-A9-A3-D0-80", "New York, USA", "2015-05-11" ));
        computerMap.put(3, new Computer(3,"toshiba", "221.30.82.108", "A3-E3-39-DE-03-EF", "London, England", "2013-05-12" ));
        computerMap.put(4, new Computer(4,"sony", "192.221.139.50", "C4-D2-4C-D9-5C-B4", "Tokyo Japan", "2012-09-14" ));
        computerMap.put(5, new Computer(5,"microsoft", "235.105.123.124", "96-3B-A6-42-B0-68", "Birmingham England", "2017-05-16" ));
    }

    @CrossOrigin
    @GetMapping("/computers")
    public String getComputers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Computer> list = new ArrayList<>(computerMap.values());
        return mapper.writer().withRootName("computers").writeValueAsString(list);
    }

    @CrossOrigin
    @GetMapping("/computers/{id}")
    public String getComputerById(@PathVariable Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().withRootName("computer").writeValueAsString(computerMap.get(id));
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(@PathVariable Integer id) {
        computerMap.remove(id);
    }

    @CrossOrigin
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public void addComputer(@RequestBody Computer computer) {
        computer.setId(computerMap.size() + 1);
        LocalDate localDate = LocalDate.now();
        computer.setDate(localDate.toString());
        computerMap.put(computer.getId(), computer);
    }

}
