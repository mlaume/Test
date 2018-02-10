package cs3500.hw02;

/**
 * Represents the value of the card. Must be from 1 to 13. The string is A, 2 to 9, J, Q, K.
 */
public enum Value {
  Ace("A", 1),
  Two("2", 2),
  Three("3", 3),
  Four("4", 4),
  Five("5", 5),
  Six("6", 6),
  Seven("7", 7),
  Eight("8", 8),
  Nine("9", 9),
  Ten("10", 10),
  Jack("J", 11),
  Queen("Q", 12),
  King("K", 13);


  public final String rank;
  public final int value;

  /**
   * Constructs a {@Value} object.
   *
   * @param rank string equivalence of the card as show on cards
   * @param value numerical value of the card
   */

  Value(String rank, int value) {
    this.rank = rank;
    this.value = value;
  }

  /**
   * Returns the rank as a string.
   *
   * @return a string of the rank
   */
  public String toRank() {
    return this.rank;
  }


}
