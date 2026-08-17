#include <stdio.h>

void swap(int *a, int *b) {
    int temporary = *a;
    *a = *b;
    *b = temporary;
}

void broken_swap(int a, int b) {
    int temporary = a;
    a = b;
    b = temporary;

    // This function receives copies, not addresses, so the caller is unchanged.
}

int main(void) {
    int x = 10;
    int y = 20;

    printf("Before broken_swap: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After broken_swap:  x = %d, y = %d (unchanged)\n\n", x, y);

    printf("Before swap: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swap:  x = %d, y = %d\n", x, y);

    return 0;
}
