#include <glad/glad.h>
#include <GLFW/glfw3.h>

#include "shader.h"
#include <cmath>

#include <iostream>

void framebuffer_size_callback(GLFWwindow* window, int width, int height);
void processInput(GLFWwindow* window);
void processOffset(GLFWwindow* window, float& h, float& v);
void alterOffset(float& f, bool isIncreasing, const char purpose);
void processColor(GLFWwindow* window, float& rOffset, float& gOffset, float& bOffset);

// settings
const unsigned int SCR_WIDTH = 800;
const unsigned int SCR_HEIGHT = 600;
const float OFFSET_INC = 0.05f;
const char OFFSET_COLOR = 'c';
const char OFFSET_POS = 'p';

int main() {

	// glfw: initialize and configure
	// ------------------------------
	glfwInit();
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

#ifdef __APPLE__
	glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE); // uncomment this statement to fix compilation on OS x
#endif

	// glfw window creation
	// --------------------
	GLFWwindow* window = glfwCreateWindow(SCR_WIDTH, SCR_HEIGHT, "LearnOpenGL", NULL, NULL);
	if (window == NULL) {

		std::cout << "Failed to create GLFW window" << std::endl;
		glfwTerminate();
		return -1;
	}
	glfwMakeContextCurrent(window);
	glfwSetFramebufferSizeCallback(window, framebuffer_size_callback);

	// glad: load all OpenGL function pointers
	// ---------------------------------------
	if (!gladLoadGLLoader((GLADloadproc)glfwGetProcAddress)) {

		std::cout << "Failed to initialize GLAD" << std::endl;
		return -1;
	}

	// build and compile our shader program
	// ------------------------------------
	Shader ourShader("3.3.shader.vs", "3.3.shader.fs"); // you can name your shader files however you like

	// set up vertex data (and buffer(s)) and configure vertex attributes
	// ------------------------------------------------------------------
	float vertices[] = {
		// positions		 // colors
		 0.2f, -0.2f, 0.0f,  0.0f, 0.0f, 0.0f, 	// bottom right
		-0.2f, -0.2f, 0.0f,  0.0f, 0.0f, 0.0f,  // bottom left
		 0.0f,  0.2f, 0.0f,  0.0f, 0.0f, 0.0f   // top
	};

	//float indices[] = { 3, 4, 5, 9, 10, 11, 15, 16, 17; }

	unsigned int VBO, VAO;
	glGenVertexArrays(1, &VAO);
	glGenBuffers(1, &VBO);
	// bind the Vertex Array Object first, then bind and set vertex buffer(s), and then configure vertex attributes(s).
	glBindVertexArray(VAO);

	glBindBuffer(GL_ARRAY_BUFFER, VBO);
	glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

	// position attribute
	// change stride back to 6 if we re-enable color
	glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)0);
	glEnableVertexAttribArray(0);
	// color attribute
	glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)(3 * sizeof(float)));
	glEnableVertexAttribArray(1);

	// You can unbind the VAO afterwards so other VAO calls won't accidentally modify this VAO, but this rarely happens. Modifying other
	// VAOs requires a call to glBindVertexArray anyways so we generally don't unbind VAOs (nor VBOs) when it's not directly necessary.
	//glBindVertexArray(0);


	// render loop
	// -----------
	float hOffset = 0.0f;
	float vOffset = 0.0f;

	float rOffset = 0.0f;
	float gOffset = 0.0f;
	float bOffset = 0.0f;

	while (!glfwWindowShouldClose(window)) {

		// input
		// -----
		processInput(window);
		processOffset(window, hOffset, vOffset);
		processColor(window, rOffset, gOffset, bOffset);

		// render
		// ------
		glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);

		// render the triangle
		ourShader.use();
		// handle the offset
		ourShader.setFloat("hOffset", hOffset);
		ourShader.setFloat("vOffset", vOffset);

		// handle the color offset
		ourShader.setFloat("rOffset", rOffset);
		ourShader.setFloat("bOffset", bOffset);
		ourShader.setFloat("gOffset", gOffset);

		glBindVertexArray(VAO);
		glDrawArrays(GL_TRIANGLES, 0, 3);

		// glfw: swap buffers and poll IO events (keys pressed/released, mouse moved etc.)
		// -------------------------------------------------------------------------------
		glfwSwapBuffers(window);
		glfwPollEvents();
	}

	// optional: de-allocate all resources once they've outlived their purpose:
	// ------------------------------------------------------------------------
	glDeleteVertexArrays(1, &VAO);
	glDeleteBuffers(1, &VBO);

	// glfw: terminate, clearing all previously allocated GLFW resources:
	// ------------------------------------------------------------------
	glfwTerminate();
	return 0;
}

// process all input: query GLFW whether relevant keys are pressed/released this frame and react accordingly
// ---------------------------------------------------------------------------------------------------------
void processInput(GLFWwindow* window) {

	if (glfwGetKey(window, GLFW_KEY_ESCAPE) == GLFW_PRESS)
		glfwSetWindowShouldClose(window, true);
}

void processOffset(GLFWwindow* window, float& h, float& v) {
	if (glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS)
		alterOffset(h, false, OFFSET_POS);
	else if (glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS)
		alterOffset(h, true, OFFSET_POS);
	else if (glfwGetKey(window, GLFW_KEY_DOWN) == GLFW_PRESS)
		alterOffset(v, false, OFFSET_POS);
	else if (glfwGetKey(window, GLFW_KEY_UP) == GLFW_PRESS)
		alterOffset(v, true, OFFSET_POS);
}

void alterOffset(float& f, bool isIncreasing, const char purpose) {
	float limit = 1.0f;
	if (purpose == OFFSET_POS)
		limit = 0.8f;

	if (isIncreasing && f < limit)
		f += OFFSET_INC;
	else if (!(isIncreasing) && f > -limit)
		f -= OFFSET_INC;
}

void processColor(GLFWwindow* window, float& rOffset, float& gOffset, float& bOffset) {
	if (glfwGetKey(window, GLFW_KEY_R) == GLFW_PRESS)
		alterOffset(rOffset, true, OFFSET_COLOR);
	else if (glfwGetKey(window, GLFW_KEY_G) == GLFW_PRESS)
		alterOffset(gOffset, true, OFFSET_COLOR);
	else if (glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS)
		alterOffset(bOffset, true, OFFSET_COLOR);
	else if (glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS)
		alterOffset(rOffset, false, OFFSET_COLOR);
	else if (glfwGetKey(window, GLFW_KEY_F) == GLFW_PRESS)
		alterOffset(gOffset, false, OFFSET_COLOR);
	else if (glfwGetKey(window, GLFW_KEY_V) == GLFW_PRESS)
		alterOffset(bOffset, false, OFFSET_COLOR);
}

// glfw: whenever the window size changed (by OS or user resize) this callback function executes
// ---------------------------------------------------------------------------------------------
void framebuffer_size_callback(GLFWwindow* window, int width, int height) {

	// make sure the viewport matches the new window dimensions: note that width and
	// height will be significantly larger than specified on retina displays.
	glViewport(0, 0, width, height);
}