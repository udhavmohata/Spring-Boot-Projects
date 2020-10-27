package com.uv.trial.recommendation.Controller;

import com.uv.trial.recommendation.Model.BrandDTO;
import com.uv.trial.recommendation.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController
{
    @Autowired
    BrandRepository brandRepository;

    @PostMapping("/new")
    public BrandDTO newBrand(@RequestBody BrandDTO brandDTO)
    {
        return brandRepository.save(brandDTO);
    }

    @GetMapping("/showAll")
    public List<BrandDTO> showBrands()
    {
        return (List<BrandDTO>) brandRepository.findAll();
    }

    @GetMapping("/show/{id}")
    public Optional<BrandDTO> showBrand(@PathVariable int id)
    {
        return brandRepository.findById(id);
    }

}
