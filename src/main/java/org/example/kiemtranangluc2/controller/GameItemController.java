package org.example.kiemtranangluc2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kiemtranangluc2.dto.GameItemDTO;
import org.example.kiemtranangluc2.model.GameItem;
import org.example.kiemtranangluc2.repository.GameItemRepository;
import org.example.kiemtranangluc2.service.IGameItemService;
import org.example.kiemtranangluc2.service.IRarityService;
import org.example.kiemtranangluc2.service.impl.GameItemServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gameItems")
@RequiredArgsConstructor
public class GameItemController {

    private final IGameItemService gameItemService;
    private final IRarityService rarityService;

    @GetMapping
    public String gameItemList(Model model,
                               @RequestParam(defaultValue = "") String search,
                               @RequestParam(required = false) Long filter,
                               @PageableDefault(page = 0, size = 5, direction = Sort.Direction.ASC) Pageable pageable){
        Page<GameItem> result = gameItemService.search(search, filter, pageable);
        model.addAttribute("pageable", result);
        model.addAttribute("search", search);
        model.addAttribute("filter", filter);
        model.addAttribute("rarities", rarityService.getAllRarities());
        return "game-item-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("gameItemDTO", new GameItemDTO());
        model.addAttribute("rarities", rarityService.getAllRarities());
        return "form";
    }

    @PostMapping("/create")
    public String saveGameItem(
            @Valid @ModelAttribute GameItemDTO gameItemDTO,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("rarities", rarityService.getAllRarities());
            return "form";
        }
        gameItemService.saveGameItem(gameItemDTO);
        return "redirect:/gameItems";
    }
}
