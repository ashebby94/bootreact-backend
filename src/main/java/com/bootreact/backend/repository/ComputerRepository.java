package com.bootreact.backend.repository;

import com.bootreact.backend.entity.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Integer> {
    List<Computer> findAll();
    Computer findAllById(Integer id);
}
