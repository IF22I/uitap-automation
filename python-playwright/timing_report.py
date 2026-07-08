import subprocess
import time


runs = 3
durations = []

for i in range(runs):
    print(f"\n===== Run {i + 1} of {runs} =====")
    start = time.time()
    subprocess.run(["pytest", "tests/", "-v"])
    elapsed = time.time() - start
    durations.append(elapsed)
    print(f"Run {i + 1} took {elapsed:.2f} seconds")

average = sum(durations) / len(durations)

print("\n========== SUMMARY ==========")
for i, d in enumerate(durations):
    print(f"Run {i + 1}: {d:.2f}s")
print(f"Average: {average:.2f}s")