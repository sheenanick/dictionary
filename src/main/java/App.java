import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word beer = new Word("beer");
      Definition beerDef = new Definition("beer def");
      beer.addDefinition(beerDef);
      Word vodka = new Word("vodka");
      Definition vodkaDef = new Definition("vodka def");
      vodka.addDefinition(vodkaDef);
      Word tequila = new Word("tequila");
      Definition tequilaDef = new Definition("tequila def");
      tequila.addDefinition(tequilaDef);
      Word gin = new Word("gin");
      Definition ginDef = new Definition("gin def");
      gin.addDefinition(ginDef);
      Word whiskey = new Word("whiskey");
      Definition whiskeyDef1 = new Definition("whiskey def1");
      whiskey.addDefinition(whiskeyDef1);
      Definition whiskeyDef2 = new Definition("whiskey def2");
      whiskey.addDefinition(whiskeyDef2);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = new Word(request.queryParams("word"));
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id/definitions/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Definition definition = new Definition(request.queryParams("definition"));
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      word.addDefinition(definition);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }
}
