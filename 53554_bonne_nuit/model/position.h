//
// Created by justu on 18-09-21.
//

#ifndef INC_53554_BONNE_NUIT_POSITION_H
#define INC_53554_BONNE_NUIT_POSITION_H

#include <ostream>
class position {
  int _x;
  int _y;
 public:
  /**
   *@brief position constructor with args
   * @param x int
   * @param y int
   */
  position (int x, int y);
  /**
   *@brief default constructor
   */
  position () = default;
/**
 *@brief getter for _x
 * @return x
 */
  [[nodiscard]] int get_x () const;
/**
 *@brief getter for _y
 * @return _y
 */
  [[nodiscard]] int get_y () const;
  /**
   *@brief equal operator
   * @param rhs another position
   * @return true/false
   */
  bool operator== (const position &rhs) const;
  /**
   *@brief not equal operator
   * @param rhs another position
   * @return true /false
   */
  bool operator!= (const position &rhs) const;
  /**
   *@brief output operator redefined mainly use for debug
   * @param os ostream class
   * @param position For print
   * @return an output
   */
  friend std::ostream &operator<< (std::ostream &os, const position &position);
  /**
   * default destructor
   */
  ~position () = default;

};

#endif //INC_53554_BONNE_NUIT_POSITION_H
