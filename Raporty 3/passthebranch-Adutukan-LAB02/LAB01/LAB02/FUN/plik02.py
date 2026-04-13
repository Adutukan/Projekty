import time 

def kod2(x):
    start  =  time.perf_counter()
    suma  =  sum(x)
    end  =  time.perf_counter()
    return  end - start