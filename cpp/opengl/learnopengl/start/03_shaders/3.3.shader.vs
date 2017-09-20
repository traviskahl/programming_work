#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aColor;

out vec3 ourColor;

uniform float hOffset;
uniform float vOffset;

uniform float rOffset;
uniform float gOffset;
uniform float bOffset;

void main() {
	float x = (aPos.x) + hOffset;
	float y = (aPos.y) + vOffset;
	float z = (aPos.z);
	gl_Position = vec4(x, y, z, 1.0);

	float r = aColor.r + rOffset;
	float g = aColor.g + gOffset;
	float b = aColor.b + bOffset;
	ourColor = vec3(r, g, b);
}