package cs3500.hw04;

import cs3500.hw02.FreecellModel;

/**
 * Depending on what Gametype is passed in, a different game and set of rules will be applied
 * to a regular FreecellGame or a FecellGameMulti which can move multuiple cards at once.
 */
public class FreecellModelCreator {

  public enum GameType {
    SINGLEMOVE, MULTIMOVE;
  }


  public FreecellModelCreator() {
    super();
  }

  /**
   * Decides if the game should go for a Freecell regular version or FreecellMulti version with
   * more sublist.
   *
   * @param type whether singlemove or multimove
   */
  public static FreecellModel create(GameType type) {
    if (type.equals(GameType.SINGLEMOVE)) {
      return new FreecellModel();
    } else {
      return new FreecellModelMulti();
    }
  }
}
