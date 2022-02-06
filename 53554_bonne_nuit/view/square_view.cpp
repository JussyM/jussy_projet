//
// Created by jj on 14.10.21.
//

#include "square_view.h"
square_view::square_view (QWidget *parent, const position &square_position)
    : QPushButton (parent), square_position (square_position)
{}
[[maybe_unused]] const position &square_view::get_square_position () const
{
  return square_position;
}
void square_view::mousePressEvent (QMouseEvent *event)
{
  event->accept ();
  emit sendValue (square_position);
}
