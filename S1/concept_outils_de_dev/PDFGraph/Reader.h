/**
 * \file Reader.h
 * \brief File reading class declaration
 * \author T. Béziers la Fosse
 * \version 0.1
 * \date 20/10/2015
 *
 * Class used to read a file and extract datas
 *
 */

#ifndef READER_H_
#define READER_H_
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
/**
 * \class Reader
 * \brief reads a file and gather informations to be written in the PDF afterward
 */
class Reader {
public:
        /**
         * \brief Reader constructor, initializing attribute 
         *        
         */
	Reader();

        /**
         * \fn string Reader::read(char* fileName) 
         * \brief Function used to read the file and extract informations 
         * \param fileName the name of the file to be read
         * \return String containing the text readen 
         */
	std::string read(char* file);
        
        /**
        *  \fn string Reader::toString()
        *  \brief Read the attribute of the object and concatenates them in a string to be displayed
        *  \param none
        *  \return The string containing all the informations in the attributes
        */
	std::string toString();
        
        /**
         * \fn virtual ~Reader();
         * \brief reader destructor
         */
	virtual ~Reader();

protected:

	std::string title; /*! Title of the graph to be displayed later*/
	std::string subtitle; /*! Subtitle of the graph to be displayed later*/
	std::string note; /*! Some optionnal note about the graph to be displayed later*/
	std::vector<std::string> names; /*! First row of the datas in the file readen*/
	std::vector<double> values; /*! Second row with the data corresponding to the name*/
};

#endif /* READER_H_ */
