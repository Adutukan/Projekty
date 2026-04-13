from FUN2 import sort1,sort2,sort3
import random


testowa_lista = [random.randint(1, 100) for _ in range(50)]

print("Pierwotna lista:", testowa_lista)


wynik_babelkowe = sort1.sortowanie_bąbelkowe(testowa_lista[:]) 
wynik_wstawianie = sort2.sortowanie_przez_wstawianie(testowa_lista[:])
wynik_szybkie = sort3.sortowanie_szybkie(testowa_lista[:])

print("Sortowanie bąbelkowe: ", wynik_babelkowe)
print("Sortowanie przez wstawianie:", wynik_wstawianie)
print("Sortowanie szybkie ", wynik_szybkie)