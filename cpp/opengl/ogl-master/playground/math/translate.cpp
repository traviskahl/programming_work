#include <iostream> // for std::cout
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtx/transform.hpp> // for glm::rotate()

// this function prints out a 4x4 matrix
void printMatrix(const glm::mat4& matrix) {
	for (int row = 0; row < 4; ++row) {
		for (int col = 0; col < 4; ++col) {
			std::cout << matrix[row][col] << '\t';
		}
		std::cout << '\n';
	}	
}

// this function returns a matrix that translates a vector by 10 units in all directions
glm::mat4 getTranslate() {
	glm::mat4 translate;
	for (int count = 0; count < 4; ++count) {
		translate[count][count] = 1;
	}
	translate[0][3] = 10;
	translate[1][3] = 10;
	translate[2][3] = 10;

	return translate;
}

// this function returns a matrix that translates a vector by 2 in all directions
glm::mat4 getScale() {
	glm::mat4 scale;
	for (int count = 0; count < 3; ++count)
		scale[count][count] = 2;

	scale[3][3] = 1;

	return scale;
}

int main() {
	glm::mat4 translate = getTranslate();
	glm::mat4 scale = getScale();

	printMatrix(scale);

	return 0;
}