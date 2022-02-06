//
// Created by jj on 14.10.21.
//

#ifndef _SQUARE_VIEW_H_
#define _SQUARE_VIEW_H_

#include <QPushButton>
#include "../model/position.h"
#include "QMouseEvent"
class square_view : public QPushButton {
 Q_OBJECT
  position square_position;
 protected:
  /**
   *@brief redefinition of the mousePressEvent
   * @param event  QMouseEvent
   */
  void mousePressEvent (QMouseEvent *event) override;
 signals:
  /**
   *@brief signal to received the position
   */
  void sendValue (position &);
 public:
  /**
   * @brief constructor for square_view
   * @param parent Qwidget parent
   * @param square_position position for the square
   */
  explicit square_view (QWidget *parent = nullptr, const position &square_position = position ());
  /**
   * @brief getter for the position
   * @return Position
   */
  [[maybe_unused]] [[nodiscard]] const position &get_square_position () const;

};

#endif //_SQUARE_VIEW_H_
