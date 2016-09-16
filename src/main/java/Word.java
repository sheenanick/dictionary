import java.util.ArrayList;
import java.util.List;

public class Word {
  private String mWord;
  private List<Definition> mDefinition = new ArrayList<Definition>();
  private static List<Word> instances = new ArrayList<Word>();
  private int mId;

  public Word(String word) {
    mWord = word;
    mId = instances.size();
    instances.add(this);
  }

}
