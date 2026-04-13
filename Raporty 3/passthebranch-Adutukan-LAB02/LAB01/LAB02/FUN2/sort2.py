def sortowanie_przez_wstawianie(lista):
    for i in range(1, len(lista)):
        klucz = lista[i]
        j = i - 1
        while j >= 0 and klucz < lista[j]:
            lista[j + 1] = lista[j]
            j -= 1
        lista[j + 1] = klucz
    return lista
