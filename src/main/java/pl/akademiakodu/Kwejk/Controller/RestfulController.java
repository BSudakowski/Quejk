package pl.akademiakodu.Kwejk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiakodu.Kwejk.Model.Category;
import pl.akademiakodu.Kwejk.Model.Gif;
import pl.akademiakodu.Kwejk.service.CategoryService;
import pl.akademiakodu.Kwejk.service.GifService;

import java.util.List;

@RestController
public class RestfulController {

    @Autowired
    GifService gifService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/restfulcategories")
    public List<Category> restfulCategories(){
        return categoryService.findAll();
    }

    @RequestMapping("/restfulcategory")
    public Category resutfulCategory(@RequestParam(value="name", defaultValue=("Android")) String name){
        return categoryService.findOneByName(name);
    }

    @RequestMapping("/restfulgifs")
    public List<Gif> restfulGifs(){
        return gifService.findAll();
    }
}
