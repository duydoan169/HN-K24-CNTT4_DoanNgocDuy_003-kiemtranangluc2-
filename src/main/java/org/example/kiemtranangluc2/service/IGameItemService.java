package org.example.kiemtranangluc2.service;

import org.example.kiemtranangluc2.dto.GameItemDTO;
import org.example.kiemtranangluc2.model.GameItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGameItemService {
    Page<GameItem> search(String search, Long filter, Pageable pageable);
    void saveGameItem(GameItemDTO dto);
}
