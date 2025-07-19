name = ("Pune", "Mumbai", "Delhi", "Goa")
values = [2000, 30000, 4000, 5000]
max_values = max(values)
print(max_values)

print("House Price")
for i in range(len(name)):
    bar_length = int((values[i] / max_values) * 50)
    bar = 'z' * bar_length
    print(f"{name[i]:<12} | {bar} {values[i]:,} INR")
