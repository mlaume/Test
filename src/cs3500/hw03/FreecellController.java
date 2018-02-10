package cs3500.hw03;

import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Takes in user input and does the speciffied actions given from the rules in the Model.
 */
public class FreecellController implements IFreecellController {

  Readable rd;
  Appendable ap;

  /**
   * Constructs a {@FreecellController} object.
   *
   * @param rd the readable object of what the user enters
   * @param ap the appendable object of what the output is
   */

  public FreecellController(Readable rd, Appendable ap) {
    if ( rd == null || ap == null) {
      throw new IllegalStateException("Appendable and Readable cannot be null");
    }
    else {
      this.rd = rd;
      this.ap = ap;
    }
  }

  /**
   * Checks if the format is the valid CardPile format ( C, F, O and a number).
   *
   * @returns true, if it is a valid card pile
   */
  private boolean validCardPile(String input) {
    if (input.length() > 1) {
      if (input.charAt(0) == ('C') || input.charAt(0) == ('F') || input.charAt(0) == ('O')) {
        try {
          Integer.parseInt(input.substring(1));
        } catch (Exception e) {
          return false;
        }
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the format is the valid Card Index format ( a number).
   *
   * @returns true, if it is a valid card pile
   */
  private boolean validCardIndex(String input) {
    try {
      Integer.parseInt(input);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  /**
   * Converts the string to a Piletype.
   *
   * @returns pileType
   */
  private PileType inputToPile(String input) {
    char pileRep = input.charAt(0);
    switch (pileRep) {
      case 'C':
        return PileType.CASCADE;
      case 'O':
        return PileType.OPEN;
      case 'F':
        return PileType.FOUNDATION;
      default:
        throw new IllegalArgumentException("This is not a pile type");
    }
  }

  /**
   * Converts the string to a Number.
   *
   * @returns integer equivalent of the string
   */
  private int inputToNumber(String input) {
    String convertThis = input.substring(1);
    return Integer.parseInt(convertThis);
  }

  /**
   * Checks is the string is a q to know when to quit.
   *
   * @returns true, if it is a q or Q
   */
  private boolean isQuit(String input) {
    switch (input) {
      case "q":
        return true;
      case "Q":
        return true;
      default:
        return false;
    }
  }

  @Override
  public void playGame(List deck, FreecellOperations model, int numCascades, int numOpens,
      boolean shuffle) {
    if ( model == null) {
      throw new IllegalArgumentException("No null model");
    }
    if ( deck == null) {
      throw new IllegalArgumentException("No null model");
    }
    Scanner scan = new Scanner(this.rd);
    String source = "";
    String cardIndex = "";
    String destination = "";
    try {
      model.startGame(deck, numCascades, numOpens, shuffle);
    }
    catch (IllegalArgumentException i) {
      try {
        this.ap.append("Could not start game bad inputs.");
      }
      catch (IOException e2) {
        //do nothing
      }
    }
    catch (Exception e) {
      try {
        this.ap.append("Could not start game");
      } catch (IOException e1) {
        //do nothing
      }
      return;
    }
    while (!model.isGameOver()) {
      try {
        this.ap.append(model.getGameState());
        this.ap.append( '\n' + "Enter your move" + '\n');
        if (scan.hasNext()) {
          source = scan.next();
          if (this.isQuit(source)) {
            this.ap.append('\n' + "Game quit prematurely.");
            return;
          } else {
            while (!this.validCardPile(source)) {
              this.ap.append('\n' + "Wrong pile. Enter pile again");
              if (scan.hasNext()) {
                source = scan.next();
                if (this.isQuit(source)) {
                  this.ap.append('\n' + "Game quit prematurely.");
                  return;
                }
              }
            }
          }
          if (scan.hasNext()) {
            cardIndex = scan.next();
            if (this.isQuit(cardIndex)) {
              this.ap.append('\n' + "Game quit prematurely.");
              return;
            } else {
              while (!this.validCardIndex(cardIndex)) {
                this.ap.append("Wrong cardIndex. Enter index again");
                if (scan.hasNext()) { //re-entered value will be a valid value now
                  cardIndex = scan.next();
                  if (this.isQuit(source)) {
                    this.ap.append('\n' + "Game quit prematurely.");
                    return;
                  }
                }
              }
            }
            if (scan.hasNext()) {
              destination = scan.next();
              if (this.isQuit(destination)) {
                this.ap.append('\n' + "Game quit prematurely.");
                return;
              } else {
                while (!this.validCardPile(destination)) {
                  this.ap.append('\n' + "Wrong pile. Enter pile again");
                  if (scan.hasNext()) {
                    destination = scan.next();
                    if (this.isQuit(source)) {
                      this.ap.append('\n' + "Game quit prematurely.");
                      return;
                    }
                  }
                }
              }
            }
            else if ( scan == null  || this.ap == null) {
              throw new IllegalStateException("Empty Readable and Appendable");
            }

          }
          try {
            model.move(this.inputToPile(source), this.inputToNumber(source) - 1,
                Integer.parseInt(cardIndex) - 1, this.inputToPile(destination),
                this.inputToNumber(destination) - 1);
          } catch (Exception e) {
            String msg = "Invalid move. Try again. ";
            this.ap.append(msg.concat(e.getMessage()));
          }
        }
      } catch (Exception except) {
        //do nothing
      }
    }
    try {
      this.ap.append("Game over.");
    } catch (Exception e) {
      //do nothing
    }
  }
}

