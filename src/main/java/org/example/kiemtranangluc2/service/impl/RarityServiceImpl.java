package org.example.kiemtranangluc2.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.kiemtranangluc2.model.Rarity;
import org.example.kiemtranangluc2.repository.RarityRepository;
import org.example.kiemtranangluc2.service.IRarityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RarityServiceImpl implements IRarityService {
    private final RarityRepository rarityRepository;

    @Override
    public List<Rarity> getAllRarities() {
        return rarityRepository.findAll();
    }
}
