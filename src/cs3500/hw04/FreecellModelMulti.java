package cs3500.hw04;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;
import java.util.List;

/**
 * The FreecellModelMulti can move multiple card at once if the build is in alternating colors,
 * decreasing value of one, and that there are enough empty cascade/open piles.
 */
public class FreecellModelMulti extends FreecellModel {

  public FreecellModelMulti() {
    super();
  }

  /**
   * Constructs a FreecellModel with the deck, open, cascade, and foundation.
   *
   * @param deck a deck of 52, no duplicate, valid card deck
   * @param open a list of open piles
   * @param cascade a list of cascade piles
   * @param foundation a list of foundation piles
   * @param isGameStarted checks if the game is started or not
   */
  public FreecellModelMulti(List<Card> deck,
      List<List<Card>> open,
      List<List<Card>> cascade,
      List<List<Card>> foundation,
      boolean isGameStarted) {
    this.deck = deck;
    this.open = open;
    this.cascade = cascade;
    this.foundation = foundation;
    this.isGameStarted = isGameStarted;
  }

  /**
   * Checks if all the card under the specified index if they are alternating colors
   * and descending value.
   *
   * @return boolean if the cards are all able t move under the card index
   */
  private boolean isSublist(int pileNumber, int cardIndex) {
    List<Card> subList = this.cascade.get(pileNumber).subList(cardIndex,
        this.cascade.get(pileNumber).size());
    boolean boolSubList = true;
    for (int i = 0; i < subList.size(); i++) {
      if (i != subList.size() - 1) {
        if (!subList.get(i).isNotSameColor(subList.get(i + 1))
            || (!subList.get(i).isOneLess(subList.get(i + 1)))) {
          boolSubList = false;
        }
      }
    }
    return boolSubList;
  }

  /**
   * Number of empty open piles.
   *@return a number of empty open piles
   */
  private int numEmptyOpen() {
    int numEmptyOpen = 0;
    for (int i = 0; i < this.open.size(); i++) {
      if ( this.open.get(i).size() == 0) {
        numEmptyOpen += 1;
      }
    }
    return numEmptyOpen;
  }

  /**
   * Number of empty cascade pile.
   *@return a number of cascade piles
   */
  private int numEmptyCascade() {
    int numEmptyCasc = 0;
    for (int i = 0; i < this.cascade.size(); i++) {
      if ( this.cascade.get(i).size() == 0) {
        numEmptyCasc += 1;
      }
    }
    return numEmptyCasc;
  }

  /**
   * Following the formula for (N+1)*2^K for how many cards are allowed to move.
   *@return the number of how many cards are allowed to be moved at once.
   */
  private double amountToMove() {
    return (this.numEmptyOpen() + 1) * Math.pow(2, this.numEmptyCascade());
  }

  /**
   * Number of empty cascade pile.
   * @param pileNumber the number of the pile in the type of pile you are moving
   * @param cardIndex the index of the card in the specified pile number
   *@return if ou can move the build or not
   */
  private boolean canMoveSublist(int pileNumber, int cardIndex) {
    if (!this.isSublist(pileNumber, cardIndex)) {
      throw new IllegalArgumentException("Cannot move card as sublist");
    }
    if (this.amountToMove() < this.getSublist(pileNumber, cardIndex).size()) {
      throw new IllegalArgumentException("Not enough cascade or open pile");
    }
    else {
      return true;
    }
  }

  /**
   * Returns all the card under the specified index if they are alternating colors,
   * descending value, the open pile has spaces.
   *
   * @return a list of cards built under the specific card index
   */
  public List getSublist(int pileNumber, int cardIndex) {
    return this.cascade.get(pileNumber).subList(cardIndex, this.cascade.get(pileNumber).size());
  }

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
      int destPileNumber) {
    if (!this.isGameStarted) {
      throw new IllegalArgumentException("game did not start ");
    }
    if (this.deck == null) {
      throw new IllegalArgumentException("no null decks please");
    }
    if (!this.isValid()) {
      throw new IllegalArgumentException("passed in invalid deck");
    }
    if (PileType.FOUNDATION.equals(source)) {
      throw new IllegalArgumentException("Can not move from foundation pile");
    }
    else {
      if (PileType.CASCADE.equals(source) && PileType.CASCADE.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        if (this.canMoveSublist(pileNumber, cardIndex)) {
          List<Card> sublist = this.getSublist(pileNumber, cardIndex);
          this.cascade.get(destPileNumber).addAll(sublist);
          this.cascade.get(pileNumber).removeAll(sublist);
        }
        else {
          this.cascadeToCascade(source, pileNumber, cardIndex,
              destination, destPileNumber, moveThis);
        }
      } else if (PileType.CASCADE.equals(source) && PileType.FOUNDATION.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        this.cascadeToFoundation(source, pileNumber, cardIndex,
            destination, destPileNumber, moveThis);
      } else if (PileType.CASCADE.equals(source) && PileType.OPEN.equals(destination)) {
        Card moveThis = this.cascade.get(pileNumber).get(cardIndex);
        this.cascadeToOpen(source, pileNumber, cardIndex,
            destination, destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.CASCADE.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToCascade(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.OPEN.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToOpen(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else if (PileType.OPEN.equals(source) && PileType.FOUNDATION.equals(destination)) {
        Card moveThis = this.open.get(pileNumber).get(cardIndex);
        this.openToFoundation(source, pileNumber, cardIndex, destination,
            destPileNumber, moveThis);
      } else {
        throw new IllegalArgumentException("Can not move there!!!");
      }
    }
  }
}
