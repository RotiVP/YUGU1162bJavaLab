#include <iostream>
#include <map>
#include <string>

int main(int argc, char** argv)
{
	using namespace std;
	using MyMap = map<string, string>;
	using MyPair = pair<string, string>;

	MyMap _map { 
		MyPair {"Арбуз", "Ягода"},
		MyPair {"Банан", "Трава"},
	};

	for(auto it=_map.begin(); it!=_map.end(); ++it)
		printf("%s - %s\n", it->first, it->second);
}
