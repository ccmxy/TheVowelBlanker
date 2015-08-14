import java.util.Map;
import java.util.HashMap;
import java.io.Console;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class WordPuzzle {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/puzzlePage", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzlePage.vtl");
      String wordToPuzzle = request.queryParams("wordToPuzzle");
      String puzzledWord = wordPuzzle(wordToPuzzle);
      model.put("puzzledWord", puzzledWord);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static String wordPuzzle(String theWord1){
    String theWord = new String(theWord1);
    char[] theWordArray = theWord.toCharArray();
    String vowels = "aeiou";
    int length = theWord.length();
    int idx;

    for(idx = 0; idx < length; idx++){
      if (theWordArray[idx] == 'a'){
        theWordArray[idx] = '-';
      }
      else if(theWordArray[idx] == 'e'){
        theWordArray[idx] = '-';
      }
      else if(theWordArray[idx] == 'i'){
        theWordArray[idx] = '-';
      }
      else if(theWordArray[idx] == 'o'){
        theWordArray[idx] = '-';
      }
      else if(theWordArray[idx] == 'u'){
        theWordArray[idx] = '-';
      }
    }//End for loop

    String wordWithDashes = new String(theWordArray);
    return wordWithDashes;
  }//End of method

}//End of class
