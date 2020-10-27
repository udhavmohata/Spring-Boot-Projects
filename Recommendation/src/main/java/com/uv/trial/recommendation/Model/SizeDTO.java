package com.uv.trial.recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "size")
public class SizeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "size_id")
    private int sizeId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "male_height")
    private int maleHeight;
    @Column(name = "male_chest")
    private int maleChest;
    @Column(name = "male_sleeves")
    private int maleSleeves;
    @Column(name = "male_waist_cm")
    private int maleWaist;
    @Column(name = "male_shoes_cm")
    private int maleShoeSize;
    @Column(name = "female_height")
    private int femaleHeight;
    @Column(name = "female_chest")
    private int femaleChest;
    @Column(name = "female_sleeves")
    private int femaleSleeves;
    @Column(name = "female_waist_cm")
    private int femaleWaist;
    @Column(name = "female_shoes_cm")
    private int femaleShoeSize;
    @Column(name = "size")
    private String Size;
}

