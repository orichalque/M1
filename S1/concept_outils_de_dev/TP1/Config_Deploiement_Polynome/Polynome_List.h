/* 
 * File:   Polynome_List.h
 * Author: E104607D
 *
 * Created on 28 septembre 2015, 16:15
 */

#ifndef POLYNOME_LIST_H
#define	POLYNOME_LIST_H
#include "Polynome.h"

using namespace std;
class Polynome_List : public Polynome {
public:
    Polynome_List();
    Polynome_List(int degree);
    Polynome_List(const Polynome_List& orig);
    void fill(int degree);
    int resolve(int unknown);
    ~Polynome_List();
private:

};

#endif	/* POLYNOME_LIST_H */

