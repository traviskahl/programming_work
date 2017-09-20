#include <iostream>
#include <string>
#include <cctype>

bool inputMatches(std::string strUserInput, std::string strTemplate) {
	if (strTemplate.length() != strUserInput.length())
		return false;

	// Step through the user input to see if it matches
	for (unsigned int nIndex = 0; nIndex < strTemplate.length(); ++nIndex) {
		switch (strTemplate[nIndex]) {
			case '#': // match a digit
				if (!isdigit(strUserInput[nIndex]))
					return false;
				break;
			case '_': // match whitespace
				if (!isspace(strUserInput[nIndex]))
					return false;
				break;
			case '@': // match a letter
				if (!isalpha(strUserInput[nIndex]))
					return false;
				break;
			case '?': // match anything
				break;
			default: // match the exact character
				if (strUserInput[nIndex] != strTemplate[nIndex])
					return false;
		}
	}
	return true;
}

int main() {
	std::string strValue;

	while (1) {
		std::cout << "Enter a phone number (###) ###-####: ";
		std::getline(std::cin, strValue); // get the entire line, including spaces
		if (inputMatches(strValue, "(###) ###-####"))
			break;
	}

	std::cout << "You entered: " << strValue << std::endl;
}