/**
 * \file Reader.cpp
 * \brief Class implementation
 * \author T. Béziers la Fosse
 * \version 0.1
 * \date 20/10/2015
 *
 * Class used to read a file and extract datas
 *
 */
#include "Reader.h"
using namespace std;

Reader::Reader():title(""), subtitle(""), note("") {
	// TODO Auto-generated constructor stub
}


string Reader::read(char* fileName) {
	ifstream file (fileName);
	string line;
	string fileText("");
	if (file.is_open()){
		//Reading of the file to extract text
		while (getline (file, line)) {
			fileText += (line+"\n");
			if (line.at(0) == '>') {
				//KeyWord
				switch (line.at(1)){
					case 'T':
						//Won't check if first word is "TITLE"
						title = line.substr(7);
						break;
					case 'S':

						subtitle = line.substr(10);
						break;
					case 'N':

						note = line.substr(6);
						break;
					default:

						break;
				}
			} else {
				//Parsing of the line to extract informations
				istringstream parser(line);
				string word;
				double value;
				//We assume that if you don't have a ">" at the start of your line,
				//Then you can extract name & value datas
				while (parser >> word) {
					names.push_back(word);
				}
				getline (file, line);
				istringstream parser2(line);
                                
				while (parser2  >> value) {
					values.push_back(value);
                                        cout << value << endl;
				}
			}
		}
		cout << fileText << endl;
		file.close();
		return fileText;
	} else {
		cout << "couldn't read the file" << endl;
		return "";
	}

}


string Reader::toString() {
	string vectorContent("");
	ostringstream strs;
	for (string s : names) {
		vectorContent+= (s+" ");
	}
	for (double d : values) {         
		vectorContent+= (to_string(d)+" ");
	}
	return (title+" "+subtitle+" "+note+" "+vectorContent);
}

Reader::~Reader() {
	// TODO Auto-generated destructor stub
}

int main() {
	Reader *r = new Reader();
	char* file = "tmp";
	r->read(file);
	cout << r -> toString() << endl;
	delete r;


}
