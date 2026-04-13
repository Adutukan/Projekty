import time  ;import numpy as np

def kod3(macierz):
    start  =  time.perf_counter()
    suma  =  np.sum(macierz)
    end  =  time.perf_counter()
    return  end - start