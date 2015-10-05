/* 
 * File:   Polynome_Tab.h
 * Author: E104607D
 *
 * Created on 28 septembre 2015, 16:14
 */

#ifndef POLYNOME_TAB_H
#define	POLYNOME_TAB_H
#include "Polynome.h"
#include <vector>

class Polynome_Tab : public Polynome {
public:
    Polynome_Tab();
    Polynome_Tab(int degree);
    Polynome_Tab(const Polynome_Tab& orig);
    int resolve(int unknown);
    void fill(int degree);
    ~Polynome_Tab();
private:
    int size; //degree
    std::vector<int> coefs;
};

#endif	/* POLYNOME_TAB_H */

