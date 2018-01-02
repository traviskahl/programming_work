#include <stdio.h>
#include <stdlib.h>

float** createArray(int m, int n) {
	float* values = calloc(m*n, sizeof(float));
	float** rows = malloc(n * sizeof(float*));
	for (int i = 0; i < n; ++i)
		rows[i] = values + i*m;

	return rows;
}

void destroyArray(float** arr) {
	free(*arr);
	free(arr);
}

void drawLine(const float** coords, int m, int n) {
	for (int i = 0; i < m; ++i) {
		for (int j = 0; j < n; ++j) {
			printf("%f ", coords[i][j]);
		}
		printf("\n");
	}
}

int main() {
	float** arr = createArray(2, 2);
	arr[0][0] = 1;
	arr[0][1] = 1;
	arr[1][0] = 2;
	arr[1][1] = 2;
	drawLine(arr, 2, 2);
	destroyArray(arr);
}