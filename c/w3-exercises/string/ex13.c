/*
13.Write a program in C to extract a substring from a given string. Go to the editor

Test Data :
Input the string : this is test string
Input the position to start extraction :9
Input the length of substring :4

Expected Output :

The substring retrieve from the string is : " test " 
*/

#include <stdio.h>
#include <stdlib.h>

#define BUF_SIZE 50

char* get_substring(const char* string, int offset, int length);

int main() {
	printf("Input the string : ");
	char string[BUF_SIZE];
	fgets(string, BUF_SIZE, stdin);

	int sub_start_index;
	int sub_length;

	printf("Input the position to start extraction : ");
	scanf("%d", &sub_start_index);
	printf("Input the length of the substring : ");
	scanf("%d", &sub_length);

	// make a new array for our substring
	char* sub = get_substring(string, sub_start_index-1, sub_length);

	printf("The substring retrieve from the string is : \" %s \"\n", sub);

	free(sub);
	return 0;
}

char* get_substring(const char* string, int offset, int length) {
	char* substr = (char*) malloc((length+1) * sizeof(char));
	for (int i = 0; i < length; ++i) {
		substr[i] = string[offset+i];
	}
	substr[length] = '\0';

	return substr;
}