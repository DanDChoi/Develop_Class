#Operator 
#1 산술
a = 1/2
print("a: ", a)
print("int(a): ", int(a))
print()

b = 1//2
print("b: ", b)
print()

c = 2**3 #2의 3승
print("c: ", c)
print()

#2 논리
d = True and True
print("d: ", d)
e =  True and False
print("e: ", e)
f =  not True
print("f: ", f)
print()

#3 identity (is, is not)
g = "김치"
h = 10
i = g is not h #the same object?
print("i: ", i)
print()

#4 Membership (in, not in)
li = ["a", "b", "c"]
j = "d" not in li
print("j: ", j)
