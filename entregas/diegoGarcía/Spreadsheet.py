import string

class Spreadsheet:

    
    letters = list(string.ascii_uppercase) 

    def createSpreadsheet(cases,letters,userRow,userColumn):
        
        columnSymbol = '|'
        rowSymbol = '     +---------+---------+---------+---------+---------+---------+---------+---------+---------+---------+'

        for row in range (10):
            print('       ', *letters[row] , end=' ')
        print()

        print(rowSymbol)

        for row in range (15):
            print(str(row+1).zfill(2), end='   ')
            for column in range (10):
                if row == userRow and column == userColumn:
                    print(columnSymbol + '['+cases[userRow][userColumn], end=']')
                else:
                    print(columnSymbol +' '+cases[row][column], end=' ')
            print(columnSymbol)
            
        print(rowSymbol)

        

        return userRow, userColumn
        
    def createCases():
        cases = []
        for i in range(15):
            cases.append(['       '] * 15)

        return cases

    def menu(letters, cases, userRow, userColumn):
        print('Actual case: [' , letters[userColumn] + str(userRow),']')
        print('Use "WASD" to move the case')
        print('Use "E" to write in the case')
        print('Use "Q" to exit')
        userOption = input('Introduce an option: ').upper()
        return



    cases = createCases()
    exit = False
    userRow = 0
    userColumn = 0

    while exit == False:
        createSpreadsheet(cases,letters,userRow,userColumn)
 
        Election = menu(letters, cases, userRow, userColumn)
        if Election == 'Q':
            break
        elif Election == 'W':
            userRow -= 1
        elif Election == 'A':
            userColumn -= 1
        elif Election == 'S':
            userRow += 1
        elif Election == 'D':
            userColumn += 1
        elif Election == 'E':
            cases[userRow][userColumn] = input('Introduce the text: ')
    

        

    


        




    
