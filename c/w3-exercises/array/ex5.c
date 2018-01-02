/*
5. Write a program in C to count a total number of duplicate elements in an array. Go to the editor
Test Data :
Input the number of elements to be stored in the array :3
Input 3 elements in the array :
element - 0 : 5
element - 1 : 1
element - 2 : 1
Expected Output :
Total number of duplicate elements found in the array is : 1
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool isDuplicate(int* array, int length, int key, int start_index);

int main() {
	int num_elements;
	printf("Input the number of elements to be stored in the array : ");
	scanf("%d", &num_elements);

	int* input_array = (int*) malloc(num_elements * sizeof(int));

	printf("Input %d elements in the array :\n", num_elements);
	for (int i = 0; i < num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", &input_array[i]);
	}

	int duplicates_found = 0;
	for (int i = 0; i < num_elements; ++i) {
		if (isDuplicate(input_array, num_elements, input_array[i], i))
			++duplicates_found;
	}

	printf("Total number of duplicate elements found in the array is : %d\n", duplicates_found);
	free(input_array);
	return 0;
}

bool isDuplicate(int* array, int length, int key, int start_index) {
	int times_found = 0;
	for (int i = start_index; i < length; ++i) {
		if (array[i] == key)
			++times_found;
	}
	if (times_found > 1)
		return true;
	else
		return false;
}