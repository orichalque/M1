/* 
 * File:   Polynome_Tab.cpp
 * Author: E104607D
 * 
 * Created on 28 septembre 2015, 16:14
 */

#include "Polynome_Tab.h"
#include <iostream>
using namespace std;

Polynome_Tab::Polynome_Tab() {
    coefs.resize(1);
    int coef;
    cout << "Entrez le coef" << endl;
    cin >> coef;
    size = 0;
}

Polynome_Tab::Polynome_Tab(int degree) {
    coefs.resize(degree);
    size = degree;
    int coef;
    for (int i = 0; i <= degree; ++i) {
        cout << "Coefficient de x^"<<(degree-i) << endl; 
        cin >> coef;
        this->coefs.push_back(coef);
    }
}

Polynome_Tab::Polynome_Tab(const Polynome_Tab& orig) {
}

Polynome_Tab::~Polynome_Tab() {
}

int Polynome_Tab::resolve(int unknown) {
    if (size == 0) {
        return coefs.at(0);
    } 
    int result(coefs.at(0)*unknown+coefs.at(1));
    for (int i = 2; i <= this->size; ++i) {
        result = result*unknown + coefs.at(i);
    }
    return result;
}

void Polynome_Tab::fill(int degree){
    coefs.resize(degree+1);
    int coef;
    for (int i = 0; i <= degree; ++i) {
        cout << "Coefficient de x^"<<(degree-i) << endl; 
        cin >> coef;
        this->coefs.push_back(coef);
    }
}


