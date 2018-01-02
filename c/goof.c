#include <stdio.h>
#include <stdlib.h>

int main() {
	int* arr = (int*) malloc(5 * sizeof(int));
	for (int x = 0; x < 5; ++x) {
		arr[x] = x;
		printf("%d ", arr[x]);
	}

	return 0;
}
