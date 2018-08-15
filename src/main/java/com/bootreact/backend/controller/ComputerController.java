package com.bootreact.backend.controller;

import com.bootreact.backend.entity.Computer;
import com.bootreact.backend.repository.ComputerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="/v1/api")
public class ComputerController {

    @Autowired
    ComputerRepository computerRepository;

    @CrossOrigin
    @GetMapping("/computers")
    public String getComputers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().withRootName("computers").writeValueAsString(computerRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/computers/{id}")
    public String getComputerById(@PathVariable Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writer().withRootName("computer").writeValueAsString(computerRepository.findAllById(id));
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void deleteComputer(@PathVariable Integer id) {
        computerRepository.deleteById(id);
    }

    @CrossOrigin
    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
    public Computer addComputer(@RequestBody Computer computer) {
        List<Computer> list = computerRepository.findAll();
        list.size();
        computer.setId(list.size() + 1);
        LocalDate localDate = LocalDate.now();
        computer.setDate(localDate.toString());
        return computerRepository.save(computer);

    }

}
