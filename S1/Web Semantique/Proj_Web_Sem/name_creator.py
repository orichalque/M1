import re
f = open("file_2_updated.ttl", 'r');
g = open("file_3.ttl", "w");
for i in range (0, 5):
	g.write(f.readline())
	
for i in range (0, 39):
	str = ""
	id = ""
	str = f.readline()
	match = re.match(":[a-z]+", str)
	print match.group()
	for j in range (1,4):
		f.readline()

