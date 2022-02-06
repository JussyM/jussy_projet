//
// Created by just on 18-09-21.
//

#include <memory>
#include <iostream>
#include <algorithm>
#include <QDebug>
#include "Board.h"

Pawn &Board::get_pawn_at (position position)
{
  return this->squares[position.get_x ()][position.get_y ()].get_square_pawn ();
}

void Board::create_board (std::vector<Pawn> &pawns_remains)
{

  int nb_pawns = pawns_remains.empty () ? 0 : static_cast<int>(pawns_remains.size ());
  std::vector<Color> color_not_used;
  std::vector<Color> colors_used;

  if (nb_pawns != 0)
    {
      color_not_used.reserve ((nb_pawns / 2) - 1);
      defined_colors_not_used (pawns_remains, color_not_used, nb_pawns);
      int index = Board::big_pawn - 1;
      defined_squares_with_remains_colors (pawns_remains, nb_pawns, index);
      colors_used.reserve (5);
      defined_colors_used (color_not_used, colors_used);
      defined_players_square (colors_used, index);

    }
  else
    {
      defined_default_square_state (colors_used);
    }

}

int Board::get_little_pawn ()
{
  return little_pawn;
}

int Board::get_big_pawn ()
{
  return big_pawn;
}

square &Board::get_square_at (position &p)
{
  return this->squares[p.get_x ()][p.get_y ()];
}

bool Board::is_inside (position position)
{
  return position.get_x () >= 0 && position.get_x () < big_pawn && position.get_y () >= 0
         && position.get_y () < little_pawn;
}

square *Board::get_rows_at (int index)
{
  return this->squares[index];
}
int Board::random_y ()
{
  he2b::nvs::randomize ();
  return he2b::nvs::random_value (0, 8);
}
bool Board::rows_are_free (square *rows)
{
  auto i = 0;
  while (i < Board::get_little_pawn () && rows[i].square_is_empty ())
    {
      ++i;
    }
  return i == Board::get_little_pawn ();
}
void Board::defined_colors_not_used (std::vector<Pawn> &pawns_remains,
                                     std::vector<Color> &color_not_used, int nb_pawns)
{
  for (int i = 0; i < nb_pawns; i = i + 3)
    {
      color_not_used.push_back (pawns_remains.at (i).get_pawn_color ());
    }
}

void Board::defined_colors_used (std::vector<Color> &color_not_used, std::vector<Color> &colors_used)
{
  Color array_colors[] = {BLUE, BLACK, GREEN, PURPLE, RED};
  for (auto &array_color: array_colors)
    {
      colors_used.push_back (array_color);
    }
  for (auto it = colors_used.begin (); !color_not_used.empty () && it != colors_used.end (); it++)
    {
      for (auto it_2 = color_not_used.begin (); it_2 != color_not_used.end ();)
        {
          if (*it == *it_2)
            {
              colors_used.erase (it);
              color_not_used.erase (it_2);
            }
          else
            {
              if (!color_not_used.empty ())
                it_2++;
            }

        }
    }
}
void Board::defined_squares_with_remains_colors (std::vector<Pawn> &pawns_remains,
                                                 int &nb_pawns, int &index_2)
{
  for (nb_pawns--; nb_pawns >= 0 && index_2 >= 0; --index_2)
    {
      auto y = random_y ();
      auto instance = pawns_remains.at (nb_pawns);
      squares[index_2][y] = square
          (instance, instance.get_pawn_color ());
      squares[index_2][y].get_square_pawn ().set_not_used (true);
      auto index = pawns_remains.begin ();
      auto stop = false;
      while (index != pawns_remains.end () && !stop)
        {
          if ((*index) == instance)
            {
              pawns_remains.erase (index);
              stop = true;
            }
          index++;
        }
      nb_pawns--;

    }
}
void Board::defined_players_square (std::vector<Color> &color_used, int index)
{
  auto index_2 = 0;
  auto color = color_used.at (index_2);
  for (int j = 0; j <= index; ++j)
    {
      if (j != 0 && j % 3 == 0)
        {
          index_2++;
          color = color_used.at (index_2);
        }
      for (int k = 0; k < Board::little_pawn; ++k)
        {
          squares[j][k] = square (color);
        }
    }

}
void Board::defined_default_square_state (std::vector<Color> &colors_used)
{
  colors_used.reserve (5);
  Color array_colors[] = {BLUE, BLACK, GREEN, PURPLE, RED};

  for (auto &array_color: array_colors)
    {
      colors_used.push_back (array_color);
    }
  auto index_2 = 0;
  auto color = colors_used.at (index_2);
  for (int i = 0; i < Board::big_pawn; ++i)
    {
      if (i != 0 && i % 3 == 0)
        {
          index_2++;
          color = colors_used.at (index_2);
        }
      for (int j = 0; j < Board::little_pawn; ++j)
        {
          squares[i][j] = square (color);
        }
    }
}




