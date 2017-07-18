import com.bugvm.javacpp.accelerate;

public class ExampleDGEMMrowmajor {
    /* Auxiliary routine: printing a matrix */
    static void print_matrix_rowmajor(String desc, int m, int n, double[] mat, int ldm) {
        int i, j;
        System.out.printf("\n %s\n", desc);

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) System.out.printf(" %6.2f", mat[i*ldm+j]);
            System.out.printf("\n");
        }
    }


    /* Auxiliary routine: printing a matrix */
    static void print_matrix_colmajor(String desc, int m, int n, double[] mat, int ldm) {
        int i, j;
        System.out.printf("\n %s\n", desc);

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) System.out.printf(" %6.2f", mat[i+j*ldm]);
            System.out.printf("\n");
        }
    }

    /* Auxiliary routine: printing a vector of integers */
    static void print_vector(String desc, int n, int[] vec) {
        int j;
        System.out.printf("\n %s\n", desc);
        for (j = 0; j < n; j++) System.out.printf(" %6i", vec[j]);
        System.out.printf("\n");
    }

    /* Main program */
    public static void main(String[] args) {

        /* Locals */
        double[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] B = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] C = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int M, N;

        /* Initialization */
        M = 3;
        N = 3;

        /* Print Matrix */
        print_matrix_rowmajor("Matrix A", M, N, A, M);
        /* Print Matrix */
        print_matrix_rowmajor("Matrix B", M, N, B, M);
        /* Print Matrix */
        print_matrix_rowmajor("Matrix C", M, N, C, M);
        System.out.println();

        /* Executable statements */
        System.out.println("cblas_dgemm Results: A * B = C");
        accelerate.cblas_dgemm(accelerate.CblasRowMajor, accelerate.CblasNoTrans, accelerate.CblasNoTrans, M, N, M, 1, A, M, B, M, 1, C, M);

        /* Print Result Matrix */
        print_matrix_rowmajor("Matrix C", M, N, C, M);

        System.out.println();
        System.exit(0);
    }
}

