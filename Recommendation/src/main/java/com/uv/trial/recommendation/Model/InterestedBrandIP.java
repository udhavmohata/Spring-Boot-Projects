package com.uv.trial.recommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InterestedBrandIP
{
    private String CategoryName;
    private String ReferenceBrand;
    private String ReferenceSize;
    private String InterestedBrand;
    private String gender;
}
