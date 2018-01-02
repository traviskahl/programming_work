/*
10. Write a program in C to Calculate the length of the string using a pointer. Go to the editor
Test Data :
Input a string : w3resource
Expected Output :

The length of the given string w3resource                                                                    
is : 10    
*/

#include <stdio.h>

int main() {
	char string[50];
	printf("Input a string : ");
	fgets(string, 50, stdin);

	int length = 0;
	while (string[length] != '\n' && string[length] != '\0')
		++length;

	printf("The length of the given string %s is : %d\n", string, length);
}