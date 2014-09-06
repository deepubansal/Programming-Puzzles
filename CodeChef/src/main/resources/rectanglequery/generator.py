from random import randint
count = 0
for w in range(1000):
	x1 = randint(1,100000)
	y1 = randint(1,100000)
	x2 = randint(x1,1000000)
	y2 = randint(y1,1000000)

	print 'I'+ ' ' + str(x1)+ ' ' + str(y1)+ ' ' + str(x2)+ ' ' + str(y2)
	count += 1
	if w%randint(5,9) == 0:
		x1 = randint(1,100000)
		y1 = randint(1,100000)
		x2 = randint(x1,1000000)
		y2 = randint(y1,1000000)
		print 'Q'+ ' ' + str(x1)+ ' ' + str(y1)+ ' ' + str(x2)+ ' ' + str(y2)
		count += 1
	if w%randint(2,9) == 0:
		x1 = randint(1,w+1)
		print 'D'+ ' ' + str(x1)
		count += 1
print count