package pl.akademiakodu.Kwejk.Dao;

import pl.akademiakodu.Kwejk.Model.Category;
import pl.akademiakodu.Kwejk.Model.Gif;

import java.util.List;
import java.util.Set;

public interface CategoryDao {
    List<Category> findAll();
    Category findFavorite(int index);

    Category findOne(String name);
    Set<Category> findCategory();
}
