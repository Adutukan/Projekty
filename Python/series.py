import random

collection = []
series =[]
number = 0

def x(number):
    while number <= 101:
        digt = random.randint(0,1000)
        digt = int(digt)
        number = number + 1
        collection.append(digt)
        if number == 101:
            print("zbiór 1 to:", collection)
        

def y(number):
    while number <= 101:
        digt = random.randint(0,1000)
        digt = int(digt)
        number = number + 1
        series.append(digt)
        if number == 101:
            print("zbiór 2 to:", series)


print(x(number))
print(y(number))

lista = collection + series
lista.sort() 


biggest = lista[:20]
smallest = lista[-20:]

print("Najmniejsze 20 liczb z dwóch list to:",smallest)
print("Największe 20 liczb z dwóch list to:",biggest)