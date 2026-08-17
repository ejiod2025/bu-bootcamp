#include <stdio.h>

void print_math(int a, int b) {
    printf("Sum: %d\n", a + b);
    printf("Product: %d\n", a * b);
}

int main(void) {
    int first;
    int second;

    printf("Enter first number: ");
    if (scanf("%d", &first) != 1) {
        fprintf(stderr, "Invalid input. Please enter an integer.\n");
        return 1;
    }

    printf("Enter second number: ");
    if (scanf("%d", &second) != 1) {
        fprintf(stderr, "Invalid input. Please enter an integer.\n");
        return 1;
    }

    print_math(first, second);
    return 0;
}
