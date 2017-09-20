#version 330 core
out vec4 FragColor;

in vec2 TexCoord;

uniform vec3 color;
uniform sampler2D texture1;

void main() {
	//FragColor = vec4(color.r, color.g, color.b, 1.0);
	FragColor = texture(texture1, TexCoord);
}