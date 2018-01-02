/*
6. Write a program in C to compare two string without using string library functions. Go to the editor

Test Data :
Input the 1st string : This is first string
Input the 2nd string : This is first string

Expected Output :

The length of both strings are equal and
also both strings are equal.
*/

#include <stdio.h>
#include <stdbool.h>

#define BUF_SIZE 50

int get_string_length(const char* string);

int main() {
	char string1[BUF_SIZE];
	char string2[BUF_SIZE];

	printf("Input the 1st string : ");
	fgets(string1, BUF_SIZE, stdin);
	printf("Input the 2nd string : ");
	fgets(string2, BUF_SIZE, stdin);

	int len1 = get_string_length(string1);
	int len2 = get_string_length(string2);

	if (len1 != len2) {
		printf("The length of both strings are not equal\n");
		return 0;
	}
	else {
		printf("The length of both strings are equal ");
	}

	// compare their contents
	// ----------------------
	bool areEqual = true;
	// could use len2, but they're already proven to be the same at this point
	for (int i = 0; i < len1; ++i) {
		if (string1[i] != string2[i]) {
			areEqual = false;
			break;
		}
	}

	if (areEqual) {
		printf("and also both strings are equal\n");
	}
	else {
		printf("but both strings are not equal\n");
	}

	return 0;
}

int get_string_length(const char* string) {
	int length = 0;
	char* cur_char = string;

	while (*cur_char != '\0') {
		length++;
		cur_char++;
	}

	return length;
}