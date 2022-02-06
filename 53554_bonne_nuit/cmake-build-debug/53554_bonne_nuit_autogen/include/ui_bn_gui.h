/********************************************************************************
** Form generated from reading UI file 'bn_gui.ui'
**
** Created by: Qt User Interface Compiler version 6.1.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BN_GUI_H
#define UI_BN_GUI_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QLabel>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_bn_gui
{
public:
    QWidget *up_widget;
    QSpinBox *nbPlayer_chooser;
    QLabel *label;
    QWidget *central_widget;
    QLabel *label_messages;
    QLabel *drop_view;
    QLabel *position_dew;
    QLabel *de_value;
    QWidget *left_widget;
    QWidget *right_widget;
    QLabel *label_2;
    QLabel *label_3;
    QWidget *buttons_widget;

    void setupUi(QWidget *bn_gui)
    {
        if (bn_gui->objectName().isEmpty())
            bn_gui->setObjectName(QString::fromUtf8("bn_gui"));
        bn_gui->resize(1255, 702);
        QFont font;
        font.setFamilies({QString::fromUtf8("TeX Gyre Cursor")});
        bn_gui->setFont(font);
        up_widget = new QWidget(bn_gui);
        up_widget->setObjectName(QString::fromUtf8("up_widget"));
        up_widget->setGeometry(QRect(320, 10, 531, 71));
        nbPlayer_chooser = new QSpinBox(up_widget);
        nbPlayer_chooser->setObjectName(QString::fromUtf8("nbPlayer_chooser"));
        nbPlayer_chooser->setGeometry(QRect(210, 10, 191, 51));
        QFont font1;
        font1.setFamilies({QString::fromUtf8("UbuntuCondensed Nerd Font")});
        font1.setItalic(false);
        nbPlayer_chooser->setFont(font1);
        nbPlayer_chooser->setAlignment(Qt::AlignCenter);
        nbPlayer_chooser->setReadOnly(false);
        nbPlayer_chooser->setButtonSymbols(QAbstractSpinBox::PlusMinus);
        nbPlayer_chooser->setMinimum(2);
        nbPlayer_chooser->setMaximum(5);
        nbPlayer_chooser->setStepType(QAbstractSpinBox::AdaptiveDecimalStepType);
        label = new QLabel(up_widget);
        label->setObjectName(QString::fromUtf8("label"));
        label->setGeometry(QRect(10, 10, 211, 51));
        QFont font2;
        font2.setFamilies({QString::fromUtf8("Timmana")});
        font2.setBold(true);
        label->setFont(font2);
        central_widget = new QWidget(bn_gui);
        central_widget->setObjectName(QString::fromUtf8("central_widget"));
        central_widget->setGeometry(QRect(50, 90, 1171, 561));
        label_messages = new QLabel(central_widget);
        label_messages->setObjectName(QString::fromUtf8("label_messages"));
        label_messages->setGeometry(QRect(20, 490, 1131, 61));
        drop_view = new QLabel(central_widget);
        drop_view->setObjectName(QString::fromUtf8("drop_view"));
        drop_view->setGeometry(QRect(570, 80, 51, 61));
        drop_view->setTextFormat(Qt::RichText);
        drop_view->setPixmap(QPixmap(QString::fromUtf8("../img/drop.png")));
        position_dew = new QLabel(central_widget);
        position_dew->setObjectName(QString::fromUtf8("position_dew"));
        position_dew->setGeometry(QRect(510, 180, 171, 20));
        QFont font3;
        font3.setFamilies({QString::fromUtf8("Ubuntu Nerd Font")});
        font3.setBold(true);
        position_dew->setFont(font3);
        de_value = new QLabel(central_widget);
        de_value->setObjectName(QString::fromUtf8("de_value"));
        de_value->setGeometry(QRect(490, 240, 191, 61));
        de_value->setBaseSize(QSize(0, 0));
        de_value->setTextFormat(Qt::RichText);
        de_value->setAlignment(Qt::AlignCenter);
        left_widget = new QWidget(central_widget);
        left_widget->setObjectName(QString::fromUtf8("left_widget"));
        left_widget->setGeometry(QRect(20, 50, 341, 351));
        right_widget = new QWidget(central_widget);
        right_widget->setObjectName(QString::fromUtf8("right_widget"));
        right_widget->setGeometry(QRect(810, 50, 331, 341));
        label_2 = new QLabel(central_widget);
        label_2->setObjectName(QString::fromUtf8("label_2"));
        label_2->setGeometry(QRect(70, 17, 241, 20));
        QFont font4;
        font4.setFamilies({QString::fromUtf8("Ubuntu")});
        font4.setBold(true);
        font4.setItalic(false);
        label_2->setFont(font4);
        label_3 = new QLabel(central_widget);
        label_3->setObjectName(QString::fromUtf8("label_3"));
        label_3->setGeometry(QRect(840, 20, 251, 17));
        label_3->setFont(font3);
        label_3->setAlignment(Qt::AlignCenter);
        buttons_widget = new QWidget(central_widget);
        buttons_widget->setObjectName(QString::fromUtf8("buttons_widget"));
        buttons_widget->setGeometry(QRect(410, 400, 381, 80));

        retranslateUi(bn_gui);

        QMetaObject::connectSlotsByName(bn_gui);
    } // setupUi

    void retranslateUi(QWidget *bn_gui)
    {
        bn_gui->setWindowTitle(QCoreApplication::translate("bn_gui", "bn_gui", nullptr));
        label->setText(QCoreApplication::translate("bn_gui", "choose the number of players", nullptr));
        label_messages->setText(QCoreApplication::translate("bn_gui", "message", nullptr));
        drop_view->setText(QString());
        position_dew->setText(QCoreApplication::translate("bn_gui", "position verre = nullptr", nullptr));
        de_value->setText(QCoreApplication::translate("bn_gui", "<html><head/><body><p>Valeur d\303\251 : 0</p></body></html>", nullptr));
        label_2->setText(QCoreApplication::translate("bn_gui", "Board (Plateau)", nullptr));
        label_3->setText(QCoreApplication::translate("bn_gui", "Active player (Joueur Actif)", nullptr));
    } // retranslateUi

};

namespace Ui {
    class bn_gui: public Ui_bn_gui {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BN_GUI_H
