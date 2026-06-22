```markdown
# UITAP Automation Portfolio

**Learner:** [Your Name]  
**Period:** [Start date] → [End date]  
**Primary stack:** Python + Playwright  
**Shadow stack:** Java + Selenium  
**Repository:** [GitHub link]  

## How to Run

### Python (Playwright)
```bash
cd python-playwright
source .venv/bin/activate
pytest -v                          # all tests
pytest -m smoke                    # smoke only
allure serve reports/allure-results   # Allure report (Week 9+)
```

### Java (Selenium)
```bash
cd java-selenium
mvn test                           # all tests
allure serve target/allure-results    # Allure report (Week 9+)
```

## Progress

| # | Exercise | Core Concept | Python | Java | Week | Notes |
|---|---|---|:---:|:---:|---|---|
| 01 | Click | Basic interaction | ✅ | ✅ | 1 | |
| 02 | Text Input | Form fields | ✅ | ✅ | 2 | |
| 03 | Verify Text | Text assertions | ✅ | ✅ | 2 | |
| 04 | Dynamic ID | Stable locators | ✅ | ✅ | 2 | |
| 05 | Class Attribute | CSS selectors | 🔄 | ⬜ | 3 | |
| 06 | Visibility | Element state | ⬜ | ⬜ | 3 | |
| 07 | Load Delay | Explicit waits | ⬜ | ⬜ | 4 | |
| 08 | AJAX Data | Async waits | ⬜ | ⬜ | 4 | |
| 09 | Client Side Delay | JS waits | ⬜ | ⬜ | 4 | |
| 10 | Progress Bar | Polling | ⬜ | ⬜ | 5 | |
| 11 | Scrolling | Viewport | ⬜ | ⬜ | 5 | |
| 12 | Overlapped Element | Actionability | ⬜ | ⬜ | 5 | |
| 13 | Sample App | E2E scenario | ⬜ | ⬜ | 6 | |
| 14 | Mouse Over | Hover | ⬜ | ⬜ | 7 | |
| 15 | Hidden Layers | Z-index | ⬜ | ⬜ | 7 | |
| 16 | Non-Breaking Space | Text gotchas | ⬜ | ⬜ | 7 | |
| 17 | Dynamic Table | Table iteration | ⬜ | ⬜ | 8 | |
| 18 | Alerts | Dialog handling | ⬜ | ⬜ | 8 | |
| 19 | Disabled Input | State testing | ⬜ | ⬜ | 8 | |
| 20 | Animated Button | Race conditions | ⬜ | ⬜ | 10 | |
| 21 | File Upload | File input | ⬜ | ⬜ | 10 | |
| 22 | Shadow DOM | Web Components | ⬜ | ⬜ | 11 | |

**Legend:** ✅ Done · 🔄 In Progress · ⬜ Not started

## Architecture Decisions
- [Document interesting choices as you make them]
- e.g. "Using CSS selectors over XPath by default — more readable and less brittle"

## Week-by-Week Reflections
### Week 1
- ...
### Week 2
- ...
```