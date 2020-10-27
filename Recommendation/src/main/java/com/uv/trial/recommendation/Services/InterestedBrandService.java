package com.uv.trial.recommendation.Services;

import com.uv.trial.recommendation.Exception.InvalidInputException;
import com.uv.trial.recommendation.Exception.UnexpectedException;
import com.uv.trial.recommendation.Model.*;
import com.uv.trial.recommendation.Repository.CategoryRepository;
import com.uv.trial.recommendation.Repository.SizeRepository;
import com.uv.trial.recommendation.Repository.UserHistoryRepository;
import com.uv.trial.recommendation.Util.InputCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestedBrandService
{
    @Autowired
    UserHistoryRepository userHistoryRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    InputCheckService inputCheckService;


    public InterestedBrandOP showInterestedService(UserDTO userDTO, InterestedBrandIP interestedBrandIP){
        String RefBrand,RefSize;
        int CategoryId = categoryRepository.getCategoryId(interestedBrandIP.getCategoryName());

        if(interestedBrandIP.getReferenceBrand() == null && interestedBrandIP.getReferenceSize() == null) {
            inputCheckService.PreviousPurchaseCheck(userDTO.getUserId());
            int sizeId = userHistoryRepository.getHistory(userDTO.getUserId(),CategoryId);
            inputCheckService.InterestedBrandIpCheck(interestedBrandIP.getInterestedBrand());
            String str = sizeRepository.getRefBrandSize(sizeId);
            String[] str1 = str.split(",");
            RefBrand = str1[0];
            RefSize = str1[1];
        }
        else {
            inputCheckService.InterestedBrandIpCheck(interestedBrandIP.getReferenceBrand(),interestedBrandIP.getInterestedBrand(),interestedBrandIP.getReferenceSize());
            RefBrand = interestedBrandIP.getReferenceBrand();
            RefSize = interestedBrandIP.getReferenceSize();
        }
        String gender;
        if(interestedBrandIP.getGender() == null)
            gender = userDTO.getGender();
        else {
            inputCheckService.GenderCheck(interestedBrandIP.getGender());
            gender = interestedBrandIP.getGender();
        }
        try {
            switch (CategoryId) {
                case 1:
                    if (gender.equals("M") || gender.equals("m")) {
                        Dimension dimension = sizeRepository.getMaleShirtDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleShirtInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    } else {
                        Dimension dimension = sizeRepository.getFemaleShirtDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleShirtInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    }

                case 2:
                    if (gender.equals("M") || gender.equals("m")) {
                        int Waist = sizeRepository.getMaleJeanDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleJeanInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), Waist);
                    } else {
                        int Waist = sizeRepository.getFemaleJeanDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleJeanInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), Waist);
                    }

                case 3:
                    if (gender.equals("M") || gender.equals("m")) {
                        int ShoeSize = sizeRepository.getMaleShoeDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleShoeInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), ShoeSize);
                    } else {
                        int ShoeSize = sizeRepository.getFemaleShoeDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleShoeInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), ShoeSize);
                    }

                default:
                    throw new UnexpectedException("Unexpected Exception Found.");
            }
        }
        catch(NullPointerException e)
        {
            throw new InvalidInputException(": Category, Size or Brand Mismatch found");
        }
    }
}
