import sys

matrix = []

i = 0
with open('c:\\users\\home\\desktop\\table.txt', 'r') as openfile:
    for line in openfile:
        matrix.append([])
        num = [(n) for n in line.split('x')]

        num.pop()  # Remove the /n digit
        matrix[i] = num

        i += 1

openfile.close()


for rowIndex, h in enumerate(matrix):
    for colIndex, w in enumerate(h):
        print "table[{}][{}] = {};".format(rowIndex, colIndex, w)
