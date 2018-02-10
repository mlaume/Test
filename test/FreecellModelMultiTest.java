import static junit.framework.TestCase.assertEquals;

import cs3500.hw02.Card;
import cs3500.hw02.PileType;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import cs3500.hw04.FreecellModelMulti;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Test the FreecellMOdelMultiTests.
 */
public class FreecellModelMultiTest extends FreecellModelTest {

  FreecellModelMulti m1 = new FreecellModelMulti();

  Card d0 = new Card(Value.Ace, Suit.Diamond);
  Card d1 = new Card(Value.Two, Suit.Diamond);
  Card d2 = new Card(Value.Three, Suit.Diamond);
  Card d3 = new Card(Value.Four, Suit.Diamond);
  Card d4 = new Card(Value.Five, Suit.Diamond);
  Card d5 = new Card(Value.Six, Suit.Diamond);
  Card d6 = new Card(Value.Seven, Suit.Diamond);
  Card d7 = new Card(Value.Eight, Suit.Diamond);
  Card d8 = new Card(Value.Nine, Suit.Diamond);
  Card d9 = new Card(Value.Ten, Suit.Diamond);
  Card d10 = new Card(Value.Jack, Suit.Diamond);
  Card d11 = new Card(Value.Queen, Suit.Diamond);
  Card d12 = new Card(Value.King, Suit.Diamond);
  Card h0 = new Card(Value.Ace, Suit.Heart);
  Card h1 = new Card(Value.Two, Suit.Heart);
  Card h2 = new Card(Value.Three, Suit.Heart);
  Card h3 = new Card(Value.Four, Suit.Heart);
  Card h4 = new Card(Value.Five, Suit.Heart);
  Card h5 = new Card(Value.Six, Suit.Heart);
  Card h6 = new Card(Value.Seven, Suit.Heart);
  Card h7 = new Card(Value.Eight, Suit.Heart);
  Card h8 = new Card(Value.Nine, Suit.Heart);
  Card h9 = new Card(Value.Ten, Suit.Heart);
  Card h10 = new Card(Value.Jack, Suit.Heart);
  Card h11 = new Card(Value.Queen, Suit.Heart);
  Card h12 = new Card(Value.King, Suit.Heart);
  Card s0 = new Card(Value.Ace, Suit.Spade);
  Card s1 = new Card(Value.Two, Suit.Spade);
  Card s2 = new Card(Value.Three, Suit.Spade);
  Card s3 = new Card(Value.Four, Suit.Spade);
  Card s4 = new Card(Value.Five, Suit.Spade);
  Card s5 = new Card(Value.Six, Suit.Spade);
  Card s6 = new Card(Value.Seven, Suit.Spade);
  Card s7 = new Card(Value.Eight, Suit.Spade);
  Card s8 = new Card(Value.Nine, Suit.Spade);
  Card s9 = new Card(Value.Ten, Suit.Spade);
  Card s10 = new Card(Value.Jack, Suit.Spade);
  Card s11 = new Card(Value.Queen, Suit.Spade);
  Card s12 = new Card(Value.King, Suit.Spade);
  Card c0 = new Card(Value.Ace, Suit.Club);
  Card c1 = new Card(Value.Two, Suit.Club);
  Card c2 = new Card(Value.Three, Suit.Club);
  Card c3 = new Card(Value.Four, Suit.Club);
  Card c4 = new Card(Value.Five, Suit.Club);
  Card c5 = new Card(Value.Six, Suit.Club);
  Card c6 = new Card(Value.Seven, Suit.Club);
  Card c7 = new Card(Value.Eight, Suit.Club);
  Card c8 = new Card(Value.Nine, Suit.Club);
  Card c9 = new Card(Value.Ten, Suit.Club);
  Card c10 = new Card(Value.Jack, Suit.Club);
  Card c11 = new Card(Value.Queen, Suit.Club);
  Card c12 = new Card(Value.King, Suit.Club);

  // an array of cards
  List<Card> casc1 = new ArrayList<>(
      Arrays.asList(h4, s3, h2, s1, h0));
  List<Card> casc2 = new ArrayList<>(
      Arrays.asList(h12, s11, h10, s9, h8, s7));
  List<Card> casc3 = new ArrayList<>(
      Arrays.asList(h6, s5));
  List<Card> casc4 = new ArrayList<>(
      Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12,
          h1, h3, h5, h7, h9, h11,
          s0, s2, s4, s6, s8, s10, s12,
          c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
  List<Card> open1 = new ArrayList<>(
      Arrays.asList(d0));
  List<Card> open2 = new ArrayList<>(
      Arrays.asList(d1));
  List<Card> open3 = new ArrayList<>(
      Arrays.asList(d2));
  List<Card> empty = new ArrayList<>();
  List<List<Card>> cascadePile = new ArrayList<>(Arrays.asList(casc1, casc2, casc3, casc4));
  List<List<Card>> openPile = new ArrayList<>(Arrays.asList(open1, open2, open3, empty));
  List<List<Card>> foundationPile = new ArrayList<>(Arrays.asList(empty, empty, empty, empty));


  FreecellModelMulti m2 = new FreecellModelMulti(this.m1.getDeck(), openPile, cascadePile,
      foundationPile, true);

  //test moving a build to another build
  void initbuildToBuild() {
    this.m2.move(PileType.CASCADE, 2, 0, PileType.CASCADE, 1);
  }

  //testing when not enough open piles and cascade piles --> throw exception
  void initNotEnoughEmptyPiles() {
    this.m2.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 2);
  }

  //testing when there are no open piles -->exception
  void initNoOpen() {
    this.m2.move(PileType.CASCADE, 0, 0, PileType.OPEN, 2);
  }

  //testing when move build to wrong cascade --> exception
  void initbuildToWrongCascade() {
    this.m2.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 1);
  }

  //testing when moving one single card cascade to cascade
  void initCascadetoFoundation() {
    this.m2.move(PileType.CASCADE, 0, 4, PileType.FOUNDATION, 0);
  }

  //testing moving a build to foundation --> exception
  void initBuildToFoundation() {
    this.m2.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 1);
  }

  //testing moving a build to open --> exception
  void initBuildToOpen() {
    this.m2.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);
  }

  @Test
  public void buildToBuild() {
    this.initbuildToBuild();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: A♦\n"
        + "O2: 2♦\n"
        + "O3: 3♦\n"
        + "O4:\n"
        + "C1: 5♥, 4♠, 3♥, 2♠, A♥\n"
        + "C2: K♥, Q♠, J♥, 10♠, 9♥, 8♠, 7♥, 6♠\n"
        + "C3:\n"
        + "C4: 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦, 2♥, 4♥, 6♥, 8♥, 10♥, Q♥, A♠, "
        + "3♠, 5♠, 7♠, 9♠, J♠, K♠, A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n",
        this.m2.getGameState());
  }


  @Test(expected = IllegalArgumentException.class) public void notEnoughEmpty() {
    this.initNotEnoughEmptyPiles();
  }

  @Test(expected = IllegalArgumentException.class) public void noOpen() {
    this.initNoOpen();
  }

  @Test(expected = IllegalArgumentException.class) public void buildToWrongCascade() {
    this.initbuildToWrongCascade();
  }

  @Test(expected = IllegalArgumentException.class) public void buildToFoundation() {
    this.initBuildToFoundation();
  }

  @Test(expected = IllegalArgumentException.class) public void buildToOpen() {
    this.initBuildToOpen();
  }

}
