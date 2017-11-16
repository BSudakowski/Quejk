package pl.akademiakodu.Kwejk.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.Kwejk.Model.Category;
import pl.akademiakodu.Kwejk.Model.Gif;
import pl.akademiakodu.Kwejk.service.CategoryService;
import pl.akademiakodu.Kwejk.service.GifService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GifController {

    @Autowired
    GifService gifService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String home( ModelMap modelMap){

        Category category1 = new Category("Android", new ArrayList<>());
        Category category2 = new Category("Funny", new ArrayList<>());
        Category category3 = new Category("Programming", new ArrayList<>());

        Gif gif1 = new Gif("android-explosion", "Bartek", true, category1);
        Gif gif2 = new Gif("ben-and-mike", "Bartek", true, category2);
        Gif gif3 = new Gif("book-dominos", "Bartek", true, category3);
        Gif gif4 = new Gif("compiler-bot", "Bartek", true, category1);
        Gif gif5 = new Gif("cowboy-coder", "Bartek", true, category2);
        Gif gif6 = new Gif("infinite-andrew", "Bartek", true, category3);

        categoryService.add(category1);
        categoryService.add(category2);
        categoryService.add(category3);

        gifService.add(gif1);
        gifService.add(gif2);
        gifService.add(gif3);
        gifService.add(gif4);
        gifService.add(gif5);
        gifService.add(gif6);


        modelMap.put("gifs", gifService.findAll());
        return "home";
    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap){
        List<Gif> favoriteGifs = new ArrayList<>();
        for(Gif f : gifService.findAll()){
            if(f.isFavorites()){
                favoriteGifs.add(f);
            }
        }
        modelMap.put("fav", favoriteGifs);

        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String details(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("gif", gifService.findOneByName(name));
        return "gif-details";
    }

    @GetMapping("/categories")
    public String categories(ModelMap modelMap){
        modelMap.put("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, ModelMap modelMap){
       Category c = categoryService.findOneById(id);
       List<Gif> gifs = gifService.findAll().stream().filter((g)->g.getCategory().getName().equals(c.getName())).collect(Collectors.toList());
       //System.out.println(gifs);
       modelMap.addAttribute("category", c);
       modelMap.addAttribute("gifs", gifs);
       return "category";
    }

    @GetMapping("/search")
    public String search(@RequestParam String q, ModelMap modelMap){
       //System.out.println(gifDao.findOne(q));
       if(q.equals("android-explosion") || q.equals("ben-and-mike") || q.equals("book-dominos") || q.equals("compiler-bot") || q.equals("cowboy-coder") || q.equals("infinite-andrew")) {
           modelMap.addAttribute("gif", gifService.findOneByName(q));
           return "gif-details";
       } else if(q.equals("Android") || q.equals("Funny") || q.equals("Programming")){
           Category c = categoryService.findOneByName(q);
           List<Gif> gifs = gifService.findAll().stream().filter((g)->g.getCategory().getName().equals(c.getName())).collect(Collectors.toList());
           //System.out.println(gifs);
           modelMap.addAttribute("category", c);
           modelMap.addAttribute("gifs", gifs);
           return "category";
       }

       return "home";
    }
}
