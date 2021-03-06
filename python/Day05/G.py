import turtle as t

def r():
    t.setheading(0)
    t.forward(10)
def u():
    t.setheading(90)
    t.forward(10)
def l():
    t.setheading(180)
    t.forward(10)
def d():
    t.setheading(270)
    t.forward(10)
    
def pUp(): t.penup()
def pDown(): t.pendown()

def red(): t.color("red")
def green(): t.color("green")
def blue(): t.color("blue")
def yellow(): t.color("yellow")
def black(): t.color("black")
    
t.shape("turtle")
t.onkeypress(r, "Right")
t.onkeypress(u, "Up")
t.onkeypress(l, "Left")
t.onkeypress(d, "Down")

t.onkeypress(pUp, "u")
t.onkeypress(pDown, "d")

t.onkeypress(red, "r")
t.onkeypress(green, "g")
t.onkeypress(blue, "b")
t.onkeypress(yellow, "y")
t.onkeypress(black, "k")


t.listen()
t.exitonclick()
