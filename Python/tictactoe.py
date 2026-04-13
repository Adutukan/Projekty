import random
 

play = [' ' for _ in range(9)]
 

def choice(play, sign):
   
    x = [i for i, z in enumerate(play) if z == ' ']
    y = random.choice(x)
    play[y] = sign
    
def game(play):
    print(f'{play[0]} | {play[1]} | {play[2]}')
    print('--|---|--')
    print(f'{play[3]} | {play[4]} | {play[5]}')
    print('--|---|--')
    print(f'{play[6]} | {play[7]} | {play[8]}')
 
def winner(play, sign):
    pool = [
        [0,3,6],[1,4,7],[0,4,8],[2,4,6],[2,5,8],[0,1,2],[3,4,5],[6,7,8]             
    ]
 
    for set in pool :
        if all(play[i] == sign for i in set):
            return True
    return False


 

print("Witaj w grze w Kółko i Krzyżyk!")
your_sign = input("Wybierz o lub x: ")
    
 
if your_sign == 'x':
    computer_sign = 'o'
else:
    computer_sign = 'x'
 
start = input("Wpisz T jak chcesz zacząć lub U to zacznie urządzenie ")
 
 
turn = (start == 'T')
     
while True:
    game(play)
 
    if turn:
       
        number = int(input("Umieść swój symbol wpisując liczbę z zakresu od 1 do 9 ")) - 1
        if play[number] == ' ':
            play[number] = your_sign
            turn = False
        else:
            print("Zajęte pole. Wybierz inne.")
        
            
    else:
        print("Zagranie komputera")
        choice(play, computer_sign)
        turn = True
 
    if winner(play, your_sign):
        game(play)
        print("Zwyciężyłeś")
        break
    elif winner(play, computer_sign):
        game(play)
        print("Przegrałeś. Spróbuj jeszcze raz!")
        break
    elif ' ' not in play:
        game(play)
        print("Remis!")
        break
 
