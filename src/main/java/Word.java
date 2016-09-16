import java.util.ArrayList;
import java.util.List;

public class Word {
  private String mWord;
  private List<Definition> mDefinitions = new ArrayList<Definition>();
  private static List<Word> instances = new ArrayList<Word>();
  private int mId;

  public Word(String word) {
    mWord = word;
    mId = instances.size();
    instances.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public List<Definition> getDefinitions() {
    return mDefinitions;
  }

  public int getId() {
    return mId;
  }

  public static List<Word> all() {
    return instances;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public static Word find(int id) {
    try {
      return instances.get(id);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

}
