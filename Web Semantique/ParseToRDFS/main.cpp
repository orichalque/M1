/* 
 * File:   main.cpp
 * Author: vandorallen
 *
 * Created on 26 octobre 2015, 16:49
 */

#include <cstdlib>

#include "JSONParser.h"
#include "Parser.h"
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    Parser *p = new JSONParser();
    p->read("file.json");
    cout << p->getFile();
    return 0;
}

