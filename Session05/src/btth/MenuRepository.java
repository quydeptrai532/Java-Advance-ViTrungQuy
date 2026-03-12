package btth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuRepository {

    private List<MenuItem> menuList = new ArrayList<>();

    public void add(MenuItem item){
        menuList.add(item);
    }

    public void showAll(){

        for(MenuItem item : menuList){
            System.out.println(item);
        }

    }

    public Optional<MenuItem> findById(String id){

        return menuList.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    public void delete(String id){

        menuList.removeIf(i -> i.getId().equals(id));

    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
}