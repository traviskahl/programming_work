#include <stdio.h>
#include <stdlib.h>

int main() {
	int num, i, *ptr, sum = 0;

	printf("Enter number of elements: ");
	scanf("%d", &num);

	ptr = (int*) malloc(num * sizeof(int));
	if (ptr == NULL) {
		printf("Error! Memory not allocated\n");
		exit(0);
	}

	printf("Enter elements of array: ");
	for (i = 0; i < num; ++i) {
		scanf("%d", ptr + i);
		sum += *(ptr + i);
	}

	printf("Sum = %d\n", sum);
	free(ptr);
	return 0;
}