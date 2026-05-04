package org.example.kiemtranangluc2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "game_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GameItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String itemName;

    @Column
    private String gameTitle;

    @Column
    private Double marketPrice;

    @Column
    private LocalDate dropDate;

    @Column
    private String itemImage;

    @Column
    private Boolean isTradeable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rarity_id")
    private Rarity rarity;

}
