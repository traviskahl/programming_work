#include <stdio.h>

float Q_rsqrt(float number) {
	long i;
	float x2, y;
	const float threehalfs = 1.5F;

	x2 = number * 0.5F;
	y = number;
	i = * (long *) &y;				// evil floating point bit level hacking
	i = 0x5f3759df - (i >> 1);		// what the hell?
	y = * (float *) &i;
	y = y * (threehalfs  - (x2 * y * y));		// first iteration
	y = y * (threehalfs - (x2 * y * y));		// second iteration, this can be removed
}

int main(void) {
	float a;

	printf("Enter a float value: ");
	scanf("%f", &a);
	float num = Q_rsqrt(a);
	printf("inverse sqrt is: %f\n", num);

	return 0;
}