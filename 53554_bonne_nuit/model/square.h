//
// Created by justu on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_SQUARE_H
#define INC_53554_BONNE_NUIT_SQUARE_H

#include "Pawn.h"

class square {
  Pawn square_pawn;
  Color square_color;

 public:
  /**
   * @brief constructor for square
   * @param square_pawn  the pawn related to the square object
   * @param square_color  the color of the square for simple verification
   */
  square (Pawn  square_pawn, Color square_color);
  /**
   * @brief remove pawn from the square
   */
  void remove_pawn();

  /**
   *@brief default constructor
   */
  square () = default;
  /**
   *@brief constructor with only square color ( no pawn )
   * @param square_color Color object
   */
  explicit square (Color square_color);
  /**
   *@brief constructor with a Pawn only
   * @param square_pawn pawn object
   */
  [[maybe_unused]] explicit square (Pawn square_pawn);

  /**
   *@brief add a Pawn to a square
   * @param pawn Pawn object
   */
  void add_pawn (Pawn& pawn);
  /**
   * @brief getter for square_color
   * @return  Color object
   */
  [[nodiscard]] Color get_square_color () const;

  /**
   *@brief a const getter for Pawn
   * @return Pawn object
   */
  [[nodiscard]] Pawn get_square_pawn () const;

  /**
   *@brief a non const getter
   * @return Pawn pawn ref object
   */
  Pawn &get_square_pawn ();

  /**
   *@brief default destructor
   */
  ~square () = default;

/**
 *@brief return true if the Pawn is empty
 * @return bool true /false
 */
  bool square_is_empty ();
/**
 *@brief defined if the color is equals to the square color
 * @param color Object
 * @return true if equals and false if not
 */
  bool equal_colors (Color color);

};

#endif //INC_53554_BONNE_NUIT_SQUARE_H
