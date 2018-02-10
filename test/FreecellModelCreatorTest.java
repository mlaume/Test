import static org.junit.Assert.assertTrue;

import cs3500.hw02.FreecellModel;
import cs3500.hw04.FreecellModelCreator;
import cs3500.hw04.FreecellModelCreator.GameType;
import cs3500.hw04.FreecellModelMulti;
import org.junit.Test;


/**
 * To test the methods in the FreecellModelCreator class.
 */
public class FreecellModelCreatorTest {
  FreecellModelCreator c1 = new FreecellModelCreator();

  @Test
  public void freecellModelCreatorSingle() {
    assertTrue(FreecellModel.class.isInstance(c1.create(FreecellModelCreator.GameType.SINGLEMOVE)));
  }

  @Test
  public void freecellModelCreatorMulti() {
    assertTrue(FreecellModelMulti.class.isInstance(c1.create(GameType.MULTIMOVE)));
  }
}
