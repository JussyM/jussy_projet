/********************************************************************************
** Form generated from reading UI file 'client_connection_window.ui'
**
** Created by: Qt User Interface Compiler version 6.2.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CLIENT_CONNECTION_WINDOW_H
#define UI_CLIENT_CONNECTION_WINDOW_H

#include <QtCore/QLocale>
#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QFrame>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTextBrowser>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_client_connection_window
{
public:
    QFrame *main_frame;
    QVBoxLayout *verticalLayout_3;
    QFrame *frame;
    QHBoxLayout *horizontalLayout_3;
    QSpacerItem *horizontalSpacer_5;
    QLabel *label_4;
    QSpacerItem *horizontalSpacer_6;
    QSpacerItem *verticalSpacer_3;
    QTextBrowser *game_description;
    QLabel *label_5;
    QVBoxLayout *connectionPart;
    QLabel *label;
    QSpacerItem *verticalSpacer;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *horizontalLayout;
    QSpacerItem *horizontalSpacer;
    QTextEdit *textEdit_2;
    QSpacerItem *horizontalSpacer_2;
    QSpacerItem *verticalSpacer_2;
    QHBoxLayout *horizontalLayout_2;
    QSpacerItem *horizontalSpacer_4;
    QPushButton *_sendBt;
    QSpacerItem *horizontalSpacer_3;

    void setupUi(QWidget *client_connection_window)
    {
        if (client_connection_window->objectName().isEmpty())
            client_connection_window->setObjectName(QString::fromUtf8("client_connection_window"));
        client_connection_window->resize(968, 580);
        main_frame = new QFrame(client_connection_window);
        main_frame->setObjectName(QString::fromUtf8("main_frame"));
        main_frame->setGeometry(QRect(60, 30, 852, 500));
        main_frame->setMaximumSize(QSize(16777215, 600));
        verticalLayout_3 = new QVBoxLayout(main_frame);
        verticalLayout_3->setSpacing(6);
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        verticalLayout_3->setContentsMargins(-1, 9, -1, 2);
        frame = new QFrame(main_frame);
        frame->setObjectName(QString::fromUtf8("frame"));
        horizontalLayout_3 = new QHBoxLayout(frame);
        horizontalLayout_3->setObjectName(QString::fromUtf8("horizontalLayout_3"));
        horizontalSpacer_5 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_3->addItem(horizontalSpacer_5);

        label_4 = new QLabel(frame);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        QFont font;
        font.setFamilies({QString::fromUtf8("Comic Sans MS")});
        font.setPointSize(22);
        label_4->setFont(font);

        horizontalLayout_3->addWidget(label_4);

        horizontalSpacer_6 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_3->addItem(horizontalSpacer_6);


        verticalLayout_3->addWidget(frame);

        verticalSpacer_3 = new QSpacerItem(20, 100, QSizePolicy::Minimum, QSizePolicy::Expanding);

        verticalLayout_3->addItem(verticalSpacer_3);

        game_description = new QTextBrowser(main_frame);
        game_description->setObjectName(QString::fromUtf8("game_description"));
        game_description->setEnabled(true);
        QSizePolicy sizePolicy(QSizePolicy::Expanding, QSizePolicy::Maximum);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(7);
        sizePolicy.setHeightForWidth(game_description->sizePolicy().hasHeightForWidth());
        game_description->setSizePolicy(sizePolicy);
        game_description->setMinimumSize(QSize(830, 223));
        game_description->setMaximumSize(QSize(657, 16777215));
        QFont font1;
        font1.setFamilies({QString::fromUtf8("Comic Sans MS")});
        game_description->setFont(font1);
        game_description->setLocale(QLocale(QLocale::English, QLocale::Belgium));

        verticalLayout_3->addWidget(game_description);

        label_5 = new QLabel(main_frame);
        label_5->setObjectName(QString::fromUtf8("label_5"));

        verticalLayout_3->addWidget(label_5);

        connectionPart = new QVBoxLayout();
        connectionPart->setSpacing(11);
        connectionPart->setObjectName(QString::fromUtf8("connectionPart"));
        label = new QLabel(main_frame);
        label->setObjectName(QString::fromUtf8("label"));
        QFont font2;
        font2.setFamilies({QString::fromUtf8("Comic Sans MS")});
        font2.setPointSize(15);
        label->setFont(font2);
        label->setLocale(QLocale(QLocale::English, QLocale::Belgium));
        label->setFrameShape(QFrame::NoFrame);
        label->setFrameShadow(QFrame::Plain);
        label->setAlignment(Qt::AlignCenter);

        connectionPart->addWidget(label);

        verticalSpacer = new QSpacerItem(20, 26, QSizePolicy::Minimum, QSizePolicy::Expanding);

        connectionPart->addItem(verticalSpacer);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer);

        textEdit_2 = new QTextEdit(main_frame);
        textEdit_2->setObjectName(QString::fromUtf8("textEdit_2"));
        textEdit_2->setMaximumSize(QSize(16777215, 40));
        QFont font3;
        font3.setFamilies({QString::fromUtf8("Comic Sans MS")});
        font3.setPointSize(14);
        textEdit_2->setFont(font3);

        horizontalLayout->addWidget(textEdit_2);

        horizontalSpacer_2 = new QSpacerItem(40, 30, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout->addItem(horizontalSpacer_2);


        verticalLayout->addLayout(horizontalLayout);

        verticalSpacer_2 = new QSpacerItem(20, 20, QSizePolicy::Minimum, QSizePolicy::MinimumExpanding);

        verticalLayout->addItem(verticalSpacer_2);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        horizontalSpacer_4 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer_4);

        _sendBt = new QPushButton(main_frame);
        _sendBt->setObjectName(QString::fromUtf8("_sendBt"));
        _sendBt->setMinimumSize(QSize(200, 50));
        QFont font4;
        font4.setFamilies({QString::fromUtf8("Comic Sans MS")});
        font4.setPointSize(16);
        _sendBt->setFont(font4);
        _sendBt->setLocale(QLocale(QLocale::English, QLocale::Belgium));

        horizontalLayout_2->addWidget(_sendBt);

        horizontalSpacer_3 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer_3);


        verticalLayout->addLayout(horizontalLayout_2);


        connectionPart->addLayout(verticalLayout);


        verticalLayout_3->addLayout(connectionPart);


        retranslateUi(client_connection_window);

        QMetaObject::connectSlotsByName(client_connection_window);
    } // setupUi

    void retranslateUi(QWidget *client_connection_window)
    {
        client_connection_window->setWindowTitle(QCoreApplication::translate("client_connection_window", "Form", nullptr));
        label_4->setText(QCoreApplication::translate("client_connection_window", "Welcome to the game of Blackjack !", nullptr));
        game_description->setHtml(QCoreApplication::translate("client_connection_window", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
"<html><head><meta name=\"qrichtext\" content=\"1\" /><meta charset=\"utf-8\" /><style type=\"text/css\">\n"
"p, li { white-space: pre-wrap; }\n"
"</style></head><body style=\" font-family:'Comic Sans MS'; font-size:9pt; font-weight:400; font-style:normal;\">\n"
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:14pt; font-weight:600; color:#353740;\">The Objective of Blackjack</span></p>\n"
"<p style=\" margin-top:0px; margin-bottom:21px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-height:161.8%; background-color:#fffffc;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; font-weight:696; color:#353740;\">Beat The Dealer.</span><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\">\302"
                        "\240There are some misconceptions about the objective of the game of blackjack but at the simplest level all you are trying to do is beat the dealer.</span></p>\n"
"<p style=\" margin-top:0px; margin-bottom:21px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-height:161.8%; background-color:#fffffc;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; font-weight:696; color:#353740;\">How do you beat the dealer?</span></p>\n"
"<ol style=\"margin-top: 0px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px; -qt-list-indent: 1;\"><li style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\" style=\" margin-top:0px; margin-bottom:0px; margin-left:39px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:16px;\">By drawing a hand value that is higher than the dealer\342\200\231s hand value</span></li>\n"
"<li style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\" style=\" margi"
                        "n-top:0px; margin-bottom:0px; margin-left:39px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:16px;\">By the dealer drawing a hand value that goes over 21.</span></li>\n"
"<li style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\" style=\" margin-top:0px; margin-bottom:0px; margin-left:39px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:16px;\">By drawing a hand value of 21 on your first two cards, when the dealer does not.</span></li></ol>\n"
"<p style=\" margin-top:0px; margin-bottom:21px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-height:161.8%;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; font-weight:696; color:#353740;\"><br />How do you lose to the dealer?\302\240</span></p>\n"
"<ol style=\"margin-top: 0px; margin-bottom: 0px; margin-left: 0px; margin-right: 0px; -qt-list-indent: 1;\"><li style=\" font-family:'proxima-nova','sans-serif'; font-s"
                        "ize:11pt; color:#353740;\" style=\" margin-top:0px; margin-bottom:0px; margin-left:39px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\">Your hand value exceeds 21.</li>\n"
"<li style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\" style=\" margin-top:0px; margin-bottom:0px; margin-left:39px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:16px;\">The dealers hand has a greater value than yours at the end of the round</span></li></ol>\n"
"<p style=\" margin-top:0px; margin-bottom:21px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-height:161.8%;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\">\302\240</span></p>\n"
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; line-height:161.8%;\"><span style=\" font-family:'proxima-nova','sans-serif'; font-size:11pt; color:#353740;\">It\342\200\231s also impo"
                        "rtant to note, the other players\342\200\231 hands at the table have nothing to do with winning the game of Blackjack like they do in Poker games. For all practical purposes, it\342\200\231s just you against the dealer. Unskilled patrons of the game will try to convince you \342\200\234it\342\200\231s a team sport\342\200\235 but don\342\200\231t be fooled.</span></p></body></html>", nullptr));
        label_5->setText(QString());
        label->setText(QCoreApplication::translate("client_connection_window", "Please provide your name", nullptr));
        _sendBt->setText(QCoreApplication::translate("client_connection_window", "Start the game", nullptr));
    } // retranslateUi

};

namespace Ui {
    class client_connection_window: public Ui_client_connection_window {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CLIENT_CONNECTION_WINDOW_H
