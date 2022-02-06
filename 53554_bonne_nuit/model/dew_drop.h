//
// Created by jj on 23.09.21.
//

#ifndef _DEW_DROP_H_
#define _DEW_DROP_H_

#include "position.h"
class dew_drop {
  position dew_position;
 public:
  /**
   * the dew_drop constructor
   * @param dew_position
   */
  explicit dew_drop (position dew_position = position ());
  /**
   * return the dew_drop position ( getter)
   * @return position ref Object from class Position
   */
  [[nodiscard]] position &get_dew_position ();
  /**
   * setter for dew_position
   * @param position Object from class Position given by ref
   */
  void set_dew_position (position &position);
  /**
   * return true if the position are equals
   * @return bool true if the position given by arg is equal to the dew_position
   */
  [[maybe_unused]] bool equal_position (position);

};

#endif //_DEW_DROP_H_
