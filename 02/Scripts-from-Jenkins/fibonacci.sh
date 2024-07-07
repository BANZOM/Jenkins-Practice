#!/bin/bash

# Fibonacci series
N=${1:-1}

a=0
b=1

for (( i=0; i<N; i++ )); do
    echo -e "$i\t$a"
    fn=$((a + b))
    a=$b
    b=$fn
done