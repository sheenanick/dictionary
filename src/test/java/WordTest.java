import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void Word() {
    Word word = new Word("beer");
    assertEquals(true, word instanceof Word);
  }

}
