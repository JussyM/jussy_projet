//
// Created by jj on 20.09.21.
//


#include "Player.h"
#include <algorithm>

void Player::fill_pawn (int index, Pawn pawn)
{
  this->player_pawn.push_back (pawn);
}

bool Player::operator== (const Player &rhs) const
{
  return this->player_color == rhs.player_color;
}

bool Player::operator!= (const Player &rhs) const
{
  return !(rhs == *this);
}

const std::vector<Pawn> &Player::get_player_pawn () const
{
  return player_pawn;
}

Pawn &Player::get_last_pawn ()
{
  return this->player_pawn.back ();
}

void Player::remove_last_pawn ()
{
  this->player_pawn.pop_back ();
}

bool Player::all_pawn_on_board ()
{
  return this->player_pawn.empty ();
}

Player::Player (Color player_color) : player_color (player_color)
{}
Color Player::get_player_color () const
{
  return player_color;
}
Player::Player (const Player &source)
{
  this->player_pawn = source.player_pawn;
  this->player_color = source.player_color;
}
void Player::push_back_pawn (Pawn &pawn)
{
  this->player_pawn.push_back (pawn);
}
