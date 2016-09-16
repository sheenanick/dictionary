import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After
  public void tearDown() {
    Definition.clear();
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition definition = new Definition("an alcoholic drink made from yeast-fermented malt flavored with hops");
    assertEquals(true, definition instanceof Definition);
  }

  @Test
  public void Definition_getDefinition_anAlcoholicDrink() {
    Definition definition = new Definition("an alcoholic drink made from yeast-fermented malt flavored with hops");
    assertEquals("an alcoholic drink made from yeast-fermented malt flavored with hops", definition.getDefinition());
  }

  @Test
  public void Definition_getId_0() {
    Definition definition = new Definition("an alcoholic drink made from yeast-fermented malt flavored with hops");
    assertEquals(0, definition.getId());
  }

}
