package pl.akademiakodu.Kwejk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.Kwejk.Dao.CategoryRepository;
import pl.akademiakodu.Kwejk.Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService() {

    }

    public void add(Category category){
        categoryRepository.save(category);
    }

    public List<Category> findAll(){
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach((g)->categories.add(g));
        return categories;
    }

    public Category findOneById(Long id){
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.get();
    }

    public Category findOneByName(String name){
        return categoryRepository.findOneByName(name);
    }
}
