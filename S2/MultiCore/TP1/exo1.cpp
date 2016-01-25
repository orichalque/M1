#include<iostream>
#include <chrono>
#include <thread>
#include <unistd.h>
#include<vector>
#include<random>
#include"semaphore.cpp"

enum state {
	VIDE,
	HOMME,
	FEMME
};



struct cabinet {
	state etat;
	int nbPersonnes;
	
	void afficherEtat() {
		cout << "etat: ";
		switch(etat){
			case (VIDE):
				cout << " vide ";
				break;
			case (HOMME):
				cout << " homme ";
				break;
			case (FEMME):
				cout << " femme ";
				break;
		}
		cout << " Nombre de personnes: " << nbPersonnes << endl;
	}
	
	void setCabinet(int cpt, state sta) {
		etat = sta;
		nbPersonnes = cpt;
	}
};

cabinet cab;
int compteur(0);
int duree = 1000;
Semaphore porteDesToilettes(1);

struct homme {
	bool entrer() {
		bool dedans = false;
		P(porteDesToilettes);
		if ((cab.etat == HOMME || cab.etat == VIDE) && compteur < 3) {
			cab.etat = HOMME;
			compteur ++;	
			dedans = true;	
			cout << "Un homme entre dans la salle de bain!";
			cab.afficherEtat();
		}
		cab.nbPersonnes = compteur;
		V(porteDesToilettes);
		return dedans;
	}
	
	void sortir() {
		P(porteDesToilettes);
		compteur --;
		if (!compteur) {
			cab.etat = VIDE;
		}
		cab.nbPersonnes = compteur;
		cout << "Un homme sort de la salle de bain!";
		cab.afficherEtat();
		V(porteDesToilettes);		
	}
};

struct femme {
	bool entrer() {
		bool dedans = false;
		P(porteDesToilettes);
		if ((cab.etat == FEMME || cab.etat == VIDE) && compteur < 3) {
			cab.etat = FEMME;
			compteur ++;		
			dedans = true;	
			cout << "Une femme entre dans la salle de bain!";
			cab.afficherEtat();
		}
		cab.nbPersonnes = compteur;
		V(porteDesToilettes);
		return dedans;
	}
	
	void sortir() {
		P(porteDesToilettes);
		compteur --;
		if (!compteur) {
			cab.etat = VIDE;
		}
		cab.nbPersonnes = compteur;
		cout << "Une femme sort de la salle de bain!";
		cab.afficherEtat();
		V(porteDesToilettes);
	}
};


void manAfterBeer() {
	homme h;
	while(1) {
		if (h.entrer()) {
			this_thread::sleep_for(chrono::milliseconds(rand() % 500 + 500));	
			h.sortir();
			this_thread::sleep_for(chrono::milliseconds(rand() % 500 + 500));	
		}
		
	}
}

void womanAfterBeer() {
	femme fe;
	while(1) {
		if(fe.entrer()) {
			this_thread::sleep_for(chrono::milliseconds(rand() % 500 + 500));
			fe.sortir();
			this_thread::sleep_for(chrono::milliseconds(rand() % 500 + 500));
			
		}
	}
}

int main() {
	cab.setCabinet(compteur, VIDE);
	cab.afficherEtat();
	vector<thread> threads;
	threads.push_back(thread(womanAfterBeer));
	threads.push_back(thread(manAfterBeer));
	threads.push_back(thread(manAfterBeer));
	threads.push_back(thread(womanAfterBeer));
	threads.push_back(thread(manAfterBeer));
	for (auto& t : threads) {
		t.join();
	}
	
	return 0;
}













