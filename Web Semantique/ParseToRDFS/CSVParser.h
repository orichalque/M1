/* 
 * File:   CSVParser.h
 * Author: vandorallen
 *
 * Created on 26 octobre 2015, 16:54
 */

#ifndef CSVPARSER_H
#define	CSVPARSER_H
#include "Parser.h"

class CSVParser:Parser {
public:
    CSVParser();
    CSVParser(const CSVParser& orig);
    virtual ~CSVParser();

private:

};

#endif	/* CSVPARSER_H */

