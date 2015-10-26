/* 
 * File:   Parser.h
 * Author: vandorallen
 *
 * Created on 26 octobre 2015, 16:50
 */


#ifndef PARSER_H
#define	PARSER_H

#include <iostream>
#include <fstream>
#include <regex>
#include <string>


class Parser {
public:
    Parser();
    Parser(const Parser& orig);
    virtual ~Parser();
    virtual void read(std::string file);
    virtual bool writeRDF() = 0;
    virtual std::string getFile();
protected:
    std::string file;
};

#endif	/* PARSER_H */

