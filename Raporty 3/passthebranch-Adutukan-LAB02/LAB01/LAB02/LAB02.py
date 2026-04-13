import random as random
import time
import numpy as np

x = []
for r in range(40000000):
    x.append(random.randint(1,100))

x_np = np.array(x)

def kod1():
    
    suma = 0
    start = time.perf_counter()
    for x1 in x:
        suma += x1
    
    end = time.perf_counter()
    print("Suma kodu1 wynosi:" ,suma)
    print("Czas obliczania sumy kodu1 wynosi:", end-start)

def kod2():
    start = time.perf_counter()
    suma = sum(x)
    end = time.perf_counter()
    print("Suma kodu2 wynosi:", suma)
    print("Czas obliczania sumy kodu2 wynosi:" , end-start)

def kod3():
    start = time.perf_counter()
    suma = np.sum(x_np)
    end = time.perf_counter()
    print("Suma kodu3 wynosi:", suma)
    print("Czas obliczania sumy kodu3 wynosi:" , end-start)





kod1()
kod2()
kod3()








