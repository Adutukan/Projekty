def sortowanie_szybkie(lista):
    if len(lista) <= 1:
        return lista
    else:
        pivot = lista[len(lista) // 2] 
        lewe = [x for x in lista if x < pivot]
        srodkowe = [x for x in lista if x == pivot]
        prawe = [x for x in lista if x > pivot]
        return sortowanie_szybkie(lewe) + srodkowe + sortowanie_szybkie(prawe)