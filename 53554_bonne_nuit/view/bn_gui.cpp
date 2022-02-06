//
// Created by jj on 01.10.21.
//

// You may need to build the project (run Qt uic code generator) to get "ui_bn_gui.h" resolved


#include <iostream>
#include "bn_gui.h"
#include "ui_bn_gui.h"
#include "square_view.h"

bn_gui::bn_gui (QWidget *parent) :
    QWidget (parent), ui (new Ui::bn_gui)
{
  ui->setupUi (this);
  init_function ();
  init_buttons ();

}

bn_gui::~bn_gui ()
{
  delete ui;
}

void bn_gui::init_layouts (Game *game)
{
  grid_left_layout = new QGridLayout ();
  grid_right_layout = new QGridLayout ();
  defined_left_layout_state (game);
  defined_right_layout_state (game);
  move_pawn->setDisabled (true);

}
void bn_gui::init_function ()
{
  ui->central_widget->hide ();
  ui->drop_view->setPixmap (QPixmap{":/img/drop.png"});
}
void bn_gui::delete_up_widget_children ()
{
  for (auto i: ui->up_widget->children ())
    {
      delete i;
    }
}
void bn_gui::defined_player_name (Player &player, QLabel *label)
{
  switch (player.get_player_color ())
    {
      case BLUE:
        label->setText ("Joueur:BLEU");
      break;
      case BLACK:
        label->setText ("Joueur:NOIR");
      break;
      case GREEN:
        label->setText ("Joueur:VERT");
      break;
      case PURPLE:
        label->setText ("Joueur:VIOLET");
      break;
      case RED:
        label->setText ("Joueur:ROUGE");
      break;
    }
}
void bn_gui::defined_left_layout_state (Game *game)
{
  auto board = game->get_game_board ();
  for (int i = 0; i < Board::get_big_pawn (); ++i)
    {
      for (int j = 0; j < Board::get_little_pawn (); ++j)
        {
          auto p = position (i, j);
          auto square = board.get_square_at (p);
          square_view *var_square_view;
          if (square.square_is_empty ())
            {
              var_square_view = new square_view (nullptr, p);
              var_square_view->setIcon (QIcon (":/img/empty.png"));
              grid_left_layout->addWidget (var_square_view, i, j);
            }
          else
            {
              var_square_view = new square_view (nullptr, p);
              switch (square.get_square_pawn ().get_pawn_color ())
                {
                  case BLUE:
                    var_square_view->setIcon (QIcon (":/img/star_blue.png"));
                  break;
                  case BLACK:
                    var_square_view->setIcon (QIcon (":/img/star_black.png"));
                  break;
                  case GREEN:
                    var_square_view->setIcon (QIcon (":/img/star_green.png"));
                  break;
                  case PURPLE:
                    var_square_view->setIcon (QIcon (":/img/star_purple.png"));
                  break;
                  case RED:
                    var_square_view->setIcon (QIcon (":/img/star_red.png"));
                  break;
                  default:;

                }
              grid_left_layout->addWidget (var_square_view, i, j);

            }
        }
    }
  ui->left_widget->setLayout (grid_left_layout);

}
void bn_gui::update_up_widget ()
{
  auto game_name = new QLabel ("GAME_NAME: GOOD NIGHT");
  game_name->setFont (QFont ("Timmana", 20, 50, false));
  game_name->setAlignment (Qt::AlignHCenter);
  auto vertical_layout = new QVBoxLayout ();
  vertical_layout->addWidget (game_name, 10, Qt::AlignCenter);
  vertical_layout->setAlignment (Qt::AlignCenter);
  delete_up_widget_children ();
  ui->up_widget->setLayout (vertical_layout);
  ui->up_widget->setGeometry (320, 10, 520, 68);
  ui->up_widget->updateGeometry ();
  ui->up_widget->setLayout (vertical_layout);

}
void bn_gui::defined_right_layout_state (Game *_game)
{
  QLabel *player_name_label;
  QLabel *player_pawns;
  Player p;
  for (auto index = 0; index < static_cast<int>(_game->get_players ().size ()); ++index)
    {
      player_name_label = new QLabel ();
      p = _game->get_players ().at (index);
      defined_player_name (p, player_name_label);
      grid_right_layout->addWidget (player_name_label, index, 0);
      auto k = 2;
      for (auto j: p.get_player_pawn ())
        {
          player_pawns = new QLabel ();
          switch (j.get_pawn_color ())
            {
              case BLUE:
                player_pawns->setPixmap (QPixmap (":/img/star_blue.png"));
              break;
              case BLACK:
                player_pawns->setPixmap (QPixmap (":/img/star_black.png"));
              break;
              case GREEN:
                player_pawns->setPixmap (QPixmap (":/img/star_green.png"));
              break;
              case PURPLE:
                player_pawns->setPixmap (QPixmap (":/img/star_purple.png"));
              break;
              case RED:
                player_pawns->setPixmap (QPixmap (":/img/star_red.png"));
              break;
              default:;
            }
          grid_right_layout->addWidget (player_pawns, index, k);
          k++;
        }

    }
  ui->right_widget->setLayout (grid_right_layout);
}

std::string bn_gui::get_player_color (const Player &p)
{
  switch (p.get_player_color ())
    {
      case BLUE:
        return {std::string ("BLEU")};
      case BLACK:
        return {std::string ("NOIR")};
      case GREEN:
        return {std::string ("VERT")};
      case PURPLE:
        return {std::string ("VIOLET")};
      case RED:
        return {std::string ("ROUGE")};
      default:;

    }
  return {std::string ()};
}

void bn_gui::delete_layout ()
{
  for (auto i: ui->right_widget->children ())
    {
      delete i;
    }
  for (auto i: ui->left_widget->children ())
    {
      delete i;
    }
}
void bn_gui::turn_off_light (Game *game)
{
  delete_layout ();
  init_all_night (game);

}

void bn_gui::init_all_night (Game *game)
{
  game->turn_off_light ();
  grid_left_layout = new QGridLayout ();
  grid_right_layout = new QGridLayout ();
  auto board = game->get_game_board ();
  for (int i = 0; i < Board::get_big_pawn (); ++i)
    {
      for (int j = 0; j < Board::get_little_pawn (); ++j)
        {
          auto instance = position (i, j);
          auto square = board.get_square_at (instance);
          square_view *p_square_view;
          if (square.square_is_empty ())
            {
              p_square_view = new square_view (nullptr, instance);
              p_square_view->setIcon (QIcon (":/img/night.png"));
              grid_left_layout->addWidget (p_square_view, i, j);
            }
          else
            {
              if (!square.get_square_pawn ().is_star_on ())
                {
                  p_square_view = new square_view (nullptr, instance);
                  p_square_view->setIcon (QIcon (":/img/star_night.png"));
                  grid_left_layout->addWidget (p_square_view, i, j);
                  squares_view.push_back (p_square_view);
                }
              else
                {
                  p_square_view = new square_view (nullptr, instance);
                  switch (square.get_square_pawn ().get_pawn_color ())
                    {
                      case BLUE:
                        p_square_view->setIcon (QIcon (":/img/star_blue.png"));
                      break;
                      case BLACK:
                        p_square_view->setIcon (QIcon (":/img/star_black.png"));
                      break;
                      case GREEN:
                        p_square_view->setIcon (QIcon (":/img/star_green.png"));
                      break;
                      case PURPLE:
                        p_square_view->setIcon (QIcon (":/img/star_purple.png"));
                      break;
                      case RED:
                        p_square_view->setIcon (QIcon (":/img/star_red.png"));
                      break;
                      default:;
                    }
                  grid_left_layout->addWidget (p_square_view, i, j);

                }
            }
          ui->left_widget->setLayout (grid_left_layout);
          defined_right_layout_state (game);
        }
    }
  this->is_fill = true;
}

void bn_gui::update (observable *game)
{
  auto g = dynamic_cast<Game *>(game);
  switch (g->get_update_id ())
    {
      case 1:
        {
          squares_view.reserve (get_nb_player () * 3);
          update_up_widget ();
          init_layouts (g);
          ui->central_widget->show ();

          std::string s =
              "Pour commencer lancé le dé joueur " + get_player_color (g->get_current_player ());
          ui->label_messages->setText (s.c_str ());
        };
      break;
      case 2:
        {
          ui->de_value->setText ("Valeur dé : " + QString::number (g->get_de_value ()));
          auto position = g->get_drop ().get_dew_position ();
          ui->position_dew->setText (
              "position verre = " + QString::number (position.get_x ()) + "  " + QString::number (position.get_y ()));
          ui->label_messages->setText ("position de la goute de verre est donc : "
                                       + QString::number (position.get_x ()).QString::append (" ")
                                           .append (QString::number (position.get_y ()))
                                           .append (" Vous pouvez donc déplacer vers le plateau"));
          move_pawn->setDisabled (false);
          throw_de->setDisabled (true);

        };
      break;
      case 3:
        {
          if (g->players_pawns_on_board ())
            {
              throw_de->setDisabled (true);
              move_pawn->setDisabled (true);
              std::string s =
                  "Tout les pions sont sur le plateau l'heure de retourner les pions étoilé Place au joueur : "
                  + get_player_color (g->get_current_player ()) + " de retourner un pion";
              ui->label_messages->setText (s.c_str ());
              turn_off_light (g);
            }
          else
            {
              g->next_player ();
              delete_layout ();
              init_layouts (g);
              std::string s =
                  "Lancé le dé joueur " + get_player_color (g->get_current_player ());
              ui->label_messages->setText (s.c_str ());
              throw_de->setDisabled (false);
            }
        };
      break;
      case 4:
        {
          if (g->is_over ())
            {
              squares_view.clear ();
              delete_layout ();
              init_layouts (g);
              auto message = "Jeux terminer Vous pouvez fermer l'application";
              ui->label_messages->setText (message);
            }
          else
            {
              redefined_buttons (g);
              auto message = "Place au joueur " +
                             get_player_color (g->get_current_player ()) + " de pioché du plateau";
              ui->label_messages->setText (message.c_str ());
            }

        };
      break;
    }
}
void bn_gui::init_buttons ()
{
  this->throw_de = new QPushButton (ui->central_widget);
  this->move_pawn = new QPushButton (ui->central_widget);
  this->valid_button = new QPushButton (ui->up_widget);
  this->valid_button->setGeometry (QRect (410, 10, 101, 51));
  this->valid_button->setText ("Enter");
  QFont font_2;
  font_2.setFamilies ({QString::fromUtf8 ("Ubuntu Nerd Font")});
  this->valid_button->setFont (font_2);
  this->throw_de->setGeometry (QRect (430, 330, 121, 41));
  this->move_pawn->setGeometry (QRect (600, 330, 141, 41));
  this->throw_de->setText ("lance dé");
  this->throw_de->setObjectName ("de_button");
  this->move_pawn->setText ("deplacer pion");
  this->move_pawn->setObjectName ("pawn_move");
  this->throw_de->setIconSize (QSize (16, 16));
  this->move_pawn->setIconSize (QSize (16, 16));

}
const std::vector<square_view *> &bn_gui::get_squares_view () const
{
  return squares_view;
}
QPushButton *bn_gui::get_throw_de () const
{
  return throw_de;
}
QPushButton *bn_gui::get_move_pawn () const
{
  return move_pawn;
}
QPushButton *bn_gui::get_valid_button () const
{
  return valid_button;
}
int bn_gui::get_nb_player ()
{
  return ui->nbPlayer_chooser->value ();
}
void bn_gui::redefined_buttons (Game *game)
{
  auto p_function = [game] (square_view *view)
  {
      auto p = view->get_square_position ();
      if (game->get_game_board ().get_square_at (p).square_is_empty ())
        {
          view->setIcon (QIcon (":/img/empty.png"));
        }
  };
  std::for_each (squares_view.begin (), squares_view.end (), p_function);
  defined_right_layout_state (game);
}
bool bn_gui::is_fill_1 () const
{
  return is_fill;
}
