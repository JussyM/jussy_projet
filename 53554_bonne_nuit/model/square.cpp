//
// Created by just on 18-09-21.
//

#include "square.h"

void square::add_pawn (Pawn &pawn)
{
  this->square_pawn = pawn;

}
[[maybe_unused]] square::square (Pawn square_pawn) : square_pawn (square_pawn)
{}
Pawn &square::get_square_pawn ()
{
  return square_pawn;
}
Pawn square::get_square_pawn () const
{
  return square_pawn;
}
bool square::square_is_empty ()
{
  return !this->square_pawn.is_exist ();
}
bool square::equal_colors (Color color)
{
  return this->square_color == color;
}
square::square (Pawn square_pawn, Color square_color) : square_pawn (square_pawn), square_color (square_color)
{}
square::square (Color square_color) : square_color (square_color)
{}
Color square::get_square_color () const
{
  return square_color;
}
void square::remove_pawn ()
{
  this->square_pawn = Pawn ();
}


