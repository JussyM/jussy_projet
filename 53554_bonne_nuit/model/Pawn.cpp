//
// Created by justu on 18-09-21.
//

#include "Pawn.h"

bool Pawn::is_star_on () const
{
  return star_on;
}

Pawn::Pawn (Color pawn_color, bool star_on) : pawn_color (pawn_color), star_on (star_on)
{ this->pawn_exist = true; }

Color Pawn::get_pawn_color () const
{
  return pawn_color;
}
bool Pawn::operator== (const Pawn &rhs) const
{
  return pawn_color == rhs.pawn_color &&
         star_on == rhs.star_on;
}
bool Pawn::operator!= (const Pawn &rhs) const
{
  return !(rhs == *this);
}
bool Pawn::is_exist () const
{
  return pawn_exist;
}
Color &Pawn::get_pawn_color ()
{
  return pawn_color;
}
void Pawn::set_not_used (bool not_used)
{
  this->not_used_ = not_used;
}
bool Pawn::is_not_used () const
{
  return not_used_;
}
void Pawn::set_star_on (bool star)
{
  this->star_on = star;
}
void Pawn::set_pawn_exist (bool exist)
{
  Pawn::pawn_exist = exist;
}

