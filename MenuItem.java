package application;
import java.lang.*;
import java.util.*;

class MenuItem{
  private String name;
  private Picture pic;
  private String[] ingredientList;
  private String[] tags;
  private Integer price;
  private Integer prepTime;
  private String category;
  public MenuItem (String newName, Picture newPic, Integer newPrice, Integer  newPrepTime, String newCategory){
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
  public void setCategory (Categories newCategory){
    category = newCategory;
  }
  public Boolean addIngredient(String newIngredient){
    return ingredients;
  }
  public Boolean addTag(String newTag){
    return newTag;
  }
  public Boolean removeTags(String oldtag){
    ArrayList <String> tags = new ArrayList<String>();
    for (String element : tags){
        if(element.contains(String)){
          return false;
        }
        else{
          return true;
        }
      }
    
  }
  public Boolean removeIngredients(){
    ArrayList <String> ingredients = new ArrayList<String>();
    for (String list : ingredients){
        if(list.contains(String)){
          return false;
        }
        else{
          return true;
        }
      }
  }
  public String getName(){
    return name;
  }
  public Picture getPicture(){
    return pic;
  }
  public String[] getTags(){
    return tags;
  }
  public String[] getIngredients(){
    return ingredientList;
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

