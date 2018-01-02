/*
1. Write a program in C to input a string and print it. Go to the editor

Test Data :
Input the string : Welcome, w3resource

Expected Output :

The string you entered is : Welcome, w3resource 
*/

#include <stdio.h>

#define BUFFER_SIZE 50

int main() {
	printf("Input the string : ");
	char buffer[BUFFER_SIZE];
	fgets(buffer, BUFFER_SIZE, stdin);
	printf("The string you entered is : ");
	puts(buffer);

	return 0;
}