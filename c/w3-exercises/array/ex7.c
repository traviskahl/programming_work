/*
7. Write a program in C to merge two arrays of same size sorted in decending order. Go to the editor
Test Data :
Input the number of elements to be stored in the first array :3
Input 3 elements in the array :
element - 0 : 1
element - 1 : 2
element - 2 : 3
Input the number of elements to be stored in the second array :3
Input 3 elements in the array :
element - 0 : 1
element - 1 : 2
element - 2 : 3
Expected Output :
The merged array in decending order is :
3 3 2 2 1 1
*/

#include <stdio.h>
#include <stdlib.h>

void swap(int* x, int* y) {
	int temp = *x;
	*x = *y;
	*y = temp;
}

void bubbleSort(int arr[], int n) {
	int i, j;
	for (i = 0; i < n-1; ++i) {
		
	}
}

int main() {
	int first_num_elements;
	printf("Input the number of elements to be stored in the first array : ");
	scanf("%d", &first_num_elements);

	int* first_array = (int*) malloc(first_num_elements * sizeof(int));

	printf("Input %d elements in the array :\n", first_num_elements);
	for (int i = 0; i < first_num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", &first_array[i]);
	}

	int second_num_elements;
	printf("Input the number of elements to be stored in the second array : ");
	scanf("%d", &second_num_elements);

	int* second_array = (int*) malloc(second_num_elements * sizeof(int));

	printf("Input %d elements in the array :\n", second_num_elements);
	for (int i = 0; i < second_num_elements; ++i) {
		printf("element - %d : ", i);
		scanf("%d", &second_array[i]);
	}

	printf("first_array is:\n");
	for (int i = 0; i < first_num_elements; ++i)
		printf("%d ", first_array[i]);

	printf("\nsecond_array is:\n");
	for (int i = 0; i < second_num_elements; ++i)
		printf("%d ", second_array[i]);
	printf("\n");

	// merge the arrays
	int* merged_array = (int*) malloc((first_num_elements + second_num_elements) * sizeof(int));

	int i = 0;
	int j = 0;
	int k = 0;

	while (i < first_num_elements && j < second_num_elements) {
		if (first_array[i] >= second_array[j]) {
			merged_array[k] = first_array[i];
			++i;
			++k;
		}
		else {
			merged_array[k] = second_array[j];
			k++;
			j++;
		}
	}

	while (i < first_num_elements) {
		merged_array[k] = first_array[i];
		i++;
		k++;
	}

	while (j < second_num_elements) {
		merged_array[k] = second_array[j];
		j++;
		k++;
	}

	// sort the array
	//for (int i = 0; i < first_num_elements * 2; ++i)

	printf("The merged array in descending order is :\n");
	for (int i = 0; i < first_num_elements + second_num_elements; ++i)
		printf("%d ", merged_array[i]);


	printf("\n");
	free(merged_array);
	return 0;
}