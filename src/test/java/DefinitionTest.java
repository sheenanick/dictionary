import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition definition = new Definition("an alcoholic drink made from yeast-fermented malt flavored with hops");
    assertEquals(true, definition instanceof Definition);
  }

}
