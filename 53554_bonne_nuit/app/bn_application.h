//
// Created by jj on 21.10.21.
//

#ifndef _BN_APPLICATION_H_
#define _BN_APPLICATION_H_

#include <QObject>
#include "../model/Game.h"
#include "../view/bn_gui.h"
class bn_application : public QObject {
  Game game;
  bn_gui *gui;
 Q_OBJECT
 public:
  /**
   *@brief  Default controller constructor
   *  create the two attribute object ( game and gui)
   */
  bn_application ();
  /**
   *@brief Launch the application
   */
  void start ();

 private slots:
  /**
   *@brief slot use when the number of player is choose and validate
   */
  void validate_input ();
  /**
   *@brief  slot use when the player want to throw a dice
   */
  void de_event ();
  /**
   *@brief slot that move the pawn from the player to the board
   */
  void move_event ();
  /**
   *@brief slot that defined action made when the player choose to remove from the board
   * @param Position position received when click on the button
   */
  void square_views_event (position &);
 private:
  /**
   *@brief function to connect the slots defined to the signal received by each button
   */
  void connect_slots ();

};

#endif //_BN_APPLICATION_H_
