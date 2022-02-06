//
// Created by just on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_GAME_H
#define INC_53554_BONNE_NUIT_GAME_H

#include "../d_pattern/Observable.hpp"
#include "vector"
#include "algorithm"
#include "Pawn.h"
#include "random.hpp"
#include "Player.h"
#include "Board.h"
#include "dew_drop.h"
#include "QtDebug"

class Game : public observable {
  std::vector<observer *> observers;
  std::vector<Player> players;
  Board game_board;
  dew_drop drop;
  int update_id;
  int de_value;
 public:
  /**
   * @brief getter for the observer
   * id which defined what element is
   * change in the game and what need
   * an update in the observer
   * @return and id
   */
  [[nodiscard]] int get_update_id () const;
  ~Game () = default;
 private:
  Player current_player;
 private:

  /**
   *@brief Return the Pawn that has the same color with the color given in arg
   * @return Pawn
   */
  static Pawn next_pawn (Color, const std::vector<Pawn> &);

  /**
   *@brief call the creat_board function using game_board attribute
   * to creat the board
   */
  void create_board (std::vector<Pawn> &);

  /**
   * @brief return true if all the row given in arg are free
   * @return bool true if the rows are free
   */
  bool rows_are_free (square *rows);
  /**
   *@brief pawns created by the game
   * @return std::vector<Pawn>
   */
  static std::vector<Pawn> get_pawns ();
 public:
  /**
   * @brief return the value of the dice generated
   * @return an integer
   */
  int get_de_value () const;
  /**
   * generate the dice value
   */
  void generate_de ();
/**
 * @brief default constructor
 */
  Game () = default;

/**
 *@brief register the observer ( view )
 * @param observer ( View)
 */
  void register_observer (observer *observer) override;
  /**
   *@brief getter for the players of the game
   * @return a vector of players
   */
  std::vector<Player> &get_players ();
  /**
   * @brief getter of board
   * @return A board object
   */
  [[nodiscard]] Board get_game_board () const;
  /**
   *@brief getter of the dew_drop
   * @return dew_drop
   */
  [[nodiscard]] dew_drop get_drop () const;
  /**
   * @brief getter for the current player
   * @return Player
   */
  [[nodiscard]] Player get_current_player () const;

/**
 *@brief notify the observer if an update occur
 * @param observable ( game)
 */
  void notify_observers (observable *) override;
  /**
   *@brief creat the different object related to the game like the players and the board
   * according to the number of players given as arg
   * @param nb_player
   */
  void create_game (int);

  /**
   *@brief assign the current_player
   *
   */
  void assign_player ();

  /**
   *@brief update the current_player attribute by changing his state to the next player
   */
  void next_player ();

  /**
   * @brief assign a new position
   * to the dew_drop so that
   * we can know where the
   * player will put his Pawn
   */
  void move_drop ();

  /**
   *@brief since we know where the player can put the his Pawn
   * we move a Pawn of the current_player to the board
   * @param Position dew_drop_position
   */
  void place_pawn_at (position &);

  /**
   *@param return true if the all the pawns
   * of all the players are on the board
   * so that we can off the light
   * @return bool true if all the player pawns are on the board
   */
  bool players_pawns_on_board ();
  /**
   *@brief change all the pawns to hidden
   */
  void turn_off_light ();
  /**
   * @brief a game is over only if only one pawn remain on the board
   * @return bool true /false if game is over or not
   */
  bool is_over ();
  /**
   * @brief remove a pawn from the board
   * @param position Position where the pawn will be remove
   */
  void move_from_board_at (position &position);

};

#endif //INC_53554_BONNE_NUIT_GAME_H
