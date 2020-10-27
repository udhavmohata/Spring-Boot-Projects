package com.uv.trial.recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user_history")
public class UserHistoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    @Column(name = "user_id")
    public int userId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "size_id")
    private int sizeId;
}
