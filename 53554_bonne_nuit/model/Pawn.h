//
// Created by justu on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_PAWN_H
#define INC_53554_BONNE_NUIT_PAWN_H

#include "Color.h"
#include "position.h"

class Pawn {
  Color pawn_color;
  bool star_on;
  bool pawn_exist;
  bool not_used_;
 public:
  /**
   *@brief set the state of a pawn if it exist or not
   * by default the pawn do no exist
   * @param exist  a bool true/false
   */
  void set_pawn_exist (bool exist);

 public:
  /**
   *@brief getter for not_used
   * @return not_used
   */
  bool is_not_used () const;
  /**
   *@brief getter for pawn_exist attribute
   * @return pawn_exist
   */
  bool is_exist () const;
  /**
   * @brief constructor for Pawn
   * @param pawn_color a color object
   * @param star_on if the star is on by default yes it's
   */
  Pawn (Color pawn_color, bool star_on);
  /**
   *@brief setter for star
   * @param star_on bool
   */
  void set_star_on (bool star_on);
  /**
   * @brief setter for not used
   * @param not_used
   */
  void set_not_used (bool not_used);
  /**
   * @brief getter for pawn color
   * @return Color pawn_color
   */
  [[nodiscard]] Color get_pawn_color () const;
  /**
   * @brief getter ref for pawn color
   * @return ref of pawn_color
   */
  Color &get_pawn_color ();
  /**
   * Default constructor
   */
  Pawn () = default;
  /**
   * getter of star
   * @return star_on
   */
  [[nodiscard]] bool is_star_on () const;
 public:
  /**
   * @brief equal operator
   * @param rhs another pawn
   * @return true if equals and false if not
   */
  bool operator== (const Pawn &rhs) const;
  /**
   * @brief reverse of equals
   * @param rhs another pawn
   * @return true if not equals and false if equals
   */
  bool operator!= (const Pawn &rhs) const;

};

#endif //INC_53554_BONNE_NUIT_PAWN_H
