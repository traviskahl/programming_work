import re

values = []
for val in dir(re):
	if "find" in val:
		values.append(val)

print(sorted(values))