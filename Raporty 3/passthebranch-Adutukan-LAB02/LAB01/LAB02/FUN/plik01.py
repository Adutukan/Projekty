import time 


def kod1(x):
    suma  =  0
    start  =  time.perf_counter()
    for  x1  in  x:
        suma += x1
    end  =  time.perf_counter()
    return  end - start