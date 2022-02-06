//
// Created by jj on 01.10.21.
//

#ifndef _BN_GUI_H_
#define _BN_GUI_H_

#include <QWidget>
#include "../model/Game.h"
#include "QtDebug"
#include <QPushButton>
#include <QVBoxLayout>
#include "QLabel"
#include "square_view.h"

QT_BEGIN_NAMESPACE
namespace Ui
{
    class bn_gui;
}
QT_END_NAMESPACE

class bn_gui : public QWidget, public observer {
 Q_OBJECT

 public:
  /**
   *@brief constructor for the gui
   * @param parent QWidget parent of the gui
   */
  explicit bn_gui (QWidget *parent = nullptr);
  /**
   * @brief update function the observer and observable
   * @param observable (game)
   */
  void update (observable *) override;
  /**
   * @brief default destructor
   */
  ~bn_gui () override;
 private:
  /**
   *@brief apply the light off mode on the gui
   * @param game Object
   */
  void turn_off_light (Game *game);
/**
 * @brief delect the layout when you need to update the interface of the view
 */
  void delete_layout ();
  /**
   * @brief delect the up widget children
   */
  void delete_up_widget_children ();
  /**
   * @brief defined the name of the player to string for the Qlabel to show
   */
  static void defined_player_name (Player &, QLabel *);
  /**
   * @brief defined the left layout state with the game given by argument
   * @param game Game object
   */
  void defined_left_layout_state (Game *game);
  /**
   * @brief update the up widget by changing to the old view to the new label
   */
  void update_up_widget ();
  /**
    * @brief defined the right layout state with the game given by argument
   * @param game Game object
   */
  void defined_right_layout_state (Game *game);
  /**
   *@brief initialized the the view for the first view
   */
  void init_function ();
  /**
   *@brief initialized layout according to the game given as argument
   * @param game Object Game
   */
  void init_layouts (Game *game);
/**
 * @brief get a string equivalent from the player color given as argument
 * @param p player
 * @return a string version of the color
 */
  static std::string get_player_color (const Player &p);
  /**
   *@brief initialized the view when it need to switch to night mode
   * @param game Object
   */
  void init_all_night (Game *);
  /**
   * @brief initialized the buttons for the view
   */
  void init_buttons ();
  /**
   * @brief redefined the buttons when an action is made
   * @param game  Object game
   */
  void redefined_buttons (Game *game);
  Ui::bn_gui *ui;
  std::vector<square_view *> squares_view;
  QPushButton *throw_de;
  QPushButton *move_pawn;
  QGridLayout *grid_left_layout;
  QPushButton *valid_button;
  bool is_fill;
 public:
  /**
   * @brief getter for is_fill attribute
   * @return  is_fill
   */
  [[nodiscard]] bool is_fill_1 () const;
  /**
   * @brief getter for the vector of square_view
   * @return  std::vector<square_view*>
   */
  [[nodiscard]] const std::vector<square_view *> &get_squares_view () const;
  /**
   * @brief getter for the dice throw button
   * @return QPushButton *
   */
  [[nodiscard]] QPushButton *get_throw_de () const;
  /**
   * @brief getter for the pawn that move button
   * @return QPushButton *
   */
  [[nodiscard]] QPushButton *get_move_pawn () const;
  /**
   * @brief getter for the validate button
   * @return QPushButton *
   */
  [[nodiscard]] QPushButton *get_valid_button () const;
  /**
   * @brief getter for the number of player chosen by the player
   * @return  nb_player
   */
  int get_nb_player ();
 private:
  QGridLayout *grid_right_layout;

};

#endif //_BN_GUI_H_
