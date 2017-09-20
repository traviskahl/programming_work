#include <iostream>
#include <cassert>

class Stack {
    int m_elements[10];
    int m_length;

public:
    void reset() {
        m_length = 0;
        for (int &x : m_elements)
            x = 0;
    }

    bool push(int element) {
        if (m_length > 10)
            return false;

        m_elements[m_length++] = element;
        return true;
    }

    int pop() {
        assert(m_length > 0 && "Stack is empty");
        return m_elements[--m_length]; // possible error here?
    }

    void print() {
        std::cout << "( ";
        for (int x = 0; x < m_length; x++) {
            std::cout << m_elements[x] << ' ';
        }
        std::cout << ")\n";
    }

};

int main() {
    Stack stack;
    stack.reset();

    stack.print();

    stack.push(5);
    stack.push(3);
    stack.push(8);
    stack.print();

    stack.pop();
    stack.print();

    stack.pop();
    stack.pop();

    stack.print();
}