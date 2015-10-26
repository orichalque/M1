/* 
 * File:   Parser.cpp
 * Author: vandorallen
 * 
 * Created on 26 octobre 2015, 16:50
 */

#include "Parser.h"
using namespace std;
Parser::Parser():file("") {
 
}

Parser::Parser(const Parser& orig) {
}

Parser::~Parser() {
}

void Parser::read(std::string file){
  string line;
  ifstream myfile (file.c_str());
  if (myfile.is_open())
  {
    while ( getline (myfile,line) )
    {
      this->file += line;
    }
    myfile.close();
  }
  else {
      std::cout << "Unable to open file"; 
  }
}

bool Parser::writeRDF() {
}

string Parser::getFile() {
    return file;
}

