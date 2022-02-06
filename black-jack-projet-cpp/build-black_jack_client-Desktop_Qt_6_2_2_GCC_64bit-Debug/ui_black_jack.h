/********************************************************************************
** Form generated from reading UI file 'black_jack.ui'
**
** Created by: Qt User Interface Compiler version 6.2.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BLACK_JACK_H
#define UI_BLACK_JACK_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QFrame>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_black_jack
{
public:
    QFrame *gridFrame;
    QGridLayout *gridLayout_2;
    QFrame *verticalFrame27;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *j7h;
    QVBoxLayout *verticalLayout_12;
    QGridLayout *jCards7;
    QLabel *jName7;
    QHBoxLayout *j1h;
    QFrame *verticalFrame23;
    QVBoxLayout *verticalLayout_3;
    QGridLayout *jCards1;
    QLabel *jName1;
    QFrame *frame_6;
    QHBoxLayout *horizontalLayout_20;
    QHBoxLayout *j5h;
    QVBoxLayout *verticalLayout_14;
    QGridLayout *jCards5;
    QLabel *jName5;
    QHBoxLayout *croupierh;
    QFrame *verticalFrame24;
    QVBoxLayout *verticalLayout_2;
    QGridLayout *croupierCards;
    QLabel *croupierName;
    QHBoxLayout *j3h;
    QVBoxLayout *verticalLayout_10;
    QGridLayout *jCards3;
    QLabel *jName3;
    QLabel *comm_lab;
    QHBoxLayout *j2h;
    QFrame *verticalFrame25;
    QVBoxLayout *verticalLayout_4;
    QGridLayout *jCards2;
    QLabel *jName2;
    QFrame *verticalFrame_2;
    QVBoxLayout *verticalLayout_6;
    QFrame *horizontalFrame_17;
    QHBoxLayout *horizontalLayout_23;
    QSpacerItem *horizontalSpacer_2;
    QPushButton *ButtonAdd;
    QTextEdit *betAmountText;
    QSpacerItem *horizontalSpacer;
    QFrame *frame2;
    QHBoxLayout *horizontalLayout_19;
    QHBoxLayout *j4h;
    QVBoxLayout *verticalLayout_11;
    QGridLayout *jCards4;
    QLabel *jName4;
    QFrame *frame;
    QHBoxLayout *horizontalLayout_12;
    QHBoxLayout *j6h;
    QVBoxLayout *verticalLayout_13;
    QGridLayout *jCards6;
    QLabel *jName6;
    QFrame *horizontalFrame_6;
    QHBoxLayout *horizontalLayout_13;
    QPushButton *drawBtn;
    QPushButton *stayBtn;
    QFrame *horizontalFrame;
    QHBoxLayout *horizontalLayout;
    QLabel *your_bet_label;
    QLabel *valueBet;
    QLabel *label_4;
    QLabel *valueBankLabel;
    QPushButton *Add_fundsButton;

    void setupUi(QWidget *black_jack)
    {
        if (black_jack->objectName().isEmpty())
            black_jack->setObjectName(QString::fromUtf8("black_jack"));
        black_jack->resize(1503, 863);
        QPalette palette;
        black_jack->setPalette(palette);
        black_jack->setAutoFillBackground(false);
        gridFrame = new QFrame(black_jack);
        gridFrame->setObjectName(QString::fromUtf8("gridFrame"));
        gridFrame->setGeometry(QRect(70, 30, 1261, 651));
        gridLayout_2 = new QGridLayout(gridFrame);
        gridLayout_2->setObjectName(QString::fromUtf8("gridLayout_2"));
        verticalFrame27 = new QFrame(gridFrame);
        verticalFrame27->setObjectName(QString::fromUtf8("verticalFrame27"));
        verticalFrame27->setMaximumSize(QSize(16777215, 120));
        verticalLayout = new QVBoxLayout(verticalFrame27);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));

        gridLayout_2->addWidget(verticalFrame27, 2, 0, 1, 5);

        j7h = new QHBoxLayout();
        j7h->setObjectName(QString::fromUtf8("j7h"));
        verticalLayout_12 = new QVBoxLayout();
        verticalLayout_12->setObjectName(QString::fromUtf8("verticalLayout_12"));
        jCards7 = new QGridLayout();
        jCards7->setObjectName(QString::fromUtf8("jCards7"));

        verticalLayout_12->addLayout(jCards7);

        jName7 = new QLabel(gridFrame);
        jName7->setObjectName(QString::fromUtf8("jName7"));
        jName7->setMaximumSize(QSize(16777215, 15));
        QFont font;
        font.setPointSize(12);
        jName7->setFont(font);
        jName7->setAlignment(Qt::AlignCenter);

        verticalLayout_12->addWidget(jName7);


        j7h->addLayout(verticalLayout_12);


        gridLayout_2->addLayout(j7h, 6, 0, 1, 1);

        j1h = new QHBoxLayout();
        j1h->setObjectName(QString::fromUtf8("j1h"));
        verticalFrame23 = new QFrame(gridFrame);
        verticalFrame23->setObjectName(QString::fromUtf8("verticalFrame23"));
        verticalFrame23->setMinimumSize(QSize(350, 0));
        verticalLayout_3 = new QVBoxLayout(verticalFrame23);
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        jCards1 = new QGridLayout();
        jCards1->setObjectName(QString::fromUtf8("jCards1"));

        verticalLayout_3->addLayout(jCards1);

        jName1 = new QLabel(verticalFrame23);
        jName1->setObjectName(QString::fromUtf8("jName1"));
        jName1->setMaximumSize(QSize(16777215, 15));
        QFont font1;
        font1.setPointSize(11);
        jName1->setFont(font1);
        jName1->setAlignment(Qt::AlignCenter);

        verticalLayout_3->addWidget(jName1);


        j1h->addWidget(verticalFrame23);


        gridLayout_2->addLayout(j1h, 0, 0, 1, 1);

        frame_6 = new QFrame(gridFrame);
        frame_6->setObjectName(QString::fromUtf8("frame_6"));
        frame_6->setMinimumSize(QSize(0, 150));
        frame_6->setMaximumSize(QSize(16777215, 130));
        horizontalLayout_20 = new QHBoxLayout(frame_6);
        horizontalLayout_20->setObjectName(QString::fromUtf8("horizontalLayout_20"));

        gridLayout_2->addWidget(frame_6, 0, 1, 1, 1);

        j5h = new QHBoxLayout();
        j5h->setObjectName(QString::fromUtf8("j5h"));
        verticalLayout_14 = new QVBoxLayout();
        verticalLayout_14->setObjectName(QString::fromUtf8("verticalLayout_14"));
        jCards5 = new QGridLayout();
        jCards5->setObjectName(QString::fromUtf8("jCards5"));

        verticalLayout_14->addLayout(jCards5);

        jName5 = new QLabel(gridFrame);
        jName5->setObjectName(QString::fromUtf8("jName5"));
        jName5->setMaximumSize(QSize(16777215, 15));
        jName5->setFont(font);
        jName5->setAlignment(Qt::AlignCenter);

        verticalLayout_14->addWidget(jName5);


        j5h->addLayout(verticalLayout_14);


        gridLayout_2->addLayout(j5h, 6, 4, 1, 1);

        croupierh = new QHBoxLayout();
        croupierh->setObjectName(QString::fromUtf8("croupierh"));
        verticalFrame24 = new QFrame(gridFrame);
        verticalFrame24->setObjectName(QString::fromUtf8("verticalFrame24"));
        verticalFrame24->setMinimumSize(QSize(350, 150));
        verticalLayout_2 = new QVBoxLayout(verticalFrame24);
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        croupierCards = new QGridLayout();
        croupierCards->setObjectName(QString::fromUtf8("croupierCards"));

        verticalLayout_2->addLayout(croupierCards);

        croupierName = new QLabel(verticalFrame24);
        croupierName->setObjectName(QString::fromUtf8("croupierName"));
        croupierName->setMaximumSize(QSize(16777215, 15));
        croupierName->setFont(font);
        croupierName->setAlignment(Qt::AlignCenter);

        verticalLayout_2->addWidget(croupierName);


        croupierh->addWidget(verticalFrame24);


        gridLayout_2->addLayout(croupierh, 0, 2, 1, 1);

        j3h = new QHBoxLayout();
        j3h->setObjectName(QString::fromUtf8("j3h"));
        verticalLayout_10 = new QVBoxLayout();
        verticalLayout_10->setObjectName(QString::fromUtf8("verticalLayout_10"));
        jCards3 = new QGridLayout();
        jCards3->setObjectName(QString::fromUtf8("jCards3"));

        verticalLayout_10->addLayout(jCards3);

        jName3 = new QLabel(gridFrame);
        jName3->setObjectName(QString::fromUtf8("jName3"));
        jName3->setMaximumSize(QSize(16777215, 15));
        jName3->setFont(font);
        jName3->setAlignment(Qt::AlignCenter);

        verticalLayout_10->addWidget(jName3);


        j3h->addLayout(verticalLayout_10);


        gridLayout_2->addLayout(j3h, 3, 0, 2, 1);

        comm_lab = new QLabel(gridFrame);
        comm_lab->setObjectName(QString::fromUtf8("comm_lab"));
        comm_lab->setMinimumSize(QSize(0, 75));
        comm_lab->setMaximumSize(QSize(16777215, 75));
        QFont font2;
        font2.setPointSize(18);
        comm_lab->setFont(font2);
        comm_lab->setScaledContents(false);
        comm_lab->setAlignment(Qt::AlignCenter);

        gridLayout_2->addWidget(comm_lab, 3, 2, 1, 1);

        j2h = new QHBoxLayout();
        j2h->setSpacing(0);
        j2h->setObjectName(QString::fromUtf8("j2h"));
        j2h->setSizeConstraint(QLayout::SetMaximumSize);
        verticalFrame25 = new QFrame(gridFrame);
        verticalFrame25->setObjectName(QString::fromUtf8("verticalFrame25"));
        verticalFrame25->setMinimumSize(QSize(350, 0));
        verticalLayout_4 = new QVBoxLayout(verticalFrame25);
        verticalLayout_4->setObjectName(QString::fromUtf8("verticalLayout_4"));
        jCards2 = new QGridLayout();
        jCards2->setObjectName(QString::fromUtf8("jCards2"));

        verticalLayout_4->addLayout(jCards2);

        jName2 = new QLabel(verticalFrame25);
        jName2->setObjectName(QString::fromUtf8("jName2"));
        jName2->setMaximumSize(QSize(16777215, 15));
        jName2->setFont(font);
        jName2->setAlignment(Qt::AlignCenter);

        verticalLayout_4->addWidget(jName2);


        j2h->addWidget(verticalFrame25);


        gridLayout_2->addLayout(j2h, 0, 4, 1, 1);

        verticalFrame_2 = new QFrame(gridFrame);
        verticalFrame_2->setObjectName(QString::fromUtf8("verticalFrame_2"));
        verticalFrame_2->setMaximumSize(QSize(16777215, 120));
        verticalLayout_6 = new QVBoxLayout(verticalFrame_2);
        verticalLayout_6->setObjectName(QString::fromUtf8("verticalLayout_6"));
        horizontalFrame_17 = new QFrame(verticalFrame_2);
        horizontalFrame_17->setObjectName(QString::fromUtf8("horizontalFrame_17"));
        horizontalFrame_17->setMaximumSize(QSize(16777215, 60));
        horizontalLayout_23 = new QHBoxLayout(horizontalFrame_17);
        horizontalLayout_23->setObjectName(QString::fromUtf8("horizontalLayout_23"));
        horizontalSpacer_2 = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_23->addItem(horizontalSpacer_2);

        ButtonAdd = new QPushButton(horizontalFrame_17);
        ButtonAdd->setObjectName(QString::fromUtf8("ButtonAdd"));
        ButtonAdd->setFont(font1);

        horizontalLayout_23->addWidget(ButtonAdd);

        betAmountText = new QTextEdit(horizontalFrame_17);
        betAmountText->setObjectName(QString::fromUtf8("betAmountText"));
        betAmountText->setEnabled(true);
        betAmountText->setMaximumSize(QSize(200, 80));
        betAmountText->setInputMethodHints(Qt::ImhDigitsOnly|Qt::ImhFormattedNumbersOnly|Qt::ImhMultiLine);

        horizontalLayout_23->addWidget(betAmountText);

        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_23->addItem(horizontalSpacer);


        verticalLayout_6->addWidget(horizontalFrame_17);


        gridLayout_2->addWidget(verticalFrame_2, 5, 0, 1, 5);

        frame2 = new QFrame(gridFrame);
        frame2->setObjectName(QString::fromUtf8("frame2"));
        frame2->setMinimumSize(QSize(0, 150));
        frame2->setMaximumSize(QSize(16777215, 130));
        horizontalLayout_19 = new QHBoxLayout(frame2);
        horizontalLayout_19->setObjectName(QString::fromUtf8("horizontalLayout_19"));

        gridLayout_2->addWidget(frame2, 6, 1, 1, 1);

        j4h = new QHBoxLayout();
        j4h->setObjectName(QString::fromUtf8("j4h"));
        verticalLayout_11 = new QVBoxLayout();
        verticalLayout_11->setObjectName(QString::fromUtf8("verticalLayout_11"));
        jCards4 = new QGridLayout();
        jCards4->setObjectName(QString::fromUtf8("jCards4"));

        verticalLayout_11->addLayout(jCards4);

        jName4 = new QLabel(gridFrame);
        jName4->setObjectName(QString::fromUtf8("jName4"));
        jName4->setMaximumSize(QSize(16777215, 15));
        jName4->setFont(font);
        jName4->setAlignment(Qt::AlignCenter);

        verticalLayout_11->addWidget(jName4);


        j4h->addLayout(verticalLayout_11);


        gridLayout_2->addLayout(j4h, 3, 4, 2, 1);

        frame = new QFrame(gridFrame);
        frame->setObjectName(QString::fromUtf8("frame"));
        frame->setMinimumSize(QSize(0, 150));
        horizontalLayout_12 = new QHBoxLayout(frame);
        horizontalLayout_12->setObjectName(QString::fromUtf8("horizontalLayout_12"));

        gridLayout_2->addWidget(frame, 3, 1, 2, 1);

        j6h = new QHBoxLayout();
        j6h->setObjectName(QString::fromUtf8("j6h"));
        verticalLayout_13 = new QVBoxLayout();
        verticalLayout_13->setObjectName(QString::fromUtf8("verticalLayout_13"));
        jCards6 = new QGridLayout();
        jCards6->setObjectName(QString::fromUtf8("jCards6"));

        verticalLayout_13->addLayout(jCards6);

        jName6 = new QLabel(gridFrame);
        jName6->setObjectName(QString::fromUtf8("jName6"));
        jName6->setMaximumSize(QSize(16777215, 15));
        jName6->setFont(font);
        jName6->setAlignment(Qt::AlignCenter);

        verticalLayout_13->addWidget(jName6);


        j6h->addLayout(verticalLayout_13);


        gridLayout_2->addLayout(j6h, 6, 2, 1, 1);

        horizontalFrame_6 = new QFrame(gridFrame);
        horizontalFrame_6->setObjectName(QString::fromUtf8("horizontalFrame_6"));
        horizontalFrame_6->setMinimumSize(QSize(0, 55));
        horizontalFrame_6->setMaximumSize(QSize(16777215, 55));
        horizontalLayout_13 = new QHBoxLayout(horizontalFrame_6);
        horizontalLayout_13->setObjectName(QString::fromUtf8("horizontalLayout_13"));
        drawBtn = new QPushButton(horizontalFrame_6);
        drawBtn->setObjectName(QString::fromUtf8("drawBtn"));
        drawBtn->setMinimumSize(QSize(0, 40));
        drawBtn->setFont(font2);

        horizontalLayout_13->addWidget(drawBtn);

        stayBtn = new QPushButton(horizontalFrame_6);
        stayBtn->setObjectName(QString::fromUtf8("stayBtn"));
        stayBtn->setMinimumSize(QSize(0, 40));
        stayBtn->setFont(font2);

        horizontalLayout_13->addWidget(stayBtn);


        gridLayout_2->addWidget(horizontalFrame_6, 4, 2, 1, 1);

        horizontalFrame = new QFrame(black_jack);
        horizontalFrame->setObjectName(QString::fromUtf8("horizontalFrame"));
        horizontalFrame->setGeometry(QRect(710, 690, 631, 71));
        QPalette palette1;
        horizontalFrame->setPalette(palette1);
        horizontalLayout = new QHBoxLayout(horizontalFrame);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        your_bet_label = new QLabel(horizontalFrame);
        your_bet_label->setObjectName(QString::fromUtf8("your_bet_label"));
        QFont font3;
        font3.setPointSize(16);
        your_bet_label->setFont(font3);

        horizontalLayout->addWidget(your_bet_label);

        valueBet = new QLabel(horizontalFrame);
        valueBet->setObjectName(QString::fromUtf8("valueBet"));
        QFont font4;
        font4.setPointSize(15);
        valueBet->setFont(font4);

        horizontalLayout->addWidget(valueBet);

        label_4 = new QLabel(horizontalFrame);
        label_4->setObjectName(QString::fromUtf8("label_4"));
        label_4->setFont(font3);

        horizontalLayout->addWidget(label_4);

        valueBankLabel = new QLabel(horizontalFrame);
        valueBankLabel->setObjectName(QString::fromUtf8("valueBankLabel"));
        valueBankLabel->setFont(font4);

        horizontalLayout->addWidget(valueBankLabel, 0, Qt::AlignHCenter);

        Add_fundsButton = new QPushButton(horizontalFrame);
        Add_fundsButton->setObjectName(QString::fromUtf8("Add_fundsButton"));
        Add_fundsButton->setEnabled(true);
        Add_fundsButton->setMinimumSize(QSize(100, 0));
        QFont font5;
        font5.setPointSize(13);
        Add_fundsButton->setFont(font5);

        horizontalLayout->addWidget(Add_fundsButton);


        retranslateUi(black_jack);

        QMetaObject::connectSlotsByName(black_jack);
    } // setupUi

    void retranslateUi(QWidget *black_jack)
    {
        black_jack->setWindowTitle(QCoreApplication::translate("black_jack", "black_jack", nullptr));
        jName7->setText(QString());
        jName1->setText(QString());
        jName5->setText(QString());
        croupierName->setText(QCoreApplication::translate("black_jack", "CROUPIER", nullptr));
        jName3->setText(QString());
        comm_lab->setText(QCoreApplication::translate("black_jack", "TextLabel", nullptr));
        jName2->setText(QString());
        ButtonAdd->setText(QCoreApplication::translate("black_jack", "Add bet", nullptr));
        jName4->setText(QString());
        jName6->setText(QString());
        drawBtn->setText(QCoreApplication::translate("black_jack", "Draw", nullptr));
        stayBtn->setText(QCoreApplication::translate("black_jack", "Stay", nullptr));
        your_bet_label->setText(QCoreApplication::translate("black_jack", "Your Bet :", nullptr));
        valueBet->setText(QCoreApplication::translate("black_jack", "0", nullptr));
        label_4->setText(QCoreApplication::translate("black_jack", "Your Account :", nullptr));
        valueBankLabel->setText(QCoreApplication::translate("black_jack", "500", nullptr));
        Add_fundsButton->setText(QCoreApplication::translate("black_jack", "ADD FUNDS", nullptr));
    } // retranslateUi

};

namespace Ui {
    class black_jack: public Ui_black_jack {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BLACK_JACK_H
