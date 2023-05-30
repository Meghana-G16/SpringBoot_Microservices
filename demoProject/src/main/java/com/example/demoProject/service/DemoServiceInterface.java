package com.example.demoProject.service;

import com.example.demoProject.dto.DemoDTO;
import com.example.demoProject.repository.DemoRepository;

public interface DemoServiceInterface extends DemoRepository {
    DemoDTO getDemoDetails(Long demoId);
}
