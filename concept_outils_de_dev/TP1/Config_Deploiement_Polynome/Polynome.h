/* 
 * File:   Polynome.h
 * Author: E104607D
 *
 * Created on 28 septembre 2015, 16:16
 */

#ifndef POLYNOME_H
#define	POLYNOME_H

class Polynome {
public:
    Polynome();
    virtual void fill(int degree) = 0;
    virtual int resolve(int unknown) = 0;
    virtual ~Polynome() = 0;
private:

};

#endif	/* POLYNOME_H */

