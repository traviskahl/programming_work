#include <iostream>
#include <glad/glad.h>
#include <GLFW/glfw3.h>

void framebuffer_size_callback(GLFWwindow* window, int width, int height) {
	glViewport(0, 0, width, height);
}

void processInput(GLFWwindow* window) {
	if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
		glfwSetWindowShouldClose(window, true);
}

void incrementColor(float* color, bool isUp) {
	if (isUp && *color < 1.0f)
		*color += 0.01f;
	else if (!isUp && *color > 0.0f)
		*color -=0.01f;
}

void processColor(GLFWwindow* window, float* pRed, float* pGreen, float* pBlue) {
	if (glfwGetKey(window, GLFW_KEY_R) == GLFW_PRESS)
		incrementColor(pRed, true);
	else if (glfwGetKey(window, GLFW_KEY_G) == GLFW_PRESS)
		incrementColor(pGreen, true);
	else if (glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS)
		incrementColor(pBlue, true);
	else if (glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS)
		incrementColor(pRed, false);
	else if (glfwGetKey(window, GLFW_KEY_F) == GLFW_PRESS)
		incrementColor(pGreen, false);
	else if (glfwGetKey(window, GLFW_KEY_V) == GLFW_PRESS)
		incrementColor(pBlue, false);
}

int main() {
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	GLFWwindow* window = glfwCreateWindow(800, 600, "LearnOpenGL", NULL, NULL);
	if (window == NULL) {
		std::cout << "Failed to create GLFW window\n";
		glfwTerminate();
		return -1;
	}
	glfwMakeContextCurrent(window);

	if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress)) {
		std::cout << "Failed to initialize GLAD" << std::endl;
		return -1;
	}

	glViewport(0, 0, 800, 600);
	glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

	/*float red = 0.0f;
	float green = 0.0f;
	float blue = 0.0f;

	float* pRed = &red;
	float* pGreen = &green;
	float* pBlue = &blue;*/

	float* pRed = new float;
	float* pGreen = new float;
	float* pBlue = new float;

	*pRed = 0.0f;
	*pGreen = 0.0f;
	*pBlue = 0.0f;

	// render loop
	while (!glfwWindowShouldClose(window)) {
		processInput(window);
		processColor(window, pRed, pGreen, pBlue);

		glClearColor(*pRed, *pGreen, *pBlue, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);

		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	delete pRed;
	delete pGreen;
	delete pBlue;

	glfwTerminate();

	return 0;
}