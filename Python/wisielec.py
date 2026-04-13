basic = []
question =[]
twoje_litery=[]
number = 0
liczba_prób = 0



print("Witaj w grze wisielec. Na początek jedna osoba wpisuje słowo")
print("Pozostałe osoby nie widzą co pisze dana osoba")
print("Gdy osoba wpisze słowo, pozostałe osoby odgadują")
print("Mają na to 6 błędnych odpowiedzi")
word = input("Napisz słowo małymi literami:")
word = str(word)
group = len(word)
for k in word:
    if number > 10:
        print("Twoje słowo jest za długie")
        exit()
    basic.append(k)
    number = number + 1
for k in word:
    word1 = "-"
    question.append(word1)


while liczba_prób <= 5:
    print("Twoje litery to:",twoje_litery)
    print("Odkryte litery to:",question)
    print("Liczba nieprawidłowych odpowiedzi:",liczba_prób)
    sign = input("Twój znak:")
    if len(sign) != 1:
        print("Podaj Jeden znak")
        continue
    if sign in twoje_litery:
        print("Masz już ten znak")
        continue
    if group == 0:
        print("")
    if sign in basic:
        for i in range(len(question)):
            if basic[i] == sign:
                question[i] = sign
                group = group - 1
        print("Świetnie odgadłeś znak")
    else:
        print('Żle')
        liczba_prób = liczba_prób + 1
    twoje_litery.append(sign)
    if group == 0:
        print("Wygrałeś")
        print("Odkryte słowo to:", basic)
        exit()

if liczba_prób > 5:
    print("Przegrałeś")
    print("Liczba nieprawidłowych odpowiedzi to: 6")
    print("Słowo do odgadnięcia to było",basic)
   
    
            
            
    
    
    
    
        
    
    
    








