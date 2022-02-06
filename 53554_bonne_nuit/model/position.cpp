//
// Created by justu on 18-09-21.
//

#include <memory>
#include "position.h"

position::position (int x, int y) : _x (x), _y (y)
{}

int position::get_x () const
{
  return _x;
}

int position::get_y () const
{
  return _y;
}
bool position::operator== (const position &rhs) const
{
  return _x == rhs._x &&
         _y == rhs._y;
}
bool position::operator!= (const position &rhs) const
{
  return !(rhs == *this);
}
std::ostream &operator<< (std::ostream &os, const position &position)
{
  os << "_x: " << position._x << " _y: " << position._y;
  return os;
}
