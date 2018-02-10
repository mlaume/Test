import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * To test the methods in the FreecellModel.
 */
public class  FreecellModelTest {

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
  List<Card> cardList = new ArrayList<>(
      Arrays.asList(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12,
          h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12,
          s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12,
          c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));

  // Duplicates and not 52 cards in the deck
  List<Card> badDeck = new ArrayList<>(
      Arrays.asList(d0, d0, d0, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12,
          h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12,
          s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12,
          c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));

  //Diamond test
  List<Card> diamondList = new ArrayList<>(
      Arrays.asList(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12));

  // an array of cards
  List<Card> heartList = new ArrayList<>(
      Arrays.asList(h0, h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12));

  // an array of cards
  List<Card> spadeList = new ArrayList<>(
      Arrays.asList(s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12));

  // an array of cards
  List<Card> clubList = new ArrayList<>(
      Arrays.asList(c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
  // an array of cards

  List<List<Card>> foundationOver = new ArrayList<>(
      Arrays.asList(diamondList, heartList, spadeList, clubList));

  List<Card> empty = new ArrayList<>();

  List<List<Card>> openPile = new ArrayList<>(
      Arrays.asList(empty, empty, empty, empty));

  List<List<Card>> cascadePile = new ArrayList<>(
      Arrays.asList(empty, empty, empty, empty));

  FreecellModel f1 = new FreecellModel();

  void initGame1() {
    this.f1.startGame(this.f1.getDeck(), 4, 4, false);
  }

  //shuffled deck
  void initGame2() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, true);
  }

  //dealt into 52 cascade piles
  void initGame3() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, false);
  }

  //moved Ace of diamond from cascade to foundation
  void initGame4() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, false);
    this.f1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 1);
  }

  //moved Ace of diamond from cascade to open
  void initGame5() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, false);
    this.f1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);
  }

  //moved Two of diamond from cascade to open
  void initGame6() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, false);
    this.f1.move(PileType.CASCADE, 1, 0, PileType.OPEN, 1);
  }

  //BadDeck
  void initBadDeck() {
    this.f1.startGame(badDeck, 52, 4, false);
  }

  //BadDeck
  void initSpecific() {
    this.f1.startGame(this.f1.getDeck(), 4, 2,
        false);
  }

  void initGameOver() {
    this.f1.startGame(this.f1.getDeck(), 52, 4, false);
    this.f1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION, 0);
    this.f1.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION, 1);
    this.f1.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 27, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 28, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 29, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 30, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 31, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 32, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 33, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 34, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 35, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 36, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 37, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 38, 0, PileType.FOUNDATION, 2);
    this.f1.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 40, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 41, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 42, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 43, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 44, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 45, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 46, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 47, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 48, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 49, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 50, 0, PileType.FOUNDATION, 3);
    this.f1.move(PileType.CASCADE, 51, 0, PileType.FOUNDATION, 3);


  }

  //test all 52 cards, no repeats
  @Test
  public void generateDeck() {
    this.initGame3();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //when not all the foundation piles are filled
  @Test
  public void notGameOver() {
    this.initGame1();
    assertEquals(false, this.f1.isGameOver());
  }

  //Creates the open, foundation, and deals to the cascade
  @Test
  public void startGame() {
    this.initGame1();
    assertEquals( "F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 2♣, 6♣, 10♣\n"
        + "C2: 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠, 3♣, 7♣, J♣\n"
        + "C3: 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠, 4♣, 8♣, Q♣\n"
        + "C4: 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠, A♣, 5♣, 9♣, K♣", this.f1.getGameState());
  }

  //When the deck has duplicates
  @Test(expected = IllegalArgumentException.class) public void throwBadDeck() {
    this.f1.startGame(badDeck, 4, 4, false);
  }

  //when not all the foundation piles are filled(
  @Test
  public void shuffleCard() {
    this.initGame2();
    assertNotEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //cascade to cascade
  @Test
  public void cascadeToCascade() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 5, 0, PileType.CASCADE, 32);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6:\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠, 6♦\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //error cannot move 1. same color 2.wrong value
  @Test(expected = IllegalArgumentException.class) public void sameColorCascade() {
    initGame3();
    this.f1.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 1);
  }

  //Cannot move 2. value not right
  @Test(expected = IllegalArgumentException.class) public void wrongValueCascade() {
    initGame3();
    this.f1.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 26);
  }

  @Test
  public void cascadeToOpen() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 5, 0, PileType.OPEN, 0);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1: 6♦\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6:\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());


  }

  //Error the open already has a card
  @Test(expected = IllegalArgumentException.class)
  public void onlyOneInOpen() {
    initGame3();
    this.f1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);
    this.f1.move(PileType.CASCADE, 1, 0, PileType.OPEN, 1);
  }

  //cascade to foundation for ace
  @Test
  public void cascadeToFoundationAce() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 1);
    assertEquals("F1:\n"
        + "F2: A♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  // error the foundation is not an ace
  @Test(expected = IllegalArgumentException.class) public void foundationNotAce() {
    initGame3();
    this.f1.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION, 1);
  }

  // error the foundation value is not the same suit
  @Test(expected = IllegalArgumentException.class) public void foundationNotSameSuit() {
    initGame4();
    this.f1.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION, 1);
  }

  // error the value is not one more
  @Test(expected = IllegalArgumentException.class) public void foundationOneMore() {
    initGame4();
    this.f1.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION, 1);
  }

  //adding a second thing to foundation
  @Test
  public void cascadeToFoundation2Moves() {
    this.initGame4();
    this.f1.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION, 1);
    assertEquals("F1:\n"
        + "F2: A♦, 2♦\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2:\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //open to cascade
  @Test
  public void openToCascade() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 5, 0, PileType.OPEN, 0);
    this.f1.move(PileType.OPEN, 0, 0, PileType.CASCADE, 32);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6:\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠, 6♦\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //error cascade does not accept move
  @Test(expected = IllegalArgumentException.class) public void wrongMoveOC() {
    initGame5();
    this.f1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 6);
  }

  @Test
  public void openToOpen() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 5, 0, PileType.OPEN, 0);
    this.f1.move(PileType.OPEN, 0, 0, PileType.OPEN, 1);
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2: 6♦\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6:\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //error open does not accept move
  @Test(expected = IllegalArgumentException.class) public void wrongMoveOO() {
    initGame5();
    this.f1.move(PileType.OPEN, 1, 0, PileType.CASCADE, 1);
  }

  @Test
  public void openToFoundation() {
    this.initGame3();
    this.f1.move(PileType.CASCADE, 0, 0, PileType.OPEN, 1);
    this.f1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 0);
    assertEquals("F1: A♦\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1:\n"
        + "C2: 2♦\n"
        + "C3: 3♦\n"
        + "C4: 4♦\n"
        + "C5: 5♦\n"
        + "C6: 6♦\n"
        + "C7: 7♦\n"
        + "C8: 8♦\n"
        + "C9: 9♦\n"
        + "C10: 10♦\n"
        + "C11: J♦\n"
        + "C12: Q♦\n"
        + "C13: K♦\n"
        + "C14: A♥\n"
        + "C15: 2♥\n"
        + "C16: 3♥\n"
        + "C17: 4♥\n"
        + "C18: 5♥\n"
        + "C19: 6♥\n"
        + "C20: 7♥\n"
        + "C21: 8♥\n"
        + "C22: 9♥\n"
        + "C23: 10♥\n"
        + "C24: J♥\n"
        + "C25: Q♥\n"
        + "C26: K♥\n"
        + "C27: A♠\n"
        + "C28: 2♠\n"
        + "C29: 3♠\n"
        + "C30: 4♠\n"
        + "C31: 5♠\n"
        + "C32: 6♠\n"
        + "C33: 7♠\n"
        + "C34: 8♠\n"
        + "C35: 9♠\n"
        + "C36: 10♠\n"
        + "C37: J♠\n"
        + "C38: Q♠\n"
        + "C39: K♠\n"
        + "C40: A♣\n"
        + "C41: 2♣\n"
        + "C42: 3♣\n"
        + "C43: 4♣\n"
        + "C44: 5♣\n"
        + "C45: 6♣\n"
        + "C46: 7♣\n"
        + "C47: 8♣\n"
        + "C48: 9♣\n"
        + "C49: 10♣\n"
        + "C50: J♣\n"
        + "C51: Q♣\n"
        + "C52: K♣", this.f1.getGameState());
  }

  //wrong move open to foundation
  @Test(expected = IllegalArgumentException.class) public void wrongMoveOF() {
    initGame6();
    this.f1.move(PileType.OPEN, 1, 0, PileType.FOUNDATION, 1);
  }

  //get the gameState when game started
  @Test
  public void gameState() {
    this.initGame1();
    assertEquals("F1:\n"
        + "F2:\n"
        + "F3:\n"
        + "F4:\n"
        + "O1:\n"
        + "O2:\n"
        + "O3:\n"
        + "O4:\n"
        + "C1: A♦, 5♦, 9♦, K♦, 4♥, 8♥, Q♥, 3♠, 7♠, J♠, 2♣, 6♣, 10♣\n"
        + "C2: 2♦, 6♦, 10♦, A♥, 5♥, 9♥, K♥, 4♠, 8♠, Q♠, 3♣, 7♣, J♣\n"
        + "C3: 3♦, 7♦, J♦, 2♥, 6♥, 10♥, A♠, 5♠, 9♠, K♠, 4♣, 8♣, Q♣\n"
        + "C4: 4♦, 8♦, Q♦, 3♥, 7♥, J♥, 2♠, 6♠, 10♠, A♣, 5♣, 9♣, K♣", this.f1.getGameState());
  }


  //the game state when the game did not start
  @Test
  public void noGameState() {
    assertEquals("", this.f1.getGameState());
  }

  //the game state when the game did not start
  @Test
  public void gameOver() {
    this.initGameOver();
    assertEquals(true, this.f1.isGameOver());
  }

}