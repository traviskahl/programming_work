#ifndef TEXTURE_HPP
#define TEXTURE_HPP

#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

class Texture {
private:
	float* m_coords;
	unsigned m_width;
	unsigned m_height;
	unsigned m_numChannels;

public:
	Texture(const std::string& path) {

	}
};

#endif