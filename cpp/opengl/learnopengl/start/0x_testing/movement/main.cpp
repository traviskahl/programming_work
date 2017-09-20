#include "ShaderProgram.hpp"
#include "BufferState.hpp"

#include <glad/glad.h>
#include <GLFW/glfw3.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>

#include <iostream>
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
void processInput(GLFWwindow* window) {

	if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
		glfwSetWindowShouldClose(window, true);
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

	GLFWwindow* window = glfwCreateWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Movement", nullptr, nullptr);
	if (window == nullptr) {
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

	while (!glfwWindowShouldClose(window)) {
		processInput(window);

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
		transform = glm::translate(transform, glm::vec3(sin(glfwGetTime()) / 3, cos(glfwGetTime()) / 3, 0.0f));
		ourProgram.setMat4("transform", transform);

		glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

		glfwSwapBuffers(window);
		glfwPollEvents();
	}
	// now we should delete our stuff
	glfwTerminate();

	return 0;
}