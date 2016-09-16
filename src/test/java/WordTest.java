import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WordTest {

  @After
  public void tearDown() {
    Word.clear();
  }

  @Test
  public void Word() {
    Word word = new Word("beer");
    assertEquals(true, word instanceof Word);
  }

  @Test
  public void Word_getWord_beer() {
    Word word = new Word("beer");
    assertEquals("beer", word.getWord());
  }

  @Test
  public void Word_getId_0() {
    Word word = new Word("beer");
    assertEquals(0, word.getId());
  }

  @Test
  public void Word_getDefinitions_ArrayList() {
    Word word = new Word("whiskey");
    Definition definition1 = new Definition("a spirit distilled from malted grain, especially barley or rye.");
    Definition definition2 = new Definition("a code word representing the letter W, used in radio communication.");
    List<Object> expectedOutput = new ArrayList<Object>();
    expectedOutput.add(definition1); expectedOutput.add(definition2);
    word.addDefinition(definition1); word.addDefinition(definition2);
    assertEquals(expectedOutput, word.getDefinitions());
  }

}
