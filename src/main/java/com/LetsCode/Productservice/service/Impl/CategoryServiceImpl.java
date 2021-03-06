package com.LetsCode.Productservice.service.Impl;

import com.LetsCode.Productservice.Dto.CategoryDto;
import com.LetsCode.Productservice.domain.model.CategoryEntity;
import com.LetsCode.Productservice.domain.model.Product;
import com.LetsCode.Productservice.domain.repository.CategoryRepository;
import com.LetsCode.Productservice.domain.repository.ProductRepository;
import com.LetsCode.Productservice.exception.CategoryNotFoundException;
import com.LetsCode.Productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl  implements CategoryService {

    final CategoryRepository repository;


    @Override
    public List<CategoryDto> getAllCategoryList() {

        return repository.findAll()
                .stream()
                .map(category -> new CategoryDto(category.getCategoryname(), category.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(long id) {
        CategoryEntity category = repository.getById(id);
        repository.delete(category);
    }

    @Override
    public void newCategory(CategoryDto categoryDto) {
       CategoryEntity categoryEntity;
        categoryEntity = new CategoryEntity(categoryDto.getId(), categoryDto.getCategoryname());
        repository.save(categoryEntity);
    }

   public CategoryEntity findByCategoryname(String categoryname) throws CategoryNotFoundException{
           return repository
            .findByCategoryname(categoryname)
            .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));

    }
}
