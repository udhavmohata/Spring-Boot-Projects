package com.uv.trial.recommendation.Repository;

import com.uv.trial.recommendation.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<SizeDTO,Integer>
{
    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.maleChest =?2 and s.maleHeight=?3 and s.maleSleeves=?4 and b.enable=1")
    List<BrandListOP> getMaleShirtBrandList(@Param("categoryId") int categoryId,@Param("chest") int chest, @Param("height") int height, @Param("sleeves") int sleeves);

    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.femaleChest = ?2 and s.femaleHeight=?3 and s.femaleSleeves=?4 and b.enable = 1")
    List<BrandListOP> getFemaleShirtBrandList(@Param("categoryId") int categoryId,@Param("chest") int chest,@Param("height") int height,@Param("sleeves") int sleeves);

    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.maleWaist=?2 and b.enable = 1")
    List<BrandListOP> getMaleJeanBrandList(@Param("categoryId") int categoryId,@Param("waist") int waist);

    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.femaleWaist=?2 and b.enable = 1")
    List<BrandListOP> getFemaleJeanBrandList(@Param("categoryId") int categoryId,@Param("waist") int waist);

    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.maleShoeSize=?2 and b.enable = 1")
    List<BrandListOP> getMaleShoeBrandList(@Param("categoryId") int categoryId,@Param("shoeSize") int shoeSize);

    @Query("select new com.uv.trial.recommendation.Model.BrandListOP(b.brandName , s.Size) from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.categoryId =?1 and s.femaleShoeSize=?2 and b.enable = 1")
    List<BrandListOP> getFemaleShoeBrandList(@Param("categoryId") int categoryId,@Param("shoeSize") int shoeSize);


    @Query("select new com.uv.trial.recommendation.Model.Dimension(s.maleHeight,s.maleChest,s.maleSleeves) from SizeDTO s where s.sizeId=?1")
    Dimension getMaleShirtDimension(@Param("sizeId") int sizeId);

    @Query("select new com.uv.trial.recommendation.Model.Dimension(s.femaleHeight,s.femaleChest,s.femaleSleeves) from SizeDTO s where s.sizeId=?1")
    Dimension getFemaleShirtDimension(@Param("sizeId") int sizeId);

    @Query("select s.maleWaist from SizeDTO s where s.sizeId=?1")
    Integer getMaleJeanDimension(@Param("sizeId") int sizeId);

    @Query("select s.femaleWaist from SizeDTO s where s.sizeId=?1")
    Integer getFemaleJeanDimension(@Param("sizeId") int sizeId);

    @Query("select s.maleShoeSize from SizeDTO s where s.sizeId=?1")
    Integer getMaleShoeDimension(@Param("sizeId") int sizeId);

    @Query("select s.femaleShoeSize from SizeDTO s where s.sizeId=?1")
    Integer getFemaleShoeDimension(@Param("sizeId") int sizeId);



    @Query("select new com.uv.trial.recommendation.Model.Dimension(s.maleHeight,s.maleChest,s.maleSleeves) from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Dimension getMaleShirtDimension(@Param("categoryId") int categoryId, @Param("referenceSize") String referenceSize, @Param("referenceBrand") String referenceBrand);

    @Query("select new com.uv.trial.recommendation.Model.Dimension(s.femaleHeight,s.femaleChest,s.femaleSleeves) from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Dimension getFemaleShirtDimension(@Param("categoryId") int categoryId,@Param("referenceSize") String referenceSize,@Param("referenceBrand") String referenceBrand);

    @Query("select s.maleWaist from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Integer getMaleJeanDimension(@Param("categoryId") int categoryId,@Param("referenceSize") String referenceSize, @Param("referenceBrand") String referenceBrand);

    @Query("select s.femaleWaist from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Integer getFemaleJeanDimension(@Param("categoryId") int categoryId,@Param("referenceSize") String referenceSize,@Param("referenceBrand") String referenceBrand);

    @Query("select s.maleShoeSize from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Integer getMaleShoeDimension(@Param("categoryId") int categoryId,@Param("referenceSize") String referenceSize, @Param("referenceBrand") String referenceBrand);

    @Query("select s.femaleShoeSize from SizeDTO s where s.categoryId=?1 and s.Size=?2 and s.brandId in (select b.brandId from BrandDTO b where b.brandName=?3)")
    Integer getFemaleShoeDimension(@Param("categoryId") int categoryId,@Param("referenceSize") String referenceSize,@Param("referenceBrand") String referenceBrand);



    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.maleChest=?3 and s.maleHeight=?4 and s.maleSleeves=?5")
    InterestedBrandOP getMaleShirtInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("chest") int chest,@Param("height") int height,@Param("sleeves") int sleeves);

    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.femaleChest=?3 and s.femaleHeight=?4 and s.femaleSleeves=?5")
    InterestedBrandOP getFemaleShirtInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("chest") int chest,@Param("height") int height,@Param("sleeves") int sleeves);

    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.maleWaist=?3")
    InterestedBrandOP getMaleJeanInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("waist") int waist);

    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.femaleWaist=?3")
    InterestedBrandOP getFemaleJeanInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("waist") int waist);

    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.maleShoeSize=?3")
    InterestedBrandOP getMaleShoeInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("shoeSize") int shoeSize);

    @Query("select new com.uv.trial.recommendation.Model.InterestedBrandOP(s.Size) from SizeDTO s where s.categoryId=?1 and s.brandId in(select b.brandId from BrandDTO b where b.brandName=?2 and b.enable = 1) and s.femaleShoeSize=?3")
    InterestedBrandOP getFemaleShoeInterestedSize(@Param("categoryId") int categoryId,@Param("interestedBrand") String interestedBrand,@Param("waist") int shoeSize);

    @Query("select b.brandName,s.Size from SizeDTO s inner join BrandDTO b on b.brandId = s.brandId where s.sizeId= ?1")
    String getRefBrandSize(@Param("sizeId") int sizeId);


    @Query("select count(s.sizeId) from SizeDTO s where s.Size = ?1")
    Integer getSizeId(@Param("size") String size);
}
