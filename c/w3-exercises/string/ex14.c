/*
14.Write a C program to check whether a given substring is present in the given string. Go to the editor

Test Data :
Input the string : This is a test string.
Input the substring to be search : search

Expected Output :

The substring is not exists in the string.
*/

#include <stdio.h>
#include <stdbool.h>

#define BUF_SIZE 50

int main() {
	printf("Input the string : ");
	char master[BUF_SIZE];
	fgets(master, BUF_SIZE, stdin);

	printf("Input the substring to be search : ");
	char substr[BUF_SIZE];
	fgets(substr, BUF_SIZE, stdin);

	// get some information about our strings
	int length_master = 0;
	char* cur_char = master;
	while (*cur_char != '\0' && *cur_char != '\n') {
		++length_master;
		++cur_char;
	}

	int length_substr = 0;
	cur_char = substr;
	while (*cur_char != '\0' && *cur_char != '\n') {
		++length_substr;
		++cur_char;
	}

	// find the substring
	// ------------------
	
}