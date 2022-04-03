package org.openjfx;

import java.io.Serializable;
import java.util.*;

class Picture  implements Serializable{ 
    private String url;
    private String alternativeText;
  
    public Picture(String newUrl,String newAlternativeText){
      this.url = newUrl;
      this.alternativeText = newAlternativeText;
      
    }
    public Boolean setUrl (String newUrl){
      this.url = newUrl;
      return true;
    }
    public Boolean setAlternativeText (String newAlternativeText){
      this.alternativeText = newAlternativeText;
      return true;
    }
    public String getUrl (){
      return url;
    }
    public String getAlternativeText (){
      return alternativeText;
    }
}