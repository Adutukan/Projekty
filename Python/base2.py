import ast

begin = input("Czy otworzyć program do baz danych ")
basic = []

if begin != "tak":
    print("Koniec")
    exit()


while begin == "tak":
    print("1-Dodanie danych pracownika")
    print("2-Usunięcie danych pracownika")
    print("3-Otwarcie pliku z pracownikami")
    print("4-Zamknięcię pliku z pracownikami")
    print("5-Pokaż zawartość pliku")
    print("6-Znajdź pracownika zarabiającego najwięcej.")
    print("7-Oblicz średnią płace wszystkich pracowników.")
    print("8-Znajdź najmłodszego pracownika.")
    print("9-Zakończ program")
    add = input("Wybierz opcję: ")
    if add == "1":
        q = input("Imię:")
        w = input("Nazwisko:") 
        e = input("PESEL: ")
        e = int(e)
        r = input("Wiek: ")
        r = int(r)
        t = input("Płaca:")
        t = float(t)
        person = {"Imię":q,"Nazwisko":w, "PESEL":e,"Wiek":r,"Płaca":t}
        print(person)
        basic.append(person)
   
    elif add == "2":
        delated = input("Wprowadz PESEL by usunąć pracownika:")
        delated = int(delated)
        for person in basic:
            if person["PESEL"] == delated:
                basic.remove(person)
                print("Pracownik usunięty")
                print(basic)
            else:
                print("Nie ma takiego pracownika")
                
    elif add =="3":
        file = open("Baza danych.txt" ,'r',encoding='utf-8')
        for k in file:
            z = ast.literal_eval(k.strip()) 
            basic.append(z)
        print("Baza została wczytana")
        
    elif add =="4":
        file = open("Baza danych.txt", 'w',encoding='utf-8')
        for person in basic:
            person = str(person)
            file.write(person +"\n")
        print("Baza się zapisała")         
        
        
    
    elif add == "5":
        for person in basic:
            person = str(person)
            print(person + "\n")
            
    elif add =="6":
        best = max(basic,key = lambda y:y["Płaca"])
        print("Pracownik", {best['Imię']},{best['Nazwisko']}, "ma największe wynagrodzenie z płacą",{best["Płaca"]})
        
    elif add =="7":
        number = 0
        for person in basic:
            x = int(person["Płaca"])
            number = x + number
        print("Średnia płaca w firmie to:",number / len(basic))
            
                
        
    elif add =="8":
        best = min(basic,key = lambda y:y["Wiek"])
        print("Pracownik", {best['Imię']},{best['Nazwisko']}, "jest najmłodszy i ma lat",{best["Wiek"]})
            
    elif add =="9":
        print("Koniec")
        break


    
    
    
        
           

       
        