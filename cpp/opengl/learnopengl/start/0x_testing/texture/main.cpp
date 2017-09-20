// our user-defined classes go here
// --------------------------------
#include "ShaderProgram.hpp"
#include "BufferState.hpp"

// our OpenGL classes go here
// --------------------------
#include <glad/glad.h>
#include <GLFW/glfw3.h>

// our math libraries go here
// --------------------------
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

// our C++ standard libraries go here
#include <iostream>
#include <typeinfo> // for debugging
#include <cmath>

// constants
// ---------
const unsigned int SCREEN_WIDTH 	= 600;
const unsigned int SCREEN_HEIGHT 	= 600;
const float MV_INT = 0.05f;
const float SPD_INT = 0.01f;

// this is a basic function to process input
// it just redirects most of its work
// such a lazy function smh
void processColor(float* value, bool isIncreasing);
void processInput(GLFWwindow* window, float* colors) {

	if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
		glfwSetWindowShouldClose(window, true);

	if (glfwGetKey(window, GLFW_KEY_R) == GLFW_PRESS)
		processColor(&colors[0], true);
	else if (glfwGetKey(window, GLFW_KEY_G) == GLFW_PRESS)
		processColor(&colors[1], true);
	else if (glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS)
		processColor(&colors[2], true);
	else if (glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS)
		processColor(&colors[0], false);
	else if (glfwGetKey(window, GLFW_KEY_F) == GLFW_PRESS)
		processColor(&colors[1], false);
	else if (glfwGetKey(window, GLFW_KEY_V) == GLFW_PRESS)
		processColor(&colors[2], false);

	if (glfwGetKey(window, GLFW_KEY_Z) == GLFW_PRESS)
		// we want to print them in the range of 0-255
		printf("colors are: %d %d %d\n", (int)(colors[0]*255), (int)(colors[1]*255), (int)(colors[2]*255));
}

void processColor(float* value, bool isIncreasing) {
	return; // we don't want this functionality right now
	if (isIncreasing && *value < 1.01f)
		*value += 0.01f;
	else if (*value > 0.01f) // we can already assume that isIncreasing is false here
		*value -= 0.01f;
}

void processMovement(GLFWwindow* window, float& speed) {
	if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS)
		speed += SPD_INT;
	if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS)
		speed -= SPD_INT;

	if (glfwGetKey(window, GLFW_KEY_P) == GLFW_PRESS)
		std::cout << "speed is: " << speed << '\n';
}

// this function adjusts the viewport whenever the window is adjusted
void framebuffer_size_callback(GLFWwindow* window, int width, int height) {
	glViewport(0, 0, width, height);
}

int main() {
	// first we want to initialize the GLFW state and GLAD pointers
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	GLFWwindow* window = glfwCreateWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "MovementTest", NULL, NULL);
	if (window == NULL) {
		std::cout << "Couldn't create GLFW window\n";
		glfwTerminate();
		return -1;
	}
	glfwMakeContextCurrent(window);

	// then we initialize the GLAD pointers
	if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress)) {
		std::cout << "Failed to initialize GLAD\n";
		glfwTerminate();
		return -1;
	}
	glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

	// at this point we should create our shaders
	VertexShader vShader("vShader.vs");
	FragmentShader fShader("fShader.fs");
	ShaderProgram ourProgram(vShader, fShader);

	// at this point we create our vertex data
	// ---------------------------------------
	/*float vertices[] = {
		 0.2f,  0.2f, 0.0f,  // top right
		 0.2f, -0.2f, 0.0f,  // bottom right
		-0.2f, -0.2f, 0.0f,  // bottom left
		-0.2f,  0.2f, 0.0f   // top left
	};
	unsigned int indices[] = {  // note that we start from 0!
		0, 1, 3,  // first Triangle
		1, 2, 3   // second Triangle
	};*/

	float vertices[] = {
		 0.0f,  0.5f, 0.0f,
		-0.5f,  0.0f, 0.0f,
		 0.5f,  0.0f, 0.0f,
		 0.0f, -0.5f, 0.0f
	};
	unsigned int indices[] = {
		0, 1, 2,
		1, 2, 3
	};

	BufferState ourState(vertices, sizeof(vertices)/sizeof(vertices[0]), indices, sizeof(indices)/sizeof(indices[0]));
	ourState.addAttribute(0, 3, GL_FLOAT, GL_FALSE, 3*sizeof(float), 0);

	float colors[] = { 0.0f, 0.0f, 0.0f };
	glm::mat4 transform;
	float speed = 1.0f;

	while (!glfwWindowShouldClose(window)) {
		processInput(window, colors);
		processMovement(window, speed);

		glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);

		ourProgram.use();

		colors[0] = std::abs(sin(glfwGetTime() / 2));
		colors[1] = std::abs(sin(glfwGetTime() / 3));
		colors[2] = std::abs(sin(glfwGetTime() / 5));

		ourProgram.setFloat("rVal", colors[0]);
		ourProgram.setFloat("gVal", colors[1]);
		ourProgram.setFloat("bVal", colors[2]);

		glm::mat4 transform;
		transform = glm::translate(transform, glm::vec3(sin(glfwGetTime() * speed) / 3, cos(glfwGetTime() * speed) / 3, 0.0f));
		ourProgram.setMat4("transform", transform);

		glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	return 0;
}