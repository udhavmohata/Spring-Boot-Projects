package com.uv.trial.recommendation.Util;

import com.uv.trial.recommendation.Exception.*;
import com.uv.trial.recommendation.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputCheckService
{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserHistoryRepository userHistoryRepository;

    public void CategoryCheck(String CategoryName)
    {
        if(categoryRepository.getCategoryId(CategoryName)==null)
            throw new InvalidCategoryException();
    }

    public void GenderCheck(String gender)
    {
        if(!(gender.equals("M")||gender.equals("m")) && !(gender.equals("F")||gender.equals("f")))
            throw new InvalidGenderException();
    }
    public void BrandListIpCheck(int height,int chest,int sleeves)
    {
        if(height==0)
            throw new InvalidInputException("height");
        if(chest==0)
            throw new InvalidInputException("Chest");
        if(sleeves==0)
            throw new InvalidInputException("sleeves");

    }
    public void BrandListIpCheck(int size)
    {
        if(size==0)
            throw new InvalidInputException("Dimension");
    }
    public void InterestedBrandIpCheck(String ReferenceBrand,String InterestedBrand,String Size)
    {
        if(ReferenceBrand==null || ReferenceBrand.equals("") || ReferenceBrand.equals(" "))
            throw new InvalidInputException(": Reference Brand cannot be empty.");
        else if(brandRepository.getBrandId(ReferenceBrand)==null)
            throw new InvalidBrandException(ReferenceBrand);
        InterestedBrandIpCheck(InterestedBrand);
        SizeCheck(Size);
    }
    public void InterestedBrandIpCheck(String InterestedBrand)
    {
        if(InterestedBrand==null || InterestedBrand.equals("") || InterestedBrand.equals(" "))
            throw new InvalidInputException(": Interested Brand cannot be empty.");
        else if(brandRepository.getBrandId(InterestedBrand)==null)
            throw new InvalidBrandException(InterestedBrand);
    }
    public void SizeCheck(String size)
    {
        if(size==null || size.equals("") || size.equals(" "))
            throw new InvalidInputException(": Reference Size cannot be empty.");
        else if(sizeRepository.getSizeId(size)==0)
            throw new InvalidInputException("size");
    }
    public void MobileNumberCheck(String MobileNumber)
    {
        if(userRepository.getUserId(MobileNumber)!=null)
            throw new NotUniqueException();
    }
    public void PreviousPurchaseCheck(int userId)
    {
        if(userHistoryRepository.getHistory(userId).isEmpty())
            throw new NoPreviousPurchaseException();
    }
}
