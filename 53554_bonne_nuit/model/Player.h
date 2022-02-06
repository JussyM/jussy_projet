//
// Created by jj on 20.09.21.
//

#ifndef _PLAYER_H_
#define _PLAYER_H_

#include "Pawn.h"
#include "vector"
#include "position.h"
class Player {
  std::vector<Pawn> player_pawn;
  Color player_color;
 public:
  /**
   *@brief constructor for Player
   * @param player_color Objecct color
   */
  explicit Player (Color player_color);
  /**
   *@brief copy constructor of Player
   * @param source Player source
   */
  Player(const Player& source);
  /**
   *@brief default constructor
   */
  Player () = default;
  /**
   *@brief add a Pawn to the pawns vector of the player
   * @param index where the pawn will be add
   */
  void fill_pawn (int index, Pawn);
  /**
   *@brief push a pawn to the list of pawn of the player
   */
  void push_back_pawn(Pawn &);
  /**
   *@brief return the last element of the vector
   * @param pawn a Pawn object
   */
  Pawn &get_last_pawn ();
  /**
   *@brief getter for color
   * @return Color object
   */
  [[nodiscard]] Color get_player_color () const;

  /**
   *@brief remove the last element of the vector
   */
  void remove_last_pawn ();
  /**
   *@brief equal operator
   * @param rhs another Player
   * @return true /false
   */
  bool operator== (const Player &rhs) const;
  /**
   *@brief not equal operator ( reverse of equals)
   * @param rhs another player
   * @return true/false
   */
  bool operator!= (const Player &rhs) const;
  /**
   *@brief getter for the std::vector<Pawn>
   * @return std::vector<Pawn> of pawns
   */
  [[nodiscard]] const std::vector<Pawn> &get_player_pawn () const;
  /**
   *@brief  return true if all the Pawn of the
   *@brief  player is on the board in other word
   *@brief  return true if the vector is empty
   * @return bool
   */
  bool all_pawn_on_board ();

};

#endif //_PLAYER_H_
