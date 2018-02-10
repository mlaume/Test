package cs3500.hw03;

import cs3500.hw02.FreecellOperations;
import java.util.List;

/**
 * The methods needed in a FreecellController.
 */
public interface IFreecellController<K> {
  /**
   * Deal a new game of Freecell with the given deck, with or without shuffling
   * it first. This method first verifies that the deck is valid.
   *
   * <p>It deals the deck among the cascade piles in round-robin fashion. Thus if
   * there are 4 cascade piles, the 1st pile will get cards 0, 4, 8, ..., the
   * 2nd pile will get cards 1, 5, 9, ..., the 3rd pile will get cards 2, 6, 10,
   * ... and the 4th pile will get cards 3, 7, 11, ....</p>
   *
   * <p>Depending on the number of cascade piles, they may have a different number
   * of cards</p>
   *
   * @param deck a list of cards in the deck
   * @param model    the game model
   * @param numCascades the number of cascade piles
   * @param numOpens    the number of open piles
   * @param shuffle     if true, shuffle the deck else deal the deck as-is
   * @throws IllegalArgumentException if the deck is null
   * @throws  IllegalStateException if the Readable or Appendable are null
   */
  void playGame(List deck, FreecellOperations model, int numCascades,
      int numOpens, boolean shuffle);
}
