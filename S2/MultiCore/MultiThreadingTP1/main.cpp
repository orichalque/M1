/* 
 * File:   main.cpp
 * Author: E104607D
 *
 * Created on 26 janvier 2016, 17:06
 */

#include <cstdlib>
#include <sstream>
#include <iostream>
#include <fstream>
#include <vector>
#include <chrono>
#include <tbb/blocked_range.h>

using namespace std;

/**
 * @brief find word in dict
 * @param word
 * @param dict
 * @return true if word in dict, false in the other case
 */
bool find(string word, vector<string> dict){
    for (auto &w : dict) {
        if (word == w){
            return true;
        }
    }
    return false;
}

/**
 * @find all the words in the dict
 * @param words
 * @param dict
 * @return true if every word is in the dictionnary, false if not
 */
bool find(vector<string> words, vector<string> dict){
    int remain = words.size();
    for (auto &w : dict){
        for (auto &w2 : words) {
            if (w2 == w) {
                remain --;
            }
        }
    }
    return (remain == 0) ? true : false;
}

/**
 * @compare two words with dots in it
 * @param word
 * @param compareTo
 * @return 
 */
bool compareWord(string word, string compareTo) {
    //ABCD - A.C.
    if (word.length() != compareTo.length()){
        return false;
    } else {
        for (int i = 0; i < compareTo.length(); ++i){
            if (word.at(i) != compareTo.at(i) && word.at(i) != '.') {
                return false;
            }
        }
        return true;
    }
}
/**
 * @brief find an incomlpete word in the dictionnary, s..d.f for sandef for example
 * @param word
 * @param dict
 * @return all the occurences
 */
vector<string> findWordIncomplete(string word, vector<string> dict) {
    vector<string> solutions;
    for (auto w : dict){
        if (compareWord(word, w)){
            solutions.push_back(w);
        }
    }
    if (solutions.empty()){
        cout << "no solutions" << endl;
    } else {
        for (auto w2 : solutions){
            cout << w2 << endl;
        }
    }
    return solutions;
}

/*
 * 
 */
int main(int argc, char** argv) {
    //We dont need the reading time in the timer
    ifstream infile("sowpods.txt");
    string line;
    vector<string> dictionnary;
    while (getline(infile, line)){
        dictionnary.push_back(line);
    }
    
    //compteur
    auto begin = std::chrono::high_resolution_clock::now();
    
    if (argc > 1) {
        cout << argv[1] << " est-il présent? " << endl;
        findWordIncomplete(argv[1], dictionnary);
    } else {
        cout << "Entrez un argument" << endl;
    }
    
    auto end = std::chrono::high_resolution_clock::now();
    std::cout << std::chrono::duration_cast<std::chrono::milliseconds>(end-begin).count() << "ms" << std::endl;
   
    
    return EXIT_SUCCESS;
}

