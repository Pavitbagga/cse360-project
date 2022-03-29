import java.lang.*;
import java.util.*;

class MenuItem{
    private String name;
    private Picture pic;
    private ArrayList <String> ingredient;
    private ArrayList <String> tags;
    private Integer price;
    private Integer prepTime;
    private Integer category;

    public MenuItem (String newName, Picture newPic, Integer newPrice, Integer  newPrepTime, Integer newCategory){
        tags = new ArrayList<String>();
        ingredient = new ArrayList<String>();
        this.name = newName;
        this.pic = newPic;
        this.price = newPrice;
        this.prepTime = newPrepTime;
        this.category = newCategory;
    }
    public void setPictureDescription (String description){
        pic.setAlternativeText(description);
    }
    public Boolean setPictureURL (String newURL){
        return pic.setURL(newURL);
    }
    public Boolean setPrice(Integer newPrice){
        if(newPrice > 0){
            price = newPrice;
            return true;
        }
        return false;
    }
    public Boolean setPrepTime (Integer newPrepTime ){
        if(newPrepTime > 0){
            prepTime = newPrepTime;
            return true;
        }
        return false;
    }
    public void setCategory (Integer newCategory){
        category = newCategory;
    }
    public Boolean addIngredient(String newIngredient){
         ingredient.add(newIngredient);
         return true;
    }
    public Boolean addTag(String newTag){
        tags.add(newTag);
        return true;

    }
    public Boolean removeTags(String oldtag){
        tags.remove(oldtag);
        if(tags.contains(oldtag) == true){
            return false;
        }
        else{
            return true;
        }

    }
    public Boolean removeIngredients(String oldIngredients){
        ingredient.remove(oldIngredients);
        if(ingredient.contains(oldIngredients)){
            return false;
        }
        else{
            return true;
        }

    }
    public String getName(){
        return name;
    }
    public Picture getPicture(){
        return pic;
    }
    public ArrayList <String> getTags(){
        return tags;
    }
    public ArrayList <String> getIngredients(){
        return ingredient;
    }
    public Integer getPrice(){
        return price;
    }
    public Integer getPrepTime(){
        return prepTime;
    }
    public Integer getCategory(){
        return category;
    }

}
