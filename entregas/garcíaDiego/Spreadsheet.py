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
        print('Actual case: [' , letters[userColumn] + str(userRow+1),']')
        print('Use "WASD" to move the case')
        print('Use "E" to write in the case')
        print('Use "Q" to exit')
        userOption = input('Introduce an option: ').upper()
        return userOption




    cases = createCases()
    exit = False
    userRow = 0
    userColumn = 0
    createSpreadsheet(cases,letters,userRow,userColumn)

    while exit == False:
        userElection = menu(letters, cases, userRow, userColumn)
        if userElection == 'W':
            userRow -= 1
        elif userElection == 'S':
            userRow += 1
        elif userElection == 'A':
            userColumn -= 1
        elif userElection == 'D':
            userColumn += 1
        elif userElection == 'E':
            cases[userRow][userColumn] = input('Introduce a value: ')
            if len(cases[userRow][userColumn]) > 7:
                cases[userRow][userColumn] = cases[userRow][userColumn][:7]
            elif len(cases[userRow][userColumn]) < 7:
                cases[userRow][userColumn] = cases[userRow][userColumn].ljust(7)
        elif userElection == 'Q':
            exit = True
        else:
            print('Wrong option')

        createSpreadsheet(cases,letters,userRow,userColumn)