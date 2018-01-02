#include <iostream>
#include <fstream>
#include <vector>
#include <string>

typedef struct {
	std::string ispInfo;
	std::vector<std::string> hostList;
	std::vector<std::string> cityList;
	std::vector<float> distList;
	std::vector<float> pingList;
	std::vector<float> downList;
	std::vector<float> upList;
} connectionData;

typedef struct {
	std::string ispInfo;
	std::string commonHost;
	std::string commonCity;
	float avgDistance;
	float avgPing;
	float avgDownSpeed;
	float avgUpSpeed;
} processedData;

void getDataFromFile(connectionData& data) {
	std::string garbage; // we've got some garbage lines, let's reuse a variable
	int relativeLine = 1;
	std::string line;

	std::ifstream inputFile("speeds.log");
	while (getline(inputFile, line)) {
		
		/*	line 1: title
			line 2: garbage
			line 3: ISP IP (constant)
			line 4: garbage
			line 5: garbage
			line 6: host server name, city, distance in km, ping
			line 7: garbage
			line 8: download speed
			line 9: garbage
			line 10: upload speed
			line 11: terminator
		*/

		// get ISP information
		if (data.ispInfo.empty() && relativeLine % 11 == 3) {
			data.ispInfo = line.substr(13, line.length());
			data.ispInfo.resize(data.ispInfo.length()-3);
		}
		// get host information, this is the biggest boi
		// format: Hosted by HOST_NAME (CITY, ST) [XX.XX km]: xx.xxx ms
		else if (relativeLine % 11 == 6) {

			// first we should cut useless information
			std::string infoString = line.substr(0, line.length()-3);
			infoString = infoString.substr(10, infoString.length());

			// host name
			std::string hostString = infoString.substr(0, infoString.find("("));
			data.hostList.push_back(hostString);

			infoString = infoString.substr(hostString.length(), infoString.length()-infoString.find("(")); // get rid of processed data

			// host city and state
			std::string cityString = infoString.substr(0, infoString.find(")")+1);
			cityString = cityString.substr(1, cityString.length()-2);
			data.cityList.push_back(cityString);

			infoString = infoString.substr(cityString.length()+3, infoString.length()-infoString.find(")"));

			// distance to server
			std::string distString = infoString.substr(0, infoString.find("]")+1);
			distString = distString.substr(1, distString.length()-5);
			float dist = stof(distString);
			data.distList.push_back(dist);

			infoString = infoString.substr(distString.length()+5, infoString.length()-infoString.find("]"));

			// ping to server
			std::string pingString = infoString.substr(2, infoString.length());
			float ping = stof(pingString);
			data.pingList.push_back(ping);

			// no need to resize
		}
		// get down
		// format: Download: ...x.xx Mbit/s
		else if (relativeLine % 11 == 8) {
			std::string downLine = line.substr(10, line.length());
			downLine = downLine.substr(0, downLine.length()-7);
			float downSpeed = stof(downLine);
			data.downList.push_back(downSpeed);
		}
		// get up
		// format: Upload: ...x.xx Mbit/s
		else if (relativeLine % 11 == 10) {
			std::string upLine = line.substr(8, line.length());
			upLine = upLine.substr(0, upLine.length()-7);
			float upSpeed = stof(upLine);
			data.upList.push_back(upSpeed);
		}

		++relativeLine;
	}
	inputFile.close();
}

float average(std::vector<float>& vec) {
	float sum = 0;
	for (unsigned x = 0; x < vec.size(); ++x)
		sum += vec[x];
	return (float)sum / (float)vec.size();
}

void analyzeData(connectionData& data) {
	processedData procdata;

	// transfer ISP info: it's always the same
	procdata.ispInfo = data.ispInfo;

	// find most common host

	// find most common city

	procdata.avgDistance	= average(data.distList);
	procdata.avgPing		= average(data.pingList);
	procdata.avgDownSpeed	= average(data.downList);
	procdata.avgUpSpeed		= average(data.upList);

	printDataToFile(procdata);
}

void printDataToFile(processedData& procdata) {
	
}

int main() {
	connectionData data;
	getDataFromFile(data);
	analyzeData(data);

	return 0;
}