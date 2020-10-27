package com.uv.trial.recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
public class BrandDTO
{
    @Id
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "enable")
    private int enable;
}
