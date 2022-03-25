package application;
import java.lang.*;
import java.util.*;

class Picture { 
    private String url;
    private String alternativeText;
  
    public Picture(String newUrl,String newAlternativeText){
      this.url = newUrl;
      this.alternativeText = newAlternativeText
      
    }
    public Boolean setUrl (String newUrl){
      return true;
    }
    public Boolean setAlternativeText (String newAlternativeText){
      return true;
    }
    public String getUrl (){
      return url;
    }
    public String getAlternativeText (){
      return alternativeText;
    }
}