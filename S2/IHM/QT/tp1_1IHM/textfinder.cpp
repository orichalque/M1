#include "textfinder.h"
#include "ui_textfinder.h"
#include <QFile>
#include <QTextStream>

TextFinder::TextFinder(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::TextFinder)
{
    ui->setupUi(this);
    //Load the file on loading
    loadTextFile();
}

TextFinder::~TextFinder()
{
    delete ui;
}

void TextFinder::on_findButton_clicked()
{
    //recupere le champs lineEdit dans la string searchString
    QString searchString = ui->lineEdit->text();
    //cherche dans le text textEdit la string searchString
    ui->textEdit->find(searchString, QTextDocument::FindWholeWords);
}

void TextFinder::on_fileButton_clicked()
{
    QString fileString = ui -> fileEdit -> text();
    loadTextFile(fileString);
}

void TextFinder::loadTextFile(QString fileString) {
    //Ouverture de input.txt en mode lecture
    QFile inputFile(fileString);
    inputFile.open(QIODevice::ReadOnly);

    //Creation d'un inputStream avec le fichier en parametre
    QTextStream in(&inputFile);
    //Lecture du fichier dans une string
    QString line = in.readAll();
    inputFile.close();
    //Fermeture de l'inputFile

    //Affichage de la string dans l'UI
    ui -> textEdit -> setPlainText(line);
    //Ajout d'un curseur (Access & modification text document)

    QTextCursor cursor = ui->textEdit->textCursor();
    //Move operation , MoveMode, number of time
    cursor.movePosition(QTextCursor::Start, QTextCursor::MoveAnchor, 1);
}

void TextFinder::loadTextFile(){
    //Ouverture de input.txt en mode lecture
    QFile inputFile(":/open.txt");
    inputFile.open(QIODevice::ReadOnly);

    //Creation d'un inputStream avec le fichier en parametre
    QTextStream in(&inputFile);
    //Lecture du fichier dans une string
    QString line = in.readAll();
    inputFile.close();
    //Fermeture de l'inputFile

    //Affichage de la string dans l'UI
    ui -> textEdit -> setPlainText(line);
    //Ajout d'un curseur (Access & modification text document)

    QTextCursor cursor = ui->textEdit->textCursor();
    //Move operation , MoveMode, number of time
    cursor.movePosition(QTextCursor::Start, QTextCursor::MoveAnchor, 1);

}



void TextFinder::on_pushButton_clicked()
{
    close();
}
