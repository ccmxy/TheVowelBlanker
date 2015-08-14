import org.junit.*;
import static org.junit.Assert.*;

public class WordPuzzleTest {

  @Test
  public void wordPuzzle_wordWithoutSpaces_bnnn() {
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("b-n-n-", testWordPuzzle.wordPuzzle("banana"));
  }

  @Test
  public void wordPuzzle_wordWithSpaces_ccrmsnd(){
    WordPuzzle testWordPuzzle = new WordPuzzle();
    assertEquals("-c- cr--m s-nd--", testWordPuzzle.wordPuzzle("ice cream sundae"));
  }
}
