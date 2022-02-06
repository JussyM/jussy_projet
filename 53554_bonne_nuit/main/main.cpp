
#include <QApplication>
#include "../view/bn_gui.h"
#include "../app/bn_application.h"
/**
 * @brief Main function
 * @param argc
 * @param argv
 * @return executable
 */
int main (int argc, char *argv[])
{
  QApplication a (argc, argv);
  auto app = new bn_application ();
  app->start ();
  return QApplication::exec ();
}
