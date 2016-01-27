/********************************************************************************
** Form generated from reading UI file 'textfinder.ui'
**
** Created by: Qt User Interface Compiler version 4.8.6
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_TEXTFINDER_H
#define UI_TEXTFINDER_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QHBoxLayout>
#include <QtGui/QHeaderView>
#include <QtGui/QLabel>
#include <QtGui/QLineEdit>
#include <QtGui/QPushButton>
#include <QtGui/QSplitter>
#include <QtGui/QTextEdit>
#include <QtGui/QVBoxLayout>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_TextFinder
{
public:
    QSplitter *splitter_3;
    QSplitter *splitter_2;
    QSplitter *splitter;
    QWidget *widget;
    QHBoxLayout *horizontalLayout_2;
    QLabel *label_2;
    QLineEdit *fileEdit;
    QPushButton *fileButton;
    QWidget *layoutWidget;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLineEdit *lineEdit;
    QPushButton *findButton;
    QTextEdit *textEdit;
    QPushButton *pushButton;

    void setupUi(QWidget *TextFinder)
    {
        if (TextFinder->objectName().isEmpty())
            TextFinder->setObjectName(QString::fromUtf8("TextFinder"));
        TextFinder->resize(400, 300);
        splitter_3 = new QSplitter(TextFinder);
        splitter_3->setObjectName(QString::fromUtf8("splitter_3"));
        splitter_3->setGeometry(QRect(60, 10, 284, 279));
        splitter_3->setOrientation(Qt::Vertical);
        splitter_2 = new QSplitter(splitter_3);
        splitter_2->setObjectName(QString::fromUtf8("splitter_2"));
        splitter_2->setOrientation(Qt::Vertical);
        splitter = new QSplitter(splitter_2);
        splitter->setObjectName(QString::fromUtf8("splitter"));
        splitter->setOrientation(Qt::Vertical);
        widget = new QWidget(splitter);
        widget->setObjectName(QString::fromUtf8("widget"));
        horizontalLayout_2 = new QHBoxLayout(widget);
        horizontalLayout_2->setSpacing(6);
        horizontalLayout_2->setContentsMargins(11, 11, 11, 11);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        horizontalLayout_2->setContentsMargins(0, 0, 0, 0);
        label_2 = new QLabel(widget);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        horizontalLayout_2->addWidget(label_2);

        fileEdit = new QLineEdit(widget);
        fileEdit->setObjectName(QString::fromUtf8("fileEdit"));

        horizontalLayout_2->addWidget(fileEdit);

        fileButton = new QPushButton(widget);
        fileButton->setObjectName(QString::fromUtf8("fileButton"));

        horizontalLayout_2->addWidget(fileButton);

        splitter->addWidget(widget);
        layoutWidget = new QWidget(splitter);
        layoutWidget->setObjectName(QString::fromUtf8("layoutWidget"));
        verticalLayout = new QVBoxLayout(layoutWidget);
        verticalLayout->setSpacing(6);
        verticalLayout->setContentsMargins(11, 11, 11, 11);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setSpacing(6);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        label = new QLabel(layoutWidget);
        label->setObjectName(QString::fromUtf8("label"));

        horizontalLayout->addWidget(label);

        lineEdit = new QLineEdit(layoutWidget);
        lineEdit->setObjectName(QString::fromUtf8("lineEdit"));

        horizontalLayout->addWidget(lineEdit);

        findButton = new QPushButton(layoutWidget);
        findButton->setObjectName(QString::fromUtf8("findButton"));

        horizontalLayout->addWidget(findButton);


        verticalLayout->addLayout(horizontalLayout);

        splitter->addWidget(layoutWidget);
        splitter_2->addWidget(splitter);
        textEdit = new QTextEdit(splitter_2);
        textEdit->setObjectName(QString::fromUtf8("textEdit"));
        splitter_2->addWidget(textEdit);
        splitter_3->addWidget(splitter_2);
        pushButton = new QPushButton(splitter_3);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));
        splitter_3->addWidget(pushButton);

        retranslateUi(TextFinder);

        QMetaObject::connectSlotsByName(TextFinder);
    } // setupUi

    void retranslateUi(QWidget *TextFinder)
    {
        TextFinder->setWindowTitle(QApplication::translate("TextFinder", "TextFinder", 0, QApplication::UnicodeUTF8));
        label_2->setText(QApplication::translate("TextFinder", "FileName", 0, QApplication::UnicodeUTF8));
        fileButton->setText(QApplication::translate("TextFinder", "Open", 0, QApplication::UnicodeUTF8));
        label->setText(QApplication::translate("TextFinder", "KeyWord", 0, QApplication::UnicodeUTF8));
        findButton->setText(QApplication::translate("TextFinder", "Find", 0, QApplication::UnicodeUTF8));
        pushButton->setText(QApplication::translate("TextFinder", "close", 0, QApplication::UnicodeUTF8));
    } // retranslateUi

};

namespace Ui {
    class TextFinder: public Ui_TextFinder {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_TEXTFINDER_H
