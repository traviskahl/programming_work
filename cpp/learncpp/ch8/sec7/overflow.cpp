#include <iostream>
#include <cassert>

class IntArray {
private:
    int *m_array;
    int m_length;

public:
    IntArray(int length) {
        assert(length > 0);

        m_array = new int[length];
        m_length = length;
    }

    ~IntArray() {
        delete[] m_array; // no more memory leaks for you!
    }

    void setValue(int index, int value) { m_array[index] = value; }
    int& getValue(int index) { return m_array[index]; }

    int getLength() { return m_length; }
};

int main() {
    while (true) {
        IntArray ninja(1000000); // this will eventually overflow due to memory leaks
    }

    return 0;
}
