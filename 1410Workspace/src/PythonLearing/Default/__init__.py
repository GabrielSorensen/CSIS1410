#Single-Line Comment
'''Multi-Line Comment
stuff
stuff
End Comment
''' 
print("Code gets its own lines")
print("And printing is simple")
#Variables are Easy!
a = 0
b = 1
c = "2"
print(a+b+int(c))
#Casting is done by VarType(VariableToBeCasted)
'''
int() unlimited length integer
str() unlimited length string
float() decimal number
print (3 + 4) +    7
print (3 - 4) -    -1
print (3 * 4) *    12
print (3 / 4) /    .075
print (3 % 2) mod    1
print (3 ** 4) # 3 to the fourth power    81    
print (3 // 4) #floor division  devide&round down    0
+ can concate strings
a +=2 add two just like java 
'''
if a >= 22:
    print("less or equal to")
elif a<=11:
    print("Else if ()")
else:
    print("Else")
    print("still else")
print("Non conditional")
'''
after every conditional there is a colon :
code to be run in the conditionals must be spaced the same
'''
def aFunction(): #define the function
    print("In a function")
aFunction() # Call out function
def Function2():
    print(a) # calls
Function2()
for i in range(1, 5):
    print(i)  #0,1,2,3,4 for loop i from 0 to 4
i = 1
while i <= 10:
    print(i)
    i +=1 #1,2,3,4,5,6,7,8,9 while loop
myString = ""
print (type(myString)) # prints the type of variable in the prens
'''
stringVar.count('x') - counts the number of occurrences of 'x' in stringVar
stringVar.find('x') - returns the position of character 'x'
stringVar.lower() - returns the stringVar in lowercase (this is temporary)
stringVar.upper() - returns the stringVar in uppercase (this is temporary)
stringVar.replace('a', 'b') - replaces all occurrences of a with b in the string
stringVar.strip() - removes leading/trailing white space from string
a = "string"
print (a[1:3])  tr
print (a[:-1])  strin
'''
sampleList = [1,2,3,4,5,6,7,8]
print (sampleList[1])  #2
for a in sampleList:
    print(a) #1,2,3,4,5,6,7,8
'''
list.
.append(value) - appends element to end of the list
.count('x') - counts the number of occurrences of 'x' in the list
.index('x') - returns the index of 'x' in the list
.insert('y','x') - inserts 'x' at location 'y'
.pop() - returns last element then removes it from the list
.remove('x') - finds and removes first 'x' from list
.reverse() - reverses the elements in the list
.sort() - sorts the list alphabetically in ascending order, or numerical in ascending order
'''
alist = [1,2,3]
alist.append(4)
print(alist)
aTuple = (1,2,3)
#cant append to tuples, they are immutible
alist = list(aTuple)
alist.append(6)
print(alist)
#dictionaries store variables by keys eg 'someItem': value, call them by the key, 
#not by value or index
myExample = {'someItem': 2, 'otherItem': 20}
print(myExample['otherItem'])
# Look more into dictionaries
var1 = '1' 
try:
    var1 = var1 + 1 # since var1 is a string, it cannot be added to the number 1 
except:
    print(var1, " is not a number") #so we execute this
    var2 = int(var1) + 1 
print(var2)
#lets pretend we have a file file.txt
f = open("file.txt", "r") #open that file! r for read w for write
print(f.read(1)) #This method reads n number of characters from the file,
# or if n is blank it reads the entire file. 
print(f.readline()) #This method reads an entire line from the text file.
myList = []
for line in f:
    myList.append(line) 
f.close()  #always close resources!!!!!!
f = open("test.txt","w") #opens file with name of "test.txt"
#the write will nuke the file so always know what the hell you are doing
f.write("words and then new line-->\n") #write that string or a string var to the file
f.close()
f = open("test.txt","a") #opens file with name of "test.txt"
# the a will append the write method to the file
f.write("and can I get some pickles on that?")
f.close()















