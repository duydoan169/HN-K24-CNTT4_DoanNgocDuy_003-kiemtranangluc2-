package org.example.kiemtranangluc2.service.impl;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.example.kiemtranangluc2.dto.GameItemDTO;
import org.example.kiemtranangluc2.model.GameItem;
import org.example.kiemtranangluc2.model.Rarity;
import org.example.kiemtranangluc2.repository.GameItemRepository;
import org.example.kiemtranangluc2.repository.RarityRepository;
import org.example.kiemtranangluc2.service.IGameItemService;
import org.example.kiemtranangluc2.service.upload.UploadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameItemServiceImpl implements IGameItemService {

    private final GameItemRepository gameItemRepository;
    private final UploadService uploadService;
    private final RarityRepository rarityRepository;

    @Override
    public Page<GameItem> search(String search, Long filter, Pageable pageable) {
        return gameItemRepository.search(search, filter, pageable);
    }

    @Override
    public void saveGameItem(GameItemDTO dto) {
        GameItem gameItem = new GameItem();
        gameItem.setItemName(dto.getItemName());
        gameItem.setGameTitle(dto.getGameTitle());
        gameItem.setDropDate(dto.getDropDate());
        gameItem.setMarketPrice(dto.getMarketPrice());
        gameItem.setIsTradeable(dto.getIsTradeable());

        if (dto.getFile() != null && !dto.getFile().isEmpty()) {
            gameItem.setItemImage(uploadService.uploadFile(dto.getFile()));
        }

        Rarity rarity = rarityRepository.getReferenceById(dto.getRarityId());
        gameItem.setRarity(rarity);

        gameItemRepository.save(gameItem);
    }
}
