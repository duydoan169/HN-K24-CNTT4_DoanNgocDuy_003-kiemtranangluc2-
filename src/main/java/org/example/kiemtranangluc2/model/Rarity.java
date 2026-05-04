package org.example.kiemtranangluc2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rarities")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Rarity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double dropRate;

    @OneToMany(mappedBy = "rarity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<GameItem> gameItems;
}
