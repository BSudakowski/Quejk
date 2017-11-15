package pl.akademiakodu.Kwejk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiakodu.Kwejk.Dao.CategoryDao;
import pl.akademiakodu.Kwejk.Dao.GifDaoImpl;
import pl.akademiakodu.Kwejk.Model.Category;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.List;

@RestController
public class RestfulController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    GifDaoImpl gifDao;

    @RequestMapping("/restfulcategories")
    public List<Category> restfulCategories(){
        return categoryDao.findAll();
    }

    @RequestMapping("/restfulcategory")
    public Category resutfulCategory(@RequestParam(value="name", defaultValue=("Android")) String name){
        return categoryDao.findOne(name);
    }

    @RequestMapping("/restfulgifs")
    public List<Gif> restfulGifs(){
        return gifDao.findAll();
    }
}
