# Experiments on JavaCPP

```
cd JavaCPP
./gradlew run
```

It should print out
```
 Matrix A
   1.00   2.00   3.00
   4.00   5.00   6.00
   7.00   8.00   9.00

 Matrix B
   1.00   2.00   3.00
   4.00   5.00   6.00
   7.00   8.00   9.00

 Matrix C
   0.00   0.00   0.00
   0.00   0.00   0.00
   0.00   0.00   0.00

cblas_dgemm Results: A * B = C

 Matrix C
  30.00  36.00  42.00
  66.00  81.00  96.00
 102.00 126.00 150.00

```