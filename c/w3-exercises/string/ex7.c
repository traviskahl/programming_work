/*
7. Write a program in C to count total number of alphabets, digits and special characters in a string. Go to the editor

Test Data :
Input the string : Welcome to w3resource.com

Expected Output :

Number of Alphabets in the string is : 21 
Number of Digits in the string is : 1 
Number of Special characters in the string is : 4 
*/

#include <stdio.h>
#include <ctype.h>

#define BUF_SIZE 50

int main() {
	printf("Input the string : ");
	char string[50];
	fgets(string, BUF_SIZE, stdin);

	int num_alpha = 0;
	int num_digit = 0;
	int num_specl = 0;

	char* cur_char = string;
	while (*cur_char != '\0') {
		if (isalpha(*cur_char))
			++num_alpha;
		else if (isdigit(*cur_char))
			++num_digit;
		else
			++num_specl;
		++cur_char;
	}

	printf("Number of Alphabets in the string is : %d\n", num_alpha);
	printf("Number of Digits in the string is : %d\n", num_digit);
	printf("Number of Special characters in the string is : %d\n", num_specl);

	return 0;
}