/* 
 * File:   JSONParser.h
 * Author: vandorallen
 *
 * Created on 26 octobre 2015, 16:54
 */

#ifndef JSONPARSER_H
#define	JSONPARSER_H
#include "Parser.h"

class JSONParser: public Parser {
public:
    JSONParser();
    JSONParser(const JSONParser& orig);
    virtual ~JSONParser();
    bool writeRDF();
private:

};

#endif	/* JSONPARSER_H */

