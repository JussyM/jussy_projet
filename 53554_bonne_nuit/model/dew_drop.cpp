//
// Created by jj on 23.09.21.
//

#include "dew_drop.h"
dew_drop::dew_drop (position dew_position) : dew_position (dew_position)
{}
position &dew_drop::get_dew_position ()
{
  return dew_position;
}
void dew_drop::set_dew_position (position& position)
{
  dew_drop::dew_position = position;
}

[[maybe_unused]] bool dew_drop::equal_position (position p)
{
  return p == this->dew_position;
}
