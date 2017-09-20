#version 330 core
out vec4 FragColor;

uniform float rVal;
uniform float gVal;
uniform float bVal;

void main() {
	FragColor = vec4(rVal, gVal, bVal, 1.0f);
}