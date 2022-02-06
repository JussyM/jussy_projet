//
// Created by justu on 18-09-21.
//

#include <memory>
#include "Game.h"

void Game::register_observer (observer *observer)
{ this->observers.push_back (observer); }

void Game::notify_observers (observable *observable)
{
  for (auto &observer: this->observers)
    {
      observer->update (observable);
    }
}

void Game::generate_de ()
{

  he2b::nvs::randomize ();
  de_value = he2b::nvs::random_value (1, 3);
}

int Game::get_de_value () const
{
  return de_value;
}

void Game::create_game (int nb_player)
{
  auto index = 0;
  auto pawns = get_pawns ();
  this->players = std::vector<Player> (nb_player);

  for (auto &player: this->players)
    {
      std::array<Color, 5> array_colors = {BLUE, BLACK,
                                           GREEN, PURPLE, RED};
      auto next_colors = array_colors[index];
      player = Player (next_colors);
      auto p_pawn = next_pawn (next_colors, pawns);
      auto i = 0;
      while (i < 3)
        {
          player.fill_pawn (i, p_pawn);
          auto stop = false;
          auto it = pawns.begin ();
          while (it != pawns.end () && !stop)
            {
              if ((*it).get_pawn_color () == p_pawn.get_pawn_color ())
                {
                  pawns.erase (it);
                  stop = true;
                }
            }
          p_pawn = next_pawn (next_colors, pawns);
          i++;
        }
      index++;
    }
  create_board (pawns);
  assign_player ();
  update_id = 1;
  notify_observers (this);

}

Pawn Game::next_pawn (Color next_color, const std::vector<Pawn> &pawns)
{
  static Pawn p = Pawn ();
  for (auto &pawn: pawns)
    {
      if (pawn.get_pawn_color () == next_color)
        {
          p = pawn;
          return p;
        }
    }
  return p;
}

void Game::create_board (std::vector<Pawn> &vector)
{

  this->game_board = Board ();

  this->game_board.create_board (vector);

}

void Game::assign_player ()
{
  this->current_player = players.front ();
}

void Game::next_player ()
{
  if (this->current_player == players.back ())
    {
      assign_player ();
    }
  else
    {
      static Player p;
      for (auto it = players.begin (); it != players.end (); ++it)
        {
          if ((*it) == this->current_player)
            {
              it++;
              p = *(it);
              this->current_player = Player (p);
              break;
            }
        }

    }

}

void Game::move_drop ()
{

  auto assign = false;
  for (int i = 0; i < Board::get_big_pawn (); ++i)
    {
      auto p = position (i, 0);
      auto square = this->game_board.get_square_at (p);
      auto insertion = position ();
      if (square.equal_colors (current_player.get_player_color ()) && !assign)
        {
          {
            auto next_position = position (i, drop.get_dew_position () == position () ? de_value :
                                              drop.get_dew_position ().get_y () + de_value);
            while (!rows_are_free (this->game_board.get_rows_at (i)))
              {
                next_position = position (next_position.get_x () + 1, next_position.get_y ());
                i++;
              }
            if (!Board::is_inside (next_position))
              {
                auto y = (Board::get_little_pawn ());
                auto final_y = y < next_position.get_y () ? next_position.get_y () - y : (y - next_position.get_y ());
                next_position = position (next_position.get_x (), final_y);
              }
            insertion = next_position;
            drop.set_dew_position (insertion);
            assign = true;
          }
        }
    }
  update_id = 2;
  notify_observers (this);
}

void Game::place_pawn_at (position &position)
{
  this->game_board.get_square_at (position)
      .add_pawn (current_player.get_last_pawn ());
  auto p_function = [this] (Player &player)
  {
      if (this->current_player == player)
        {
          player.remove_last_pawn ();
        }
  };
  std::for_each (players.begin (), players.end (), p_function);
  update_id = 3;
  notify_observers (this);

}

bool Game::rows_are_free (square *rows)
{
  return Board::rows_are_free (rows);
}

bool Game::players_pawns_on_board ()
{
  auto index = 0;
  while (index < this->players.size () && players.at (index).all_pawn_on_board ())
    { index++; }
  return index == players.size ();
}
std::vector<Player> &Game::get_players ()
{
  return players;
}
Board Game::get_game_board () const
{
  return game_board;
}
dew_drop Game::get_drop () const
{
  return drop;
}
Player Game::get_current_player () const
{
  return current_player;
}
std::vector<Pawn> Game::get_pawns ()
{
  int index = 0;
  std::array<Color, 5> array_colors = {BLUE, BLACK,
                                       GREEN, PURPLE, RED};
  Color next;
  static std::vector<Pawn> arrays;
  for (int i = 0; i < 15; ++i)
    {
      if (i != 0 && i % 3 == 0)
        {
          index++;
          next = array_colors[index];

        }
      else
        {
          next = array_colors[index];
        }
      auto instance = Pawn (next, true);
      arrays.push_back (instance);

    }
  return arrays;
}
void Game::turn_off_light ()
{
  for (int i = 0; i < Board::get_big_pawn (); ++i)
    {
      for (int j = 0; j < Board::get_little_pawn (); ++j)
        {
          auto p = position (i, j);
          auto square = this->game_board.get_square_at (p);
          if (!square.get_square_pawn ().is_not_used ())
            {
              this->game_board.get_square_at (p).get_square_pawn ().set_star_on (false);
            }
        }
    }
}
void Game::move_from_board_at (position &position)
{
  auto p_function = [this, &position] (Player &player)
  {
      if (this->current_player == player)
        {
          this->game_board.get_pawn_at (position).set_star_on (true);
          player.push_back_pawn (this->game_board.get_pawn_at (position));
        }
  };
  std::for_each (players.begin (), players.end (), p_function);
  this->game_board.get_square_at (position).remove_pawn ();
  next_player();
  update_id = 4;
  notify_observers (this);

}
bool Game::is_over ()
{
  int sum = 0;
  auto p_function = [&sum] (Player &player)
  {
      for ([[maybe_unused]] Pawn pawn: player.get_player_pawn ())
        {
          sum++;
        }

  };
  std::for_each (players.begin (), players.end (), p_function);
  return sum == (players.size () * 3) - 1;
}
int Game::get_update_id () const
{
  return update_id;
}


