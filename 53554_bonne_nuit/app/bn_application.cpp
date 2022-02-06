//
// Created by jj on 21.10.21.
//

#include "bn_application.h"
void bn_application::validate_input ()
{
  auto nb_player = gui->get_nb_player ();
  this->game.create_game (nb_player);
}
void bn_application::connect_slots ()
{
  QObject::connect (this->gui->get_valid_button (), SIGNAL(clicked ()), this, SLOT(validate_input ()));
  QObject::connect (this->gui->get_throw_de (), SIGNAL(clicked ()), this, SLOT(de_event ()));
  QObject::connect (this->gui->get_move_pawn (), SIGNAL(clicked ()), this, SLOT(move_event ()));

}
bn_application::bn_application ()
{
  this->game = Game ();
  this->gui = new bn_gui (nullptr);

}
void bn_application::start ()
{
  this->game.register_observer (gui);
  connect_slots ();
  gui->show ();
}
void bn_application::de_event ()
{
  this->game.generate_de ();
  this->game.move_drop ();
}
void bn_application::move_event ()
{
  this->game.place_pawn_at (this->game.get_drop ().get_dew_position ());
  if (gui->is_fill_1 ())
    {
      auto event = [this] (square_view *square_view)
      {
          QObject::connect (square_view, SIGNAL(sendValue (position & )), this,
                            SLOT (square_views_event (position & )));

      };
      std::for_each (this->gui->get_squares_view ().begin (), this->gui->get_squares_view ().end (), event);
    }
}
void bn_application::square_views_event (position &position)
{
  this->game.move_from_board_at (position);
}